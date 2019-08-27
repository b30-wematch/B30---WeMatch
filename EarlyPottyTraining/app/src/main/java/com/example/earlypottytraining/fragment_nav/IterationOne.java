package com.example.earlypottytraining.fragment_nav;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.earlypottytraining.R;
import com.example.earlypottytraining.activity.MainActivity;
import com.example.earlypottytraining.activity.MapsActivity;
import com.example.earlypottytraining.activity.Methods;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link IterationOne.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link IterationOne#newInstance} factory method to
 * create an instance of this fragment.
 */
public class IterationOne extends Fragment {

    ViewPager vp_methods;
    ViewPager vp_maps;
    Button btn_methods;
    Button btn_maps;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_iteration_one, container, false);
        vp_methods = (ViewPager) view.findViewById(R.id.vp_methods);
        vp_maps = (ViewPager) view.findViewById(R.id.vp_maps);
        btn_methods = (Button) view.findViewById(R.id.btn_methods);
        btn_maps = (Button) view.findViewById(R.id.btn_maps);

        //link to activities
        btn_methods.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Methods.class);
                startActivity(intent);
            }
        });
        btn_maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MapsActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }

}
