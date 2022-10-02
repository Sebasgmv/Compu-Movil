package puj.movil.myapplication.services;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import puj.movil.myapplication.models.Country;

@Getter
public class CountriesService {
    public static final String TAG = CountriesService.class.getName();
    public static final String COUNTRIES_FILE = "countries.json";
    private final Context context;
    private ArrayList<Country> countries = new ArrayList<>();

    public CountriesService(Context context) {
        this.context = context;
        loadCountriesFromJson();
    }

    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = context.getAssets().open(COUNTRIES_FILE);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, StandardCharsets.UTF_8);
        } catch (IOException ex) {
            Log.e(TAG, String.format("loadJSONFromAsset: error reading the %s file.", COUNTRIES_FILE), ex);
            return null;
        }
        return json;
    }

    public void loadCountriesFromJson() {
        JsonObject mainFile = new Gson().fromJson(loadJSONFromAsset(), JsonObject.class);
        countries = new Gson().fromJson(mainFile.getAsJsonArray("Countries").toString(),
                new TypeToken<List<Country>>() {}.getType());
        Log.d(TAG, String.format("loadCountriesByJson: loaded %d countries.", countries.size()));
    }
}
