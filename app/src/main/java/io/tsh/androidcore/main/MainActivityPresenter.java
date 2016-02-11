package io.tsh.androidcore.main;

import javax.inject.Inject;

import io.tsh.androidcore.Prefs;
import io.tsh.androidcore.api.ApiService;
import io.tsh.androidcore.api.models.BuildType;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import timber.log.Timber;

public class MainActivityPresenter {
    private final MainActivityView view;
    private final ApiService apiService;
    private final Prefs prefs;

    @Inject
    public MainActivityPresenter(MainActivityView view, ApiService apiService, Prefs prefs) {
        this.view = view;
        this.apiService = apiService;
        this.prefs = prefs;
    }

    public void getBuildType() {
        apiService.getBuildType()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::handleBuildType, this::handleError);
    }

    private void handleBuildType(BuildType buildType) {
        view.updateBuildType(buildType.api);
    }

    private void handleError(Throwable throwable) {
        Timber.e(throwable.getMessage());
    }
}
