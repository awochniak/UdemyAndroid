package com.example.arkadiuszwochniak.udemyandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import static android.view.Window.FEATURE_NO_TITLE;
import static android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN;

public class DrawAcitivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getWindow().setFlags(FLAG_FULLSCREEN, FLAG_FULLSCREEN);

        // deklaracja flagi z widokiem pełnego ekranu
        // import static constant

        requestWindowFeature(FEATURE_NO_TITLE);
        // niewidoczny pasek z tytułem

        DrawView drawView = new DrawView(this);
        setContentView(drawView);
        drawView.requestFocus();
    }
}
