package io.tsh.androidcore;

import android.app.Application;

import java.net.CookieManager;
import java.net.CookiePolicy;

import dagger.Module;
import dagger.Provides;
import io.tsh.androidcore.api.ApiService;
import io.tsh.androidcore.core.network.PersistentCookieStore;
import io.tsh.androidcore.core.scopes.PerApp;
import okhttp3.Interceptor;
import okhttp3.JavaNetCookieJar;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes = ApiModule.class)
public class NetworkModule {
    public NetworkModule() {
    }

    @Provides
    @PerApp
    CookieManager providesCookieManager(Application app) {
        return new CookieManager(new PersistentCookieStore(app.getApplicationContext()), CookiePolicy.ACCEPT_ALL);
    }

    @Provides
    @PerApp
    Interceptor providesJsonStubInterceptor() {
        return chain -> chain.proceed(chain.request())
                .newBuilder()
                .addHeader("JsonStub-User-Key", "1bc4ae51-ff97-49e0-b0aa-8c1548773ca4")
                .addHeader("JsonStub-Project-Key", "a2e42ceb-5a4b-43b2-8e39-ba1bcc013d1d")
                .build();
    }

    @Provides
    @PerApp
    OkHttpClient providesOkHttpClient(CookieManager cookieManager, HttpLoggingInterceptor httpLoggingInterceptor, Interceptor jsonStubInterceptor) {
        return new OkHttpClient.Builder()
                .cookieJar(new JavaNetCookieJar(cookieManager))
                .addNetworkInterceptor(jsonStubInterceptor)
                .addInterceptor(httpLoggingInterceptor)
                .build();
    }

    @Provides
    @PerApp
    Retrofit providesRetrofit(String baseUrl, OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(okHttpClient)
                .build();
    }

    @Provides
    @PerApp
    ApiService providesApiService(Retrofit retrofit) {
        return retrofit.create(ApiService.class);
    }
}
