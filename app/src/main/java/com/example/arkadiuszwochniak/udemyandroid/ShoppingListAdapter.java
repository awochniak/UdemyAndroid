package com.example.arkadiuszwochniak.udemyandroid;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

public class ShoppingListAdapter<String> extends ArrayAdapter {
    private List<String> objects;
    private Context context;
    private int resource;
    ArrayAdapter<String> spinnerAdapter;
    List<String> spinnerItems;

    public ShoppingListAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<String> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;

    }

    public ShoppingListAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List <String> objects, ArrayAdapter<String> spinnerAdapter, List<String> spinnerItems) {
        this(context,resource, objects);
        this.spinnerAdapter = spinnerAdapter;
        this.spinnerItems = spinnerItems;
    }

    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row_shopping_list, parent, false);
        TextView name = rowView.findViewById(R.id.name_ET);
        name.setText(""+objects.get(position));
        CheckBox selected = rowView.findViewWithTag(R.id.selected_CB);
        selected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                spinnerItems.add(objects.get(position));
                spinnerAdapter.notifyDataSetChanged();
                objects.remove(position);
                ShoppingListAdapter.super.notifyDataSetChanged();

            }
        });

        return rowView;
    }
}
