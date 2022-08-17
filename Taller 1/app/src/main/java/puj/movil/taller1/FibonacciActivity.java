package puj.movil.taller1;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import puj.movil.taller1.databinding.ActivityFibonacciBinding;
import puj.movil.taller1.databinding.ActivityMainBinding;
import puj.movil.taller1.utils.AlertUtils;


public class FibonacciActivity extends AppCompatActivity {
    private ActivityFibonacciBinding binding;
    private ActivityMainBinding bindingMain;
    private static int contador = 0;
    int fibonacci(int n)
    {
        if (n>1){
            return fibonacci(n-1) + fibonacci(n-2);  //función recursiva
        }
        else if (n==1) {  // caso base
            return 1;
        }
        else if (n==0){  // caso base
            return 0;
        }
        else{ //error
            System.out.println("Debes ingresar un tamaño mayor o igual a 1");
            return -1;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFibonacciBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        contador++;

        Integer valor = getIntent().getIntExtra("valor",0);
        System.out.println("Valor" + valor);

        for (int i = 0; i <= valor; i++) {
            TextView nueva_linea = new TextView(this);
            System.out.print(fibonacci(i)+" ");
            nueva_linea.setText(String.format(String.valueOf(fibonacci(i))));
            nueva_linea.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            binding.exampleLinearLayoutContainer.addView(nueva_linea);
        }


    }
}
