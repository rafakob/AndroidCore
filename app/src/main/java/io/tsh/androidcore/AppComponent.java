package io.tsh.androidcore;

import dagger.Component;
import io.tsh.androidcore.core.scopes.PerApp;
import io.tsh.androidcore.database.DatabaseBenchmark;
import io.tsh.androidcore.main.MainActivityComponent;
import io.tsh.androidcore.main.MainActivityModule;

@PerApp
@Component(
        modules = {
                AppModule.class,
                NetworkModule.class,
                DatabaseModule.class
        }
)
public interface AppComponent {
    MainActivityComponent plus(MainActivityModule mainActivityModule);
    void inject(DatabaseBenchmark databaseBenchmark);
}