package puj.movil.taller1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

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

        ArrayList<Integer> listaNum = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            listaNum.add(i, i + 1);
        }
        ArrayAdapter<Integer> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listaNum);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spinnerNumber.setAdapter(adapter);

        binding.botonFibonacci.setOnClickListener(view -> {
            Integer valor = Integer.valueOf(binding.textPosiciones.getText().toString());
            Intent intent = new Intent(this, FibonacciActivity.class);
            intent.putExtra("valor", valor);
            startActivity(intent);
        });

        binding.botonFactorial.setOnClickListener(view -> {
            Intent intent = new Intent(this, FactorialActivity.class);
            Integer numFact = Integer.valueOf(binding.spinnerNumber.getSelectedItem().toString());
            intent.putExtra("numFact", numFact);
            startActivity(intent);
        });

        binding.botonPaises.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, PaisesActivity.class)));

    }
}