package com.example.planertreningow;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView ivCwiczenie;
    private TextView tvNazwaCwiczenia;
    private TextView tvSerie;
    private TextView tvLacznaLiczba;

    private Button btnLosuj;
    private Button btnMinus;
    private Button btnPlus;
    private Button btnNastepne;
    private Button btnReset;


    private int liczbaSerii = 0;


    private int lacznaLiczbaSerii = 0;


    private final Random random = new Random();


    private final int[] grafikiCwiczen = {
            R.drawable.cwiczenie0,
            R.drawable.cwiczenie1,
            R.drawable.cwiczenie2,
            R.drawable.cwiczenie3,
            R.drawable.cwiczenie4,
            R.drawable.cwiczenie5,
            R.drawable.cwiczenie6
    };


    private final String[] nazwyCwiczen = {
            "Losuj ćwiczenie",
            "Przysiad",
            "Pompki",
            "Plank",
            "Wykroki",
            "Burpees",
            "Podciąganie"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        inicjalizujWidoki();


        ustawStanPoczatkowy();


        ustawObslugePrzyciskow();
    }


    private void inicjalizujWidoki() {

        ivCwiczenie = findViewById(R.id.ivCwiczenie);
        tvNazwaCwiczenia = findViewById(R.id.tvNazwaCwiczenia);
        tvSerie = findViewById(R.id.tvSerie);
        tvLacznaLiczba = findViewById(R.id.tvLacznaLiczba);

        btnLosuj = findViewById(R.id.btnLosuj);
        btnMinus = findViewById(R.id.btnMinus);
        btnPlus = findViewById(R.id.btnPlus);
        btnNastepne = findViewById(R.id.btnNastepne);
        btnReset = findViewById(R.id.btnReset);
    }


    private void ustawStanPoczatkowy() {

        liczbaSerii = 0;
        lacznaLiczbaSerii = 0;

        ivCwiczenie.setImageResource(R.drawable.cwiczenie0);
        tvNazwaCwiczenia.setText("Losuj ćwiczenie");
        tvSerie.setText("0");
        tvLacznaLiczba.setText("Łączna liczba serii: 0");
    }

    private void ustawObslugePrzyciskow() {


        btnLosuj.setOnClickListener(v -> losujCwiczenie());


        btnPlus.setOnClickListener(v -> {

            liczbaSerii++;

            aktualizujLicznikSerii();
        });


        btnMinus.setOnClickListener(v -> {

            if (liczbaSerii > 0) {
                liczbaSerii--;
            }

            aktualizujLicznikSerii();
        });


        btnNastepne.setOnClickListener(v -> {


            lacznaLiczbaSerii += liczbaSerii;


            aktualizujLacznaLiczbeSerii();


            losujCwiczenie();
        });


        btnReset.setOnClickListener(v -> resetAplikacji());
    }


    private void losujCwiczenie() {


        int numerCwiczenia = random.nextInt(6) + 1;


        ivCwiczenie.setImageResource(
                grafikiCwiczen[numerCwiczenia]
        );


        tvNazwaCwiczenia.setText(
                nazwyCwiczen[numerCwiczenia]
        );


        liczbaSerii = 0;

        aktualizujLicznikSerii();
    }


    private void aktualizujLicznikSerii() {

        tvSerie.setText(String.valueOf(liczbaSerii));
    }


    private void aktualizujLacznaLiczbeSerii() {

        tvLacznaLiczba.setText(
                "Łączna liczba serii: " + lacznaLiczbaSerii
        );
    }


    private void resetAplikacji() {

        liczbaSerii = 0;
        lacznaLiczbaSerii = 0;

        ivCwiczenie.setImageResource(R.drawable.cwiczenie0);
        tvNazwaCwiczenia.setText("Losuj ćwiczenie");

        aktualizujLicznikSerii();
        aktualizujLacznaLiczbeSerii();
    }
}