package com.example.arkadiuszwochniak.udemyandroid;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.shoppingListButton)
    Button shoppingListButton;
    @BindView(R.id.drawButton)
    Button drawButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar); // we wcześniejszych action bar, pochodzi z appcompat, widoczny dla wszystkich widoków
        setSupportActionBar(toolbar);

    }

    @OnClick(R.id.shoppingListButton)
    void onClickShoppingList(){
        Intent intent = new Intent (this, ShoppingListActivity.class);
        startActivity(intent);

    }

    @OnClick(R.id.drawButton)
    void onClickDraw(){
        Intent intent = new Intent (this, DrawAcitivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.apiButton)
    void onClickApi() {
        Intent intent = new Intent(this, ApiActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.viewButton)
    void onClickView() {
        Intent intent = new Intent(this, ViewActivity.class);
        startActivity(intent);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
