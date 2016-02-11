package io.tsh.androidcore.database;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;


@Table(database = FlowDatabase.class)
public class Person extends BaseModel {
    @PrimaryKey(autoincrement = true)
    public long id;
    @Column
    public String firstName;
    @Column
    public String lastName;
    @Column
    public String email;
    @Column
    public String gender;
    @Column
    public String ipAddress;

    public Person() {
    }
}
