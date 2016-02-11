package io.tsh.androidcore;

import android.app.Application;
import android.content.Context;

import com.facebook.stetho.Stetho;
import com.orhanobut.hawk.Hawk;
import com.orhanobut.hawk.HawkBuilder;
import com.raizlabs.android.dbflow.config.FlowManager;

import timber.log.Timber;

public class App extends Application {

    private AppComponent appComponent;

    public static App get(Context context) {
        return (App) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initUtilities();
        initAppComponent();
    }

    private void initUtilities() {
//        if (BuildConfig.DEBUG)
        Timber.plant(new Timber.DebugTree());

        FlowManager.init(this);
        Stetho.initializeWithDefaults(this);

        // Encrypted shared prefs wrapper - not perfect but better than plain text...
        Hawk.init(this)
                .setEncryptionMethod(HawkBuilder.EncryptionMethod.MEDIUM)
                .setStorage(HawkBuilder.newSharedPrefStorage(this))
                .build();
    }

    private void initAppComponent() {
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .networkModule(new NetworkModule())
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
