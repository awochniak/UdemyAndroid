package com.example.arkadiuszwochniak.udemyandroid;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ApiActivity extends AppCompatActivity {

    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.button)
    Button button;
    @BindView(R.id.textView)
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api);
        ButterKnife.bind(this);
        progressBar.setVisibility(View.INVISIBLE);
        textView.setVisibility(View.INVISIBLE);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setVisibility(View.VISIBLE);
                new ThreadClass().execute("URL", "URL2", "URL3");

            }
        });
    }

    private class ThreadClass extends AsyncTask<String, Void, Void> {

        @Override
        protected void onPreExecute() {
            // metoda działająca w wątku użytkownika przygotowująca operację, np. pokazanie status bara
            progressBar.setVisibility(View.VISIBLE);
            textView.setText("" + System.currentTimeMillis());
            super.onPreExecute();
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            // pozwala na aktualizację np progres bara
            super.onProgressUpdate(values);
        }

        @Override
        protected Void doInBackground(String... params) {
            // metoda wykonywana w innym wątku
            String url = params[0];
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            // metoda wykonywana po zakończeniu wywołania
            progressBar.setVisibility(View.INVISIBLE);
            textView.setText(textView.getText() + " " + "" + System.currentTimeMillis());
            super.onPostExecute(aVoid);
        }

        @Override
        protected void onCancelled(Void aVoid) {
            // wywoływana wtedy gdy w do in bakckground zostanie wywołany cancel()
            super.onCancelled(aVoid);
        }


    }
}

