package com.example.arkadiuszwochniak.udemyandroid;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ApiActivity extends AppCompatActivity {

    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.htmlDataButton)
    Button htmlDataButton;
    @BindView(R.id.resultTextView)
    TextView resultTextView;
    @BindView(R.id.jsonDataButton)
    Button jsonDataButton;

    private Network network;
    private Cache cache;
    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api);
        ButterKnife.bind(this);
        progressBar.setVisibility(View.INVISIBLE);
        requestQueue = Volley.newRequestQueue(this);
        // requestQueue = new RequestQueue(cache, network);
        // network = new BasicNetwork(new HurlStack());
        // cache = new DiskBasedCache(getCacheDir(), 1024*1024); przedawnione obie

        htmlDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringRequest stringRequest = new StringRequest(Request.Method.GET, "https://www.google.pl", new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        resultTextView.setText(response);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        resultTextView.setText("!!!");
                    }
                });

                requestQueue.add(stringRequest);

            }
        });

        jsonDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ThreadClass().execute("URL", "URL2", "URL3");

            }
        });
    }

    private class ThreadClass extends AsyncTask<String, Integer, Float> {

        @Override
        protected void onPreExecute() {
            // metoda działająca w wątku użytkownika przygotowująca operację, np. pokazanie status bara
            progressBar.setVisibility(View.VISIBLE);
            progressBar.setMax(100);
            // textView.setText("" + System.currentTimeMillis());
            super.onPreExecute();
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            // pozwala na aktualizację np progres bara
            progressBar.setProgress(values[0]);
            super.onProgressUpdate(values);
        }

        @Override
        protected Float doInBackground(String... params) {
            // metoda wykonywana w innym wątku
            String url = params[0];
            String a = url;
            for (int i = 0; i < 10000; i++) {
                a = a + url;

                if (i > 0 && i % 1000 == 0)
                    publishProgress(i / 1000);
            }

            return null;
        }

        @Override
        protected void onPostExecute(Float f) {
            // metoda wykonywana po zakończeniu wywołania
            progressBar.setVisibility(View.INVISIBLE);
            // textView.setText(textView.getText() + " " + "" + System.currentTimeMillis());
            super.onPostExecute(f);
        }

        @Override
        protected void onCancelled(Float f) {
            // wywoływana wtedy gdy w do in bakckground zostanie wywołany cancel()
            super.onCancelled(f);
        }


    }
}

