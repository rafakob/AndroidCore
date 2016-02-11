package io.tsh.androidcore;

import android.app.Application;

import dagger.Module;
import dagger.Provides;
import io.tsh.androidcore.core.scopes.PerApp;

@Module
public class AppModule {

    private Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Provides
    @PerApp
    Application providesApplication() {
        return application;
    }

    @Provides
    @PerApp
    Prefs providesPrefs() {
        return new Prefs();
    }
}
