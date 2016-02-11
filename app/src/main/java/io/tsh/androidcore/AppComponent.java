package io.tsh.androidcore;
import dagger.Component;
import io.tsh.androidcore.core.scopes.PerApp;

@PerApp
@Component(
        modules = {
                AppModule.class,
                NetworkModule.class,
        }
)
public interface AppComponent {
}