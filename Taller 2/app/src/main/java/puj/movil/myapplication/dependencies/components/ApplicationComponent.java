package puj.movil.myapplication.dependencies.components;

import javax.inject.Singleton;

import dagger.Component;
import puj.movil.myapplication.activities.BasicActivity;
import puj.movil.myapplication.activities.ContactsActivity;
import puj.movil.myapplication.dependencies.modules.AlertsModule;
import puj.movil.myapplication.dependencies.modules.PermissionModule;

@Singleton
@Component(modules = {AlertsModule.class, PermissionModule.class})
public interface ApplicationComponent {
    void inject(BasicActivity activity);

    void inject(ContactsActivity activity);
}