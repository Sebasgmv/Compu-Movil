package puj.movil.taller1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;

import java.io.IOException;

import puj.movil.taller1.databinding.ActivityFibonacciBinding;
import puj.movil.taller1.databinding.ActivityMainBinding;
import puj.movil.taller1.utils.AlertUtils;


public class FibonacciActivity extends AppCompatActivity {
    private ActivityFibonacciBinding binding;
    private ActivityMainBinding bindingMain;

    public static long optimizedFib(int n)
    {
        // Creamos un array de parámetros
        long[] parameters=new long[3];
        // Asignamos el valor1al primer parámetro.
        parameters[0]=1;
        // Llamamosala otra función optimizada.
        return optimizedFib(n, parameters);
    }
    public static long optimizedFib(int n,long[]parameters) {
        // Paranmenor que0(devuelve0)
        if (n <= 0) {
            return 0;
        }
        // Paranmenoroigual que2(devuelve1)
        if (n <= 2) {
            return 1;
        } else {
            /*Asignación de valores
            para los parámetros
            de la llamada recursiva*/
            parameters[2] = parameters[1] + parameters[0];
            parameters[1] = parameters[0];
            parameters[0] = parameters[2];
            // Llamada recursiva.
            optimizedFib(n - 1, parameters);
            // Devuelve la suma.
            return parameters[0] + parameters[1];
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFibonacciBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        Integer valor = getIntent().getIntExtra("valor",0);
        System.out.println("Valor" + valor);

        for (int i = 0; i < valor; i++) {
            TextView nueva_linea = new TextView(this);
            nueva_linea.setText(String.format(String.valueOf(optimizedFib(i))));
            nueva_linea.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            binding.exampleLinearLayoutContainer.addView(nueva_linea);
        }

        binding.simpleImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uriFibonacci = Uri.parse("https://en.wikipedia.org/wiki/Fibonacci");
                Intent intent = new Intent(Intent.ACTION_VIEW, uriFibonacci);
                startActivity(intent);
            }
        });
    }
}
