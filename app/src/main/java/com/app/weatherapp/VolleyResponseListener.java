package com.app.weatherapp;

import java.util.List;

public interface VolleyResponseListener {
    void onError(String message);
    void onResponse(List<String> weatherReportModel, String text, String url);
}
