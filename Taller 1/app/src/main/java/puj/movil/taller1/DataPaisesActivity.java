package puj.movil.taller1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import java.io.File;

import puj.movil.taller1.data.CountriesFromJson;
import puj.movil.taller1.databinding.ActivityDataPaisesBinding;

public class DataPaisesActivity extends AppCompatActivity {
    private ActivityDataPaisesBinding binding;
    private CountriesFromJson countriesFromJson = new CountriesFromJson();

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDataPaisesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String name = getIntent().getStringExtra("Name");
        String alpha2Code = getIntent().getStringExtra("Alpha2Code");
        String alpha3Code = getIntent().getStringExtra("Alpha3Code");
        String nativeName = getIntent().getStringExtra("NativeName");
        String region = getIntent().getStringExtra("Region");
        String subRegion = getIntent().getStringExtra("SubRegion");
        String numericCode = getIntent().getStringExtra("NumericCode");
        String nativeLanguage = getIntent().getStringExtra("NativeLanguage");
        String currencyCode = getIntent().getStringExtra("CurrencyCode");
        String currencyName = getIntent().getStringExtra("CurrencyName");
        String currencySymbol = getIntent().getStringExtra("CurrencySymbol");
        String flagPng = getIntent().getStringExtra("FlagPng");

        binding.textNamePais.setText(binding.textNamePais.getText() + name);
        binding.textAlpha2Pais.setText(binding.textAlpha2Pais.getText() + alpha2Code);
        binding.textAlpha3Pais.setText(binding.textAlpha3Pais.getText() + alpha3Code);
        binding.textNativeNamePais.setText(binding.textNativeNamePais.getText() + nativeName);
        binding.textRegionPais.setText(binding.textRegionPais.getText() + region);
        binding.textSubregionPais.setText(binding.textSubregionPais.getText() + subRegion);
        binding.textNumericCodePais.setText(binding.textNumericCodePais.getText() + numericCode);
        binding.textNativeLanguagePais.setText(binding.textNativeLanguagePais.getText() + nativeLanguage);
        binding.textCurrencyCodePais.setText(binding.textCurrencyCodePais.getText() + currencyCode);
        binding.textCurrencyNamePais.setText(binding.textCurrencyNamePais.getText() + currencyName);
        binding.textCurrencySymbolPais.setText(binding.textCurrencySymbolPais.getText() + currencySymbol);

        Picasso.with(this).load(flagPng).into(binding.imageFlagPais);

    }
}
