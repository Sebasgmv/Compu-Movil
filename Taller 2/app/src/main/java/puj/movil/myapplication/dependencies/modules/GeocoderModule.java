package puj.movil.myapplication.dependencies.modules;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import lombok.AllArgsConstructor;
import puj.movil.myapplication.services.GeocoderService;

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
