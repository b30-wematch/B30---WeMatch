package com.example.earlypottytraining.network;

import com.example.earlypottytraining.Common;

public class GeocodeAPI extends CommonAPI {

    @Override
    public Method requestMenthod() {
        return Method.GET;
    }

    @Override
    public String getUrl() {
        return Common.GEOCODE_API;
    }
}
