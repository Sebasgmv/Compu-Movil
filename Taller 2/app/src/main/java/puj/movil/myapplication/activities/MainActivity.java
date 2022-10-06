package puj.movil.myapplication.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import puj.movil.myapplication.R;
import puj.movil.myapplication.databinding.ActivityMainBinding;

//De quién debería extender AppCompatActivity o Basic Activity?
public class MainActivity extends BasicActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnCamara.setOnClickListener(view -> {
            Intent intent = new Intent(this, CameraActivity.class);
            startActivity(intent);
        });

        binding.btnContactos.setOnClickListener(view -> {
            Intent intent = new Intent(this, ContactsActivity.class);
            startActivity(intent);
        });

        binding.btnLocalizacion.setOnClickListener(view -> {
            Intent intent = new Intent(this, MapsActivity.class);
            startActivity(intent);
        });
    }

}