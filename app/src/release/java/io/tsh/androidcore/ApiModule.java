package io.tsh.androidcore;

import dagger.Module;
import dagger.Provides;
import io.tsh.androidcore.api.ApiService;
import io.tsh.androidcore.core.scopes.PerApp;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Module contains dependencies specific for a selected build type.
 */
@Module
public class ApiModule {
    @Provides
    @PerApp
    String providesBaseUrl() {
        return ApiService.PRODUCTION_URL;
    }

    @Provides
    @PerApp
    HttpLoggingInterceptor providesLoggingInterceptor() {
        // Disable logging in release
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
        return loggingInterceptor;
    }
}
