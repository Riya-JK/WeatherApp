package com.app.weatherapp;

public class WeatherReportModel {
    private float temp_c;
    private float temp_f;
    private float wind_mph;
    private float wind_kph;
    private float wind_degree;
    private String wind_dir;
    private float precip_mm;
    private float humidity;
    private float feelslike_c;
    private float feelslike_f;
    private float uv;

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private String condition;

    private String url;

    public WeatherReportModel(float temp_c, float temp_f, float wind_mph, float wind_kph, float wind_degree, String wind_dir, float precip_mm, float humidity, float feelslike_c, float feelslike_f, float uv) {
        this.temp_c = temp_c;
        this.temp_f = temp_f;
        this.wind_mph = wind_mph;
        this.wind_kph = wind_kph;
        this.wind_degree = wind_degree;
        this.wind_dir = wind_dir;
        this.precip_mm = precip_mm;
        this.humidity = humidity;
        this.feelslike_c = feelslike_c;
        this.feelslike_f = feelslike_f;
        this.uv = uv;
    }

    public WeatherReportModel() {
    }

    public float getTemp_c() {
        return temp_c;
    }

    public void setTemp_c(float temp_c) {
        this.temp_c = temp_c;
    }

    public float getTemp_f() {
        return temp_f;
    }

    public void setTemp_f(float temp_f) {
        this.temp_f = temp_f;
    }

    public float getWind_mph() {
        return wind_mph;
    }

    public void setWind_mph(float wind_mph) {
        this.wind_mph = wind_mph;
    }

    public float getWind_kph() {
        return wind_kph;
    }

    public void setWind_kph(float wind_kph) {
        this.wind_kph = wind_kph;
    }

    public float getWind_degree() {
        return wind_degree;
    }

    public void setWind_degree(float wind_degree) {
        this.wind_degree = wind_degree;
    }

    public String getWind_dir() {
        return wind_dir;
    }

    public void setWind_dir(String wind_dir) {
        this.wind_dir = wind_dir;
    }

    public float getPrecip_mm() {
        return precip_mm;
    }

    public void setPrecip_mm(float precip_mm) {
        this.precip_mm = precip_mm;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public float getFeelslike_c() {
        return feelslike_c;
    }

    public void setFeelslike_c(float feelslike_c) {
        this.feelslike_c = feelslike_c;
    }

    public float getFeelslike_f() {
        return feelslike_f;
    }

    public void setFeelslike_f(float feelslike_f) {
        this.feelslike_f = feelslike_f;
    }

    public float getUv() {
        return uv;
    }

    public void setUv(float uv) {
        this.uv = uv;
    }

    @Override
    public String toString() {
        return "WeatherReportModel{" +
                "temp_c=" + temp_c +
                ", temp_f=" + temp_f +
                ", wind_mph=" + wind_mph +
                ", wind_kph=" + wind_kph +
                ", wind_degree=" + wind_degree +
                ", wind_dir=" + wind_dir +
                ", precip_mm=" + precip_mm +
                ", humidity=" + humidity +
                ", feelslike_c=" + feelslike_c +
                ", feelslike_f=" + feelslike_f +
                ", uv=" + uv +
                '}';
    }
}
