package puj.movil.myapplication.models;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class Country {
    @SerializedName(value = "Name") private String name;
    @SerializedName(value = "Alpha2Code") private String alpha2Code;
    @SerializedName(value = "Alpha3Code") private String alpha3Code;
    @SerializedName(value = "NativeName") private String nativeName;
    @SerializedName(value = "Region") private String region;
    @SerializedName(value = "SubRegion") private String subRegion;
    @SerializedName(value = "Latitude") private String latitude;
    @SerializedName(value = "Longitude") private String longitude;
    @SerializedName(value = "Area") private String area;
    @SerializedName(value = "NumericCode") private String numericCode;
    @SerializedName(value = "NativeLanguage") private String nativeLanguage;
    @SerializedName(value = "CurrencyCode") private String currencyCode;
    @SerializedName(value = "CurrencyName") private String currencyName;
    @SerializedName(value = "CurrencySymbol") private String currencySymbol;
    @SerializedName(value = "Flag") private String flag;
    @SerializedName(value = "FlagPng") private String flagPng;
}
