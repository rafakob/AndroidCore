package io.tsh.androidcore.database;

import android.content.Context;

import com.snappydb.DB;
import com.snappydb.DBFactory;
import com.snappydb.SnappydbException;

import java.util.List;

import javax.inject.Inject;

import timber.log.Timber;


public class DatabaseBenchmarkSnappy extends DatabaseBenchmark {
    private final Context context;

    @Inject
    public DatabaseBenchmarkSnappy(Context context) {
        this.context = context;
    }

    @Override
    public void save(List<Person> data) {
        try {
            startStopWatch();

            DB snappydb = DBFactory.open(context);
            snappydb.put("array", data.toArray());
            snappydb.close();

            stopStopWatch();

        } catch (SnappydbException e) {
            stopStopWatch();
            Timber.e(e.getMessage());
        }
    }


}
