package com.example.earlypottytraining.fragment_nav;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.earlypottytraining.ActivityCollection;
import com.example.earlypottytraining.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

import static android.support.v4.content.ContextCompat.getSystemService;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Home.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Home#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Home extends Fragment {

    TextView tv_greeting;
    TextView tv_date;
    //TextView tv_temperature;
    TextView tv_location;
    ImageView ic_location;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        tv_greeting = (TextView) view.findViewById(R.id.tv_greeting);
        tv_date = (TextView) view.findViewById(R.id.tv_date);
        //tv_temperature = (TextView) view.findViewById(R.id.tv_temperature);
        tv_location = (TextView) view.findViewById(R.id.tv_location);
        ic_location = (ImageView) view.findViewById(R.id.ic_location);
        //update time info
        updateDate();
        //update location
        updateLocation(getArguments());
        //updateWeather(getArguments());

        return view;
    }

    public void updateDate() {
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("EEE. d MMM. yyyy");
        String dateStr = sdf.format(date);

        //update day info
        tv_date.setText(dateStr);
        tv_date.setTextSize(20);
        //update greeting
        int hour = date.getHours();
        if (hour < 5) {
            tv_greeting.setText("Good Night");
        } else if (hour < 12) {
            tv_greeting.setText("Good Morning");
        } else if (hour < 18) {
            tv_greeting.setText("Good Afternoon");
        } else {
            tv_greeting.setText("Good Evening");
        }
        tv_greeting.setTextSize(32);
    }

    public void updateWeather(Bundle bundle) {
        SharedPreferences sharedPreferences = (SharedPreferences) getActivity()
                .getSharedPreferences("weather", Context.MODE_PRIVATE);
        String weatherJson = sharedPreferences.getString("weather", "Error");
        JSONObject jsonObject = null;
        String tempValue = "";
        String weatherValue = "";//need to imporve
        try {
            jsonObject = new JSONObject(weatherJson);
            JSONObject jsonChild = new JSONObject(jsonObject.get("main").toString());
            tempValue = jsonChild.get("temp").toString();
            weatherValue = jsonChild.get("temp").toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        int temp = (int) (Double.parseDouble(tempValue) - 273.15);
        //tv_temperature.setText(String.valueOf(temp));
    }

    public void updateLocation(Bundle bundle) {
        SharedPreferences sharedPreferences = (SharedPreferences) getActivity()
                .getSharedPreferences("location", Context.MODE_PRIVATE);
        String locationJson = sharedPreferences.getString("location", "Error");
        String locationValue = "";
        try {
            JSONObject jsonObject = new JSONObject(locationJson);
            JSONArray jsonArray = jsonObject.getJSONArray("results");
            JSONObject jsonChild = new JSONObject(jsonArray.get(0).toString());
            locationValue = jsonChild.get("formatted_address").toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        tv_location.setText(locationValue);
    }


}
