package puj.movil.myapplication;

import android.app.Application;

import lombok.Getter;
import puj.movil.myapplication.dependencies.components.ApplicationComponent;
import puj.movil.myapplication.dependencies.components.DaggerApplicationComponent;
import puj.movil.myapplication.dependencies.modules.GeoInfoModule;
import puj.movil.myapplication.dependencies.modules.GeocoderModule;
import puj.movil.myapplication.dependencies.modules.LocationModule;

@Getter
public class App extends Application {
    ApplicationComponent appComponent = DaggerApplicationComponent.builder()
            .locationModule(new LocationModule(this))
            .geocoderModule(new GeocoderModule(this))
            .geoInfoModule(new GeoInfoModule(this))
            .build();
}
