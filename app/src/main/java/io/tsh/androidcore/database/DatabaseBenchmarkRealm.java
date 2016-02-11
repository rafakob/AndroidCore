package io.tsh.androidcore.database;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.realm.Realm;


public class DatabaseBenchmarkRealm extends DatabaseBenchmark {
    private final Realm realm;

    @Inject
    public DatabaseBenchmarkRealm(Realm realm) {
        this.realm = realm;
    }

    @Override
    public void save(List<Person> data) {
        List<PersonRealm> list = new ArrayList<>();
        for (Person person : data)
            list.add(new PersonRealm(person));


        startStopWatch();

        realm.beginTransaction();
        realm.copyToRealmOrUpdate(list);
        realm.commitTransaction();


        stopStopWatch();
    }


}
