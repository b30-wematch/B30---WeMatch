package com.example.earlypottytraining.network;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public abstract class CommonAPI {

    public enum Method {
        GET,
        POST,
        PUT
    }

    public abstract Method requestMenthod();

    public abstract String getUrl();

    public static String getInfoByAPI(String path) {
        URL url = null;
        HttpURLConnection conn = null;
        String textResult = "";
        try {
            url = new URL(path);
            conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(10000);
            conn.setConnectTimeout(15000);
            conn.setRequestMethod(Method.GET.toString());
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept", "application/json");
            Scanner inStream = new Scanner(conn.getInputStream());
            while (inStream.hasNextLine()) {
                textResult += inStream.nextLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.disconnect();
        }
        return textResult;
    }
}
