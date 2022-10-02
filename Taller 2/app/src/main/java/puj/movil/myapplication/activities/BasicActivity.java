package puj.movil.myapplication.activities;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import javax.inject.Inject;

import puj.movil.myapplication.App;
import puj.movil.myapplication.utils.AlertsHelper;
import puj.movil.myapplication.utils.PermissionHelper;

public class BasicActivity extends AppCompatActivity {
    @Inject
    AlertsHelper alertsHelper;

    @Inject
    PermissionHelper permissionHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        ((App) getApplicationContext()).getAppComponent().inject(this);
        super.onCreate(savedInstanceState);
    }
}