package edu.puj.mapas.dependencies.modules;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import edu.puj.mapas.services.GeoInfoFromJsonService;
import lombok.AllArgsConstructor;

@Module
@AllArgsConstructor
public class GeoInfoModule {
    private final Application application;

    @Provides
    @Singleton
    Application providesApplication(){
        return application;
    }

    @Provides
    public GeoInfoFromJsonService provideGeoInfoService() {
        return new GeoInfoFromJsonService(application.getApplicationContext());
    }
}
