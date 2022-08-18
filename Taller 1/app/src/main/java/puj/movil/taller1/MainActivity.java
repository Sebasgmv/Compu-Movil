package puj.movil.taller1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import puj.movil.taller1.data.CountriesFromJson;
import puj.movil.taller1.databinding.ActivityMainBinding;
import puj.movil.taller1.utils.AlertUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private CountriesFromJson countriesFromJson = new CountriesFromJson();
    private int cont=0;
    private boolean pais = false;

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
            try {
                Integer valor = Integer.valueOf(binding.textPosiciones.getText().toString());
                Intent intent = new Intent(this, FibonacciActivity.class);
                intent.putExtra("valor", valor);
                startActivity(intent);
                cont++;
                pais=true;
            }catch (Exception e) {
                AlertUtils.longToast(MainActivity.this, "Debe ingresar una posicion para Fibonacci");
                e.printStackTrace();
            }
        });

        binding.botonFactorial.setOnClickListener(view -> {
            Intent intent = new Intent(this, FactorialActivity.class);
            Integer numFact = Integer.valueOf(binding.spinnerNumber.getSelectedItem().toString());
            intent.putExtra("numFact", numFact);
            startActivity(intent);
            cont++;
            pais=true;
        });

        binding.botonPaises.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, PaisesActivity.class));
            pais=false;
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        DateTimeFormatter dtf = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            System.out.println("yyyy/MM/dd HH:mm:ss-> "+dtf.format(LocalDateTime.now()));
        }
        if (cont !=0 && pais && Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            binding.contOperaciones.setText(
                    "Cont: "+cont + "\n" +
                            dtf.format(LocalDateTime.now()));
        }
    }

}