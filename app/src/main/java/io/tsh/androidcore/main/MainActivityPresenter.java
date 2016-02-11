package io.tsh.androidcore.main;

import android.content.Context;

import java.util.List;

import javax.inject.Inject;

import io.realm.Realm;
import io.tsh.androidcore.Prefs;
import io.tsh.androidcore.api.ApiService;
import io.tsh.androidcore.api.models.BuildType;
import io.tsh.androidcore.database.DatabaseBenchmarkFlow;
import io.tsh.androidcore.database.DatabaseBenchmarkRealm;
import io.tsh.androidcore.database.DatabaseBenchmarkSnappy;
import io.tsh.androidcore.database.Person;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import timber.log.Timber;

public class MainActivityPresenter {
    private final MainActivityView view;
    private final ApiService apiService;
    private final Prefs prefs;
    private Realm realm;
    private List<Person> data;

    @Inject
    public MainActivityPresenter(MainActivityView view, ApiService apiService, Prefs prefs, Realm realm) {
        this.view = view;
        this.apiService = apiService;
        this.prefs = prefs;
        this.realm = realm;
    }

    public void getBuildType() {
        apiService.getBuildType()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::handleBuildType, this::handleError);
    }

    private void handleBuildType(BuildType buildType) {
        view.updateBuildType(buildType.api);
        prefs.putBuildType(buildType.api);
    }

    private void handleError(Throwable throwable) {
        Timber.e(throwable.getMessage());
    }

    public void getPersonData() {
        apiService.getPersons()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(persons -> data = persons, this::handleError);
    }


    public void runSnappy(Context context) {
        DatabaseBenchmarkSnappy databaseBenchmarkSnappy = new DatabaseBenchmarkSnappy(context);
        databaseBenchmarkSnappy.save(data);
        view.updateTimeSnappy(databaseBenchmarkSnappy.timeElapsed());
    }

    public void runDbFlow(Context context) {
        DatabaseBenchmarkFlow databaseBenchmarkFlow = new DatabaseBenchmarkFlow(context);
        databaseBenchmarkFlow.save(data);
        view.updateTimeDbFlow(databaseBenchmarkFlow.timeElapsed());
    }

    public void runRealm() {
        DatabaseBenchmarkRealm databaseBenchmarkRealm = new DatabaseBenchmarkRealm(realm);
        databaseBenchmarkRealm.save(data);
        view.updateTimeRealm(databaseBenchmarkRealm.timeElapsed());
    }

}
