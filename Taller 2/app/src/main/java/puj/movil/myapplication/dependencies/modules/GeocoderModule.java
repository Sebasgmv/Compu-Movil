package edu.puj.mapas.dependencies.modules;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import edu.puj.mapas.services.GeocoderService;
import lombok.AllArgsConstructor;

@Module
@AllArgsConstructor
public class GeocoderModule {
    private final Application application;

    @Provides
    @Singleton
    Application providesApplication(){
        return application;
    }

    @Provides
    public GeocoderService provideGeoCoderService() {
        return new GeocoderService(application.getApplicationContext());
    }
}
