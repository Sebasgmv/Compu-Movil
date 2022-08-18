package puj.movil.taller1;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import java.util.logging.Logger;

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

        binding.botonFibonacci.setOnClickListener(view -> {
            Integer valor = Integer.valueOf(binding.textPosiciones.getText().toString());
            Intent intent = new Intent(this, FibonacciActivity.class);
            intent.putExtra("posiciones", valor);


            startActivity(intent);
        });
        binding.botonFactorial.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, FactorialActivity.class)));
        binding.botonPaises.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, PaisesActivity.class)));

    }
}