package puj.movil.myapplication.dependencies.modules;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import lombok.AllArgsConstructor;
import puj.movil.myapplication.services.LocationService;

@Module
@AllArgsConstructor
public class LocationModule {
    private final Application application;

    @Provides
    @Singleton
    Application providesApplication(){
        return application;
    }

    @Provides
    public LocationService provideLocationService() {
        return new LocationService(application.getApplicationContext());
    }
}
