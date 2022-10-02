package puj.movil.myapplication.dependencies.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import puj.movil.myapplication.App;
import puj.movil.myapplication.utils.PermissionHelper;


@Module
public class PermissionModule {

    @Singleton
    @Provides
    public PermissionHelper providePermissionHelper() {
        return new PermissionHelper();
    }
}