package com.example.jsonexercise;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    String json = "{\"coord\": { \"lon\": 139,\"lat\": 35},\n" +
            "  \"weather\": [\n" +
            "    {\n" +
            "      \"id\": 800,\n" +
            "      \"main\": \"Clear\",\n" +
            "      \"description\": \"clear sky\",\n" +
            "      \"icon\": \"01n\"\n" +
            "    }\n" +
            "  ],\n" +
            "  \"base\": \"stations\",\n" +
            "  \"main\": {\n" +
            "    \"temp\": 289.92,\n" +
            "    \"pressure\": 1009,\n" +
            "    \"humidity\": 92,\n" +
            "    \"temp_min\": 288.71,\n" +
            "    \"temp_max\": 290.93\n" +
            "  },\n" +
            "  \"wind\": {\n" +
            "    \"speed\": 0.47,\n" +
            "    \"deg\": 107.538\n" +
            "  },\n" +
            "  \"clouds\": {\n" +
            "    \"all\": 2\n" +
            "  },\n" +
            "  \"dt\": 1560350192,\n" +
            "  \"sys\": {\n" +
            "    \"type\": 3,\n" +
            "    \"id\": 2019346,\n" +
            "    \"message\": 0.0065,\n" +
            "    \"country\": \"JP\",\n" +
            "    \"sunrise\": 1560281377,\n" +
            "    \"sunset\": 1560333478\n" +
            "  },\n" +
            "  \"timezone\": 32400,\n" +
            "  \"id\": 1851632,\n" +
            "  \"name\": \"Shuzenji\",\n" +
            "  \"cod\": 200\n" +
            "}";
    TextView tvCoord, tvMain, tvWeather, tvSys, tvClouds, tvWind, tvName, tvBase;
    String result = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvCoord = findViewById(R.id.tvCoord);
        tvMain = findViewById(R.id.tvMain);
        tvWeather = findViewById(R.id.tvWeather);
        tvSys = findViewById(R.id.tvSys);
        tvClouds = findViewById(R.id.tvClouds);
        tvWind = findViewById(R.id.tvWind);
        tvName = findViewById(R.id.tvName);
        tvBase = findViewById(R.id.tvBase);
        getJsonCoord();
        getJsonWeather();
        getJsonMain();
        getJsonSys();
        getJsonBase();
        getJsonCloud();
        getJsonWind();
        getJsonName();
    }

    private void getJsonCoord() {
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONObject jsonCoodr = jsonObject.getJSONObject("coord");

            String lon = jsonCoodr.getString("lon");
            String lat = jsonCoodr.getString("lat");

            result = "\nCoord: " + "\nlon: " + lon + "\nlat: " + lat;

            tvCoord.setText(result);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void getJsonWeather() {
        result = "";
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonWeather = jsonObject.getJSONArray("weather");
            for (int i = 0; i < jsonWeather.length(); i++) {
                JSONObject index = jsonWeather.getJSONObject(i);
                String id = index.getString("id");
                String main = index.getString("main");
                String des = index.getString("description");
                String icon = index.getString("icon");
                result += "\nWeather: " + "\nid: " + id + "\nmain: " + main + "\n description: " +
                        des + "\n icon: " + icon;
            }

            tvWeather.setText(result);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void getJsonMain() {
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONObject json = jsonObject.getJSONObject("main");

            double temp = json.getDouble("temp");
            String pressure = json.getString("pressure");
            String humidity = json.getString("humidity");
            String temp_min = json.getString("temp_min");
            String temp_max = json.getString("temp_max");
            result = "\nMain: " + "\ntemp: " + temp + "\npressure: " + pressure + "\n humidity: " +
                    humidity + "\n temp_min: " + temp_min + "\n temp_max: " + temp_max;

            tvMain.setText(result);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void getJsonSys() {
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONObject json = jsonObject.getJSONObject("sys");

            String type = json.getString("type");
            String id = json.getString("id");
            double message = json.getDouble("message");
            String country = json.getString("country");
            String sunrise = json.getString("sunrise");
            String sunset = json.getString("sunset");
            result = "\nSys: " + "\ntype: " + type + "\nid: " + id + "\n message: " +
                    message + "\n country: " + country + "\n sunrise: " + sunrise + "\n sunset: " + sunset;

            tvSys.setText(result);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void getJsonWind() {
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONObject json = jsonObject.getJSONObject("wind");

            String speed = json.getString("speed");
            String deg = json.getString("deg");

            result = "\nWind: " + "\nspeed: " + speed + "\ndeg: " + deg;

            tvWind.setText(result);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void getJsonCloud() {
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONObject json = jsonObject.getJSONObject("clouds");

            String all = json.getString("all");


            result = "\nCloud: " + "\nall: " + all;

            tvClouds.setText(result);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void getJsonBase() {
        try {
            JSONObject jsonObject = new JSONObject(json);

            String base = jsonObject.getString("base");


            result = "\nBase: " + "\nbase: " + base;

            tvBase.setText(result);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void getJsonName() {
        try {
            JSONObject jsonObject = new JSONObject(json);

            String name = jsonObject.getString("name");


            result = "\nName: " + "\nname: " + name;

            tvName.setText(result);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
