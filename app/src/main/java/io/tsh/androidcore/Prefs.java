package io.tsh.androidcore;


import com.orhanobut.hawk.Hawk;

public class Prefs {
    // Field and methods are generated with Live Template
    private static final String USERNAME = "USERNAME";

    public String getUsername() {
        return Hawk.get(USERNAME, "Rafal");
    }

    public void putUsername(String stringArg) {
        Hawk.put(USERNAME, stringArg);
    }
}
