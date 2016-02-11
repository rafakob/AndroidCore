package io.tsh.androidcore.main;

import dagger.Subcomponent;
import io.tsh.androidcore.core.scopes.PerActivity;

@PerActivity
@Subcomponent(
        modules = MainActivityModule.class
)
public interface MainActivityComponent {
    void inject(MainActivity mainActivity);
}
