package puj.movil.taller1;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;

import puj.movil.taller1.data.CountriesFromJson;
import puj.movil.taller1.databinding.ActivityPaisesBinding;

public class PaisesActivity extends AppCompatActivity {
    private ActivityPaisesBinding binding;
    private CountriesFromJson countriesFromJson = new CountriesFromJson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPaisesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        try {
            countriesFromJson.loadCountriesByJson(getAssets().open(CountriesFromJson.COUNTRIES_FILE));
            ArrayList<String> listaNombres = new ArrayList<>();
            for (int i = 0; i < countriesFromJson.getCountries().length(); i++) {
                listaNombres.add(countriesFromJson.getCountries().getJSONObject(i).get("Name").toString());
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaNombres);
            binding.listaPaises.setAdapter(adapter);
        } catch (JSONException | IOException e) {
            e.printStackTrace();
        }

        Intent intent = new Intent(this, DataPaisesActivity.class);

        binding.listaPaises.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Object item = adapterView.getItemAtPosition(i);
                for (int j = 0; j < countriesFromJson.getCountries().length(); j++) {
                    try {
                        if(countriesFromJson.getCountries().getJSONObject(i).get("Name").toString() == item){
                            intent.putExtra("informacion", (Parcelable) item);
                            startActivity(intent);

                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}
