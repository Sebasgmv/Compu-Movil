package puj.movil.myapplication.dependencies.modules;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import lombok.AllArgsConstructor;
import puj.movil.myapplication.services.GeoInfoFromJsonService;

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
