package com.example.earlypottytraining.network;

public abstract class CommonAPI {
    protected String interPath;
    protected String pathParam;

    public void setInterPath(String interPath) {
        this.interPath = interPath;
    }

    public enum Method{
        GET,
        POST,
        PUT
    }

    public abstract Method requestMenthod();

    public abstract String getUrl();


}
