package puj.movil.taller1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
        JSONArray data = countriesFromJson.getCountries();

        binding.listaPaises.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();
                for (int j = 0; j < countriesFromJson.getCountries().length(); j++) {
                    try {
                        if(data.getJSONObject(j).get("Name").toString() == item){
                            intent.putExtra("Name", data.getJSONObject(j).get("Name").toString());
                            intent.putExtra("Alpha2Code", data.getJSONObject(j).get("Alpha2Code").toString());
                            intent.putExtra("Alpha3Code", data.getJSONObject(j).get("Alpha3Code").toString());
                            intent.putExtra("NativeName", data.getJSONObject(j).get("NativeName").toString());
                            intent.putExtra("Region", data.getJSONObject(j).get("Region").toString());
                            intent.putExtra("SubRegion", data.getJSONObject(j).get("SubRegion").toString());
                            intent.putExtra("NumericCode", data.getJSONObject(j).get("NumericCode").toString());
                            intent.putExtra("NativeLanguage", data.getJSONObject(j).get("NativeLanguage").toString());
                            intent.putExtra("CurrencyCode", data.getJSONObject(j).get("CurrencyCode").toString());
                            intent.putExtra("CurrencyName", data.getJSONObject(j).get("CurrencyName").toString());
                            intent.putExtra("CurrencySymbol", data.getJSONObject(j).get("CurrencySymbol").toString());

                            intent.putExtra("FlagPng", data.getJSONObject(j).get("FlagPng").toString());

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
