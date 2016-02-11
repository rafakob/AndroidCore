package io.tsh.androidcore.database;

import com.google.common.base.Stopwatch;

import java.util.List;
import java.util.concurrent.TimeUnit;

public abstract class DatabaseBenchmark {
    protected String timeElapsed;
    private Stopwatch stopwatch;

    public DatabaseBenchmark() {
    }

    public abstract void save(List<Person> data);

    public String timeElapsed() {
        return timeElapsed;
    }

    protected void startStopWatch(){
        stopwatch = Stopwatch.createStarted();
    }

    protected void stopStopWatch(){
        stopwatch.stop();
        timeElapsed = String.valueOf(stopwatch.elapsed(TimeUnit.MILLISECONDS));
    }
}

