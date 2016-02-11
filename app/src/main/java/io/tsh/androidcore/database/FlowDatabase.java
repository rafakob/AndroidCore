package io.tsh.androidcore.database;

import com.raizlabs.android.dbflow.annotation.Database;

@Database(name = FlowDatabase.NAME, version = FlowDatabase.VERSION)
public class FlowDatabase {

    public static final String NAME = "Flow";

    public static final int VERSION = 1;
}