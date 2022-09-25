package puj.movil.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import puj.movil.myapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //Ni idea pq sale
    public ActivityMainBinding getBinding() {
        return binding;
    }
}