package io.tsh.androidcore.database;

import android.content.Context;

import com.raizlabs.android.dbflow.runtime.DBTransactionInfo;
import com.raizlabs.android.dbflow.runtime.TransactionManager;
import com.raizlabs.android.dbflow.runtime.transaction.QueryTransaction;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.List;

import javax.inject.Inject;


public class DatabaseBenchmarkFlow extends DatabaseBenchmark {
    private final Context context;

    @Inject
    public DatabaseBenchmarkFlow(Context context) {
        this.context = context;
    }

    @Override
    public void save(List<Person> data) {
        TransactionManager.getInstance().addTransaction(new QueryTransaction(DBTransactionInfo.create(),
                SQLite.delete().from(Person.class)));

        startStopWatch();

        TransactionManager.transact(FlowDatabase.NAME, () -> {
            for (Person model : data) model.save();
        });

        stopStopWatch();
    }


}
