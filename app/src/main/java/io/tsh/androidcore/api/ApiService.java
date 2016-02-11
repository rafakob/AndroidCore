package io.tsh.androidcore.api;


import retrofit2.http.GET;
import rx.Observable;

public interface ApiService {
    String PRODUCTION_URL = "http://jsonstub.com";
    String DEBUG_URL = "http://www.mocky.io";

    @GET("/v2/56bc575b1100003935f6654a")
    Observable<String> getMock();
}
