package com.example.arkadiuszwochniak.udemyandroid;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.ArraySet;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.Set;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShoppingListActivity extends AppCompatActivity {

    @BindView(R.id.itemName_ET)
    EditText itemName;
    @BindView(R.id.itemList)
    ListView itemList;
    @BindView(R.id.itemSpinner)
    Spinner itemSpinner;

    private Set<String> listItems;
    private Set<String> spinnerItems;

    public static final String LIST_ITEMS_KEY = "LIST_ITEMS_KEY";
    public static final String SPINNER_ITEMS_KEY = "LIST_SPINNER_KEY";
    public static final String SHOPPING_LIST_KEY = "SHOPPING_LIST_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_list);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        listItems = new ArraySet<String>()''
        spinnerItems = new ArraySet<String>()''
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {

        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        SharedPreferences xd = getSharedPreferences(SHOPPING_LIST_KEY, MODE_PRIVATE);
        listItems = xd.getStringSet(LIST_ITEMS_KEY,new ArraySet<String>());
        spinnerItems = xd.getStringSet(SPINNER_ITEMS_KEY,new ArraySet<String>());

    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor editor = getSharedPreferences(SHOPPING_LIST_KEY, MODE_PRIVATE).edit(); //import static constant
        editor.putString("", "inna super tajna wiadomość");
        editor.apply();
    }

    /**
     *   SharedPreferences xd = getSharedPreferences(sp, MODE_PRIVATE);
     *             String message = xd.getString(sp_key,null);
     *             if (message!=null) {
     *                 Toast.makeText(this, message, Toast.LENGTH_LONG).show();
     *             }
     */
}
