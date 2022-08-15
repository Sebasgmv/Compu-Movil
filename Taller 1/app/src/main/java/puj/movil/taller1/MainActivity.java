package puj.movil.taller1;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;

import puj.movil.taller1.data.CountriesFromJson;
import puj.movil.taller1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private CountriesFromJson countriesFromJson = new CountriesFromJson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.botonFibonacci.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, FibonacciActivity.class)));


    }
}