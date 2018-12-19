package com.example.arkadiuszwochniak.udemyandroid;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import static com.example.arkadiuszwochniak.udemyandroid.MainActivity.sp;
import static com.example.arkadiuszwochniak.udemyandroid.MainActivity.sp_key;

public class ShoppingListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.key);
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();

        SharedPreferences.Editor editor = getSharedPreferences(sp, MODE_PRIVATE).edit(); //import static constant
        editor.putString(sp_key, "inna super tajna wiadomość");
        editor.apply();

    }

}
