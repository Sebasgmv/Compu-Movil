package puj.movil.taller1;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import puj.movil.taller1.databinding.ActivityFibonacciBinding;


public class FibonacciActivity extends AppCompatActivity {
    private ActivityFibonacciBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFibonacciBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        for (int i = 0; i < 100; i++) {
            TextView nueva_linea = new TextView(this);
            nueva_linea.setText(String.format("Linea: %s", i));
            nueva_linea.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            binding.exampleLinearLayoutContainer.addView(nueva_linea);
        }


    }
}
