package com.app.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button  btn_getByCityName;
    EditText data;
    ListView list_data;
    TextView condition_text;
    ImageView weather_image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data = findViewById(R.id.data_input);
        list_data =  findViewById(R.id.weatherReports);
        condition_text = findViewById(R.id.condition_text);
        weather_image = findViewById(R.id.image);
        WeatherDataService weatherDataService = new WeatherDataService(MainActivity.this);
        findViewById(R.id.getWeatherByCityName).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Instantiate the RequestQueue.
                weatherDataService.getCityTemp(data.getText().toString(), new VolleyResponseListener() {
                    @Override
                    public void onError(String message) {
                        Log.i("MainActivity", message);
                        Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG);
                    }

                    @Override
                    public void onResponse(List<String> weatherReportData, String text, String url) {
                        Log.i("MainActivity", weatherReportData.toString() + url);
                        Toast.makeText(MainActivity.this, "The weather report is "+ weatherReportData.toString(), Toast.LENGTH_LONG);
                        condition_text.setText("The weather is " + text + " in " + data.getText());
                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(MainActivity.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, weatherReportData);
                        list_data.setAdapter(arrayAdapter);
                    }
                });
            }
        });

    }
}