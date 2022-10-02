package puj.movil.myapplication;

import android.app.Application;

import lombok.Getter;
import puj.movil.myapplication.dependencies.components.ApplicationComponent;
import puj.movil.myapplication.dependencies.components.DaggerApplicationComponent;
import puj.movil.myapplication.dependencies.modules.AlertsModule;
import puj.movil.myapplication.dependencies.modules.CountriesModule;
import puj.movil.myapplication.dependencies.modules.PermissionModule;
//import edu.puj.contactos.dependencies.components.DaggerApplicationComponent;

@Getter
public class App extends Application {
    ApplicationComponent appComponent = DaggerApplicationComponent.builder()
            .build();
}
