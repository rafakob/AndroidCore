package io.tsh.androidcore.database;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class PersonRealm extends RealmObject {
    @PrimaryKey
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private String ipAddress;

    public PersonRealm() {
    }

    public PersonRealm(Person person) {
        this.id = person.id;
        this.firstName = person.firstName;
        this.lastName = person.lastName;
        this.email = person.email;
        this.gender = person.gender;
        this.ipAddress = person.ipAddress;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }
}
