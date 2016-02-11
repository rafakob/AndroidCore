package io.tsh.androidcore;

import dagger.Component;
import io.tsh.androidcore.core.scopes.PerApp;
import io.tsh.androidcore.main.MainActivityComponent;
import io.tsh.androidcore.main.MainActivityModule;

@PerApp
@Component(
        modules = {
                AppModule.class,
                NetworkModule.class,
        }
)
public interface AppComponent {
    MainActivityComponent plus(MainActivityModule mainActivityModule);
}