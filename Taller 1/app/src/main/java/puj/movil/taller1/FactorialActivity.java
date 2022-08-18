package puj.movil.taller1;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import puj.movil.taller1.databinding.ActivityFactorialBinding;

public class FactorialActivity extends AppCompatActivity {
    private ActivityFactorialBinding binding;

    public long factorial (double numero) {
        if (numero==0)
            return 1;
        else
            return (long) (numero * factorial(numero-1));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFactorialBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Integer numFac = getIntent().getIntExtra("numFact",0);
        String cadena = new String();
        for (int i=0; i<numFac; i++){
            if(i == 0 && numFac == 1) {
                cadena = String.valueOf(i+1);
            }else if(i == 0) {
                cadena = String.valueOf(i+1) + "*";
            }else if(i<numFac-1){
                cadena = cadena + String.valueOf(i+1) + "*";
            }else if(i<numFac){
                cadena = cadena + String.valueOf(i+1);
            }
        }
        System.out.println("Cadena: "+cadena);
        binding.textodelFactorial.setText(
                "Operación: "+
                        cadena +
                        "\n"+ "Resultado: " +
                        factorial(numFac));
    }

}
