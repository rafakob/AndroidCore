package io.tsh.androidcore;

import android.app.Application;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;
import io.tsh.androidcore.core.scopes.PerApp;

@Module
public class DatabaseModule {
    @Provides
    @PerApp
    Realm providesRealm(Application application) {
        return Realm.getInstance(application.getApplicationContext());
    }
}
