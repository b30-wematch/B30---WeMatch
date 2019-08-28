package com.example.earlypottytraining.network;


import com.example.earlypottytraining.Common;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class WeatherAPI extends CommonAPI {

    public static final String WEATHER_API_PATH = Common.WEATHER_API + Common.WEATHER_API_KEY;

    @Override
    public Method requestMenthod() {
        return Method.GET;
    }

    @Override
    public String getUrl() {
        return WEATHER_API_PATH;
    }


}
