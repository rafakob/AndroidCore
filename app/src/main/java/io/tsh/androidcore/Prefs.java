package io.tsh.androidcore;


import com.orhanobut.hawk.Hawk;

public class Prefs {
    // Field and methods are generated with Live Template
    private static final String BUILD_TYPE = "BUILD_TYPE";

    public String getBuildType() {
        return Hawk.get(BUILD_TYPE, "debug");
    }

    public void putBuildType(String stringArg) {
        Hawk.put(BUILD_TYPE, stringArg);
    }
}
