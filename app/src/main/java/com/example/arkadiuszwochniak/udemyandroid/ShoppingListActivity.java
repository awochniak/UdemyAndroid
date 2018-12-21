package com.example.arkadiuszwochniak.udemyandroid;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.ArraySet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;
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

    private List<String> listItems;
    private List<String> spinnerItems;

    private static final String LIST_ITEMS_KEY = "LIST_ITEMS_KEY";
    private static final String SPINNER_ITEMS_KEY = "SPINNER_ITEMS_KEY";
    private static final String SHOPPING_LIST_KEY = "SHOPPING_LIST_KEY";
    private ShoppingListAdapter<String> listAdapter; // połączenie dwóch interfejsów / połączeni list_items z item list
    private ArrayAdapter<String> spinnerAdapter; // połączenie dwóch interfejsów / połączeni list_items z item list

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_list);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        listItems = new ArrayList<String>();
        spinnerItems = new ArrayList<>();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            if(itemName.getText()!=null&&!itemName.getText().toString().trim().isEmpty()){
                listItems.add(itemName.getText().toString());
                itemName.setText("");
                listAdapter.notifyDataSetChanged();
            }
            }

        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        SharedPreferences xd = getSharedPreferences(SHOPPING_LIST_KEY, MODE_PRIVATE);
        //listItems = xd.getStringSet(LIST_ITEMS_KEY,new ArraySet<String>());
        //spinnerItems = xd.getStringSet(SPINNER_ITEMS_KEY, new ArraySet<String>());

        spinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.select_dialog_item, spinnerItems);
        itemSpinner.setAdapter(spinnerAdapter);
        listAdapter = new ShoppingListAdapter<>(this, R.layout.row_shopping_list, listItems, spinnerAdapter, spinnerItems);
        itemList.setAdapter(listAdapter);

    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor editor = getSharedPreferences(SHOPPING_LIST_KEY, MODE_PRIVATE).edit(); //import static constant
      //  editor.putString(LIST_ITEMS_KEY, listItems);
        editor.putStringSet(SPINNER_ITEMS_KEY, spinnerItems);
        editor.commit();
    }


}
