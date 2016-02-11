package io.tsh.androidcore.main;

import dagger.Module;
import dagger.Provides;
import io.tsh.androidcore.Prefs;
import io.tsh.androidcore.api.ApiService;
import io.tsh.androidcore.core.scopes.PerActivity;

@Module
public class MainActivityModule {

    private MainActivityView mainActivityView;

    public MainActivityModule(MainActivityView mainActivityView) {
        this.mainActivityView = mainActivityView;
    }

    @Provides
    @PerActivity
    MainActivityView providesMainActivityView() {
        return mainActivityView;
    }

    @Provides
    @PerActivity
    MainActivityPresenter providesMainActivityPresenter(MainActivityView mainActivityView, ApiService apiService, Prefs prefs) {
        return new MainActivityPresenter(mainActivityView, apiService, prefs);
    }
}
