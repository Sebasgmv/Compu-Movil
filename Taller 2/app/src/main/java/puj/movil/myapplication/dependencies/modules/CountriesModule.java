package puj.movil.myapplication.dependencies.modules;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import lombok.AllArgsConstructor;
import puj.movil.myapplication.services.CountriesService;

@Module
@AllArgsConstructor
public class CountriesModule {
    private final Application application;

    @Provides
    @Singleton
    Application providesApplication(){
        return application;
    }

    @Provides
    public CountriesService provideCountriesService() {
        return new CountriesService(application.getApplicationContext());
    }
}
