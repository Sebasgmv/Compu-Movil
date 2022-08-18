package puj.movil.taller1;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import puj.movil.taller1.data.CountriesFromJson;
import puj.movil.taller1.databinding.ActivityDataPaisesBinding;

public class DataPaisesActivity extends AppCompatActivity {
    private ActivityDataPaisesBinding binding;
    private CountriesFromJson countriesFromJson = new CountriesFromJson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDataPaisesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}
