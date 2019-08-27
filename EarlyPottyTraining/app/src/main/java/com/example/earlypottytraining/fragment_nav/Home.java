package com.example.earlypottytraining.fragment_nav;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.earlypottytraining.R;

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
    TextView tv_temperature;
    TextView tv_location;
    Button btn_quiz;
    Button btn_maps;


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
        tv_temperature = (TextView) view.findViewById(R.id.tv_temperature);
        tv_location = (TextView) view.findViewById(R.id.tv_location);
        return view;
    }


}
