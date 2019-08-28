package com.example.earlypottytraining.network;

import com.example.earlypottytraining.Common;

public class GeocodeAPI extends CommonAPI {

    public static final String GEOCODE_API_PATH = Common.GEOCODE_API + Common.GOOGLE_GEOCODING_API_KEY;
    @Override
    public Method requestMenthod() {
        return Method.GET;
    }

    @Override
    public String getUrl() {
        return GEOCODE_API_PATH;
    }
}
