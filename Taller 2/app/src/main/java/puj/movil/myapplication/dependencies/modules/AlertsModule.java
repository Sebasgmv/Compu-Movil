package puj.movil.myapplication.dependencies.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import puj.movil.myapplication.App;
import puj.movil.myapplication.utils.AlertsHelper;


@Module
public class AlertsModule {
    public AlertsModule(App app) {

    }

    public AlertsModule() {

    }

    @Singleton
    @Provides
    public AlertsHelper provideAlertUtils() {
        return new AlertsHelper();
    }
}
