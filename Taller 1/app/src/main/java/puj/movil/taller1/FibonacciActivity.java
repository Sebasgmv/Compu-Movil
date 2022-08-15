package puj.movil.taller1;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import puj.movil.taller1.databinding.ActivityFibonacciBinding;


public class FibonacciActivity extends AppCompatActivity {
    private ActivityFibonacciBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFibonacciBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}
