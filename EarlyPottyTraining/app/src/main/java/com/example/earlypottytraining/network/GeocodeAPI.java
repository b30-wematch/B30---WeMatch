package com.example.earlypottytraining.network;

import com.example.earlypottytraining.Common;

public class GeocodeAPI extends CommonAPI {

    private String param;

    public GeocodeAPI(double latitude, double longitude) {
        param = "" + latitude + "," + longitude;
    }

    @Override
    public Method requestMenthod() {
        return Method.GET;
    }

    @Override
    public String getUrl() {
        return Common.GEOCODE_API + param + Common.GOOGLE_GEOCODING_API_KEY;
    }
}
