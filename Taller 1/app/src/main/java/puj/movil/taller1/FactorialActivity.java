package puj.movil.taller1;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import puj.movil.taller1.databinding.ActivityFactorialBinding;

public class FactorialActivity extends AppCompatActivity {

    private ActivityFactorialBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFactorialBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

}
