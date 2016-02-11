package io.tsh.androidcore.api;


import java.util.List;

import io.tsh.androidcore.api.models.BuildType;
import io.tsh.androidcore.database.Person;
import retrofit2.http.GET;
import rx.Observable;

public interface ApiService {
    String PRODUCTION_URL = "http://jsonstub.com";
    String DEBUG_URL = "http://www.mocky.io";

    @GET("/v2/56bc575b1100003935f6654a")
    Observable<BuildType> getBuildType();

    @GET("/persons")
    Observable<List<Person>> getPersons();
}
