package com.app.weatherapp;

import android.content.Context;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import kotlinx.coroutines.channels.ActorKt;

public class WeatherDataService {

    Context context;
    String temp_f = "";
    public WeatherDataService(Context context) {
        this.context = context;
    }

    public static final String JSON_KEY_60508_D_8_A_88_F_448478_B_6184351232103_Q = "http://api.weatherapi.com/v1/current.json?key=60508d8a88f448478b6184351232103&q=";

    public void getCityTemp(String cityName , VolleyResponseListener volleyResponseListener){
        String url = JSON_KEY_60508_D_8_A_88_F_448478_B_6184351232103_Q + cityName +" &aqi=no";
        // Request a string response from the provided URL.
        List<WeatherReportModel> report = new ArrayList<>();
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    WeatherReportModel weatherReportModel = new WeatherReportModel();

                    JSONObject current = (JSONObject) response.get("current");
                    JSONObject condition = current.getJSONObject("condition");
                    weatherReportModel.setTemp_c(Float.parseFloat(current.getString("temp_c")));
                    weatherReportModel.setTemp_f(Float.parseFloat(current.getString("temp_f")));
                    weatherReportModel.setWind_mph(Float.parseFloat(current.getString("wind_mph")));
                    weatherReportModel.setWind_kph(Float.parseFloat(current.getString("wind_kph")));
                    weatherReportModel.setWind_degree(Float.parseFloat(current.getString("wind_degree")));
                    weatherReportModel.setWind_dir(current.getString("wind_dir"));
                    weatherReportModel.setPrecip_mm(Float.parseFloat(current.getString("precip_mm")));
                    weatherReportModel.setHumidity(Float.parseFloat(current.getString("humidity")));
                    weatherReportModel.setFeelslike_c(Float.parseFloat(current.getString("feelslike_c")));
                    weatherReportModel.setFeelslike_f(Float.parseFloat(current.getString("feelslike_f")));
                    weatherReportModel.setUv(Float.parseFloat(current.getString("uv")));
                    weatherReportModel.setCondition(condition.getString("text"));
                    weatherReportModel.setUrl(condition.getString("icon"));

                    Log.i("WeatherDataService", current.toString());
                    List<String> weatherdata = new ArrayList<>();
                    weatherdata.add(" Temperature in celsius = " + current.getString("temp_c"));
                    weatherdata.add(" Temperature in farenheit = " + current.getString("temp_f"));
                    weatherdata.add(" Wind speed(mph) = " + current.getString("wind_mph"));
                    weatherdata.add(" Wind speed(kmph) =  " + current.getString("wind_kph"));
                    weatherdata.add(" Wind degree = " + current.getString("wind_degree"));
                    weatherdata.add(" Wind direction = " + current.getString("wind_dir"));
                    weatherdata.add(" Precipitation in mm = " + current.getString("precip_mm"));
                    weatherdata.add(" Humidity = " + current.getString("humidity"));
                    weatherdata.add(" Feels like in celsius = " + current.getString("feelslike_c"));
                    weatherdata.add(" Feels like in fahrenheit = " + current.getString("feelslike_f"));
                    weatherdata.add(" UV " + current.getString("uv"));

                    String text = weatherReportModel.getCondition();
                    String url = weatherReportModel.getUrl();
                    Log.i("WeatherDataService", weatherdata.toString());
                    volleyResponseListener.onResponse(weatherdata, text , url);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        },new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i("WeatherDataService", error.toString());
                        volleyResponseListener.onError(error.toString());
                    }
                });
        // Add the request to the RequestQueue.
        MySingleton.getInstance(context).addToRequestQueue(jsonObjectRequest);
        Toast.makeText(context, "You clicked on get City Name button", Toast.LENGTH_SHORT);
    }
}
