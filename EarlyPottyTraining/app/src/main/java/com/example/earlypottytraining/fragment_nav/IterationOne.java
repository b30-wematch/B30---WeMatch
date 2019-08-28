package com.example.earlypottytraining.fragment_nav;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.earlypottytraining.R;
import com.example.earlypottytraining.activity.MainActivity;
import com.example.earlypottytraining.activity.MapsActivity;
import com.example.earlypottytraining.activity.Methods;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link IterationOne.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link IterationOne#newInstance} factory method to
 * create an instance of this fragment.
 */
public class IterationOne extends Fragment {

    Button btn_methods;
    Button btn_maps;
    private LayoutInflater inflater;
    private ViewPager viewpager;
    private ArrayList<View> pageview;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_iteration_one, container, false);
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


        //viewpager
        viewpager = (ViewPager) view.findViewById(R.id.vp_list);

        inflater = getLayoutInflater();
        View view1 = inflater.inflate(R.layout.item01, null);
        View view2 = inflater.inflate(R.layout.item02, null);

        pageview = new ArrayList<View>();
        pageview.add(view1);
        pageview.add(view2);

        PagerAdapter mPagerAdapter = new PagerAdapter() {
            @Override
            public int getCount() {
                return pageview.size();
            }

            @Override
            public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
                return view == o;
            }

            @Override
            public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
                ((ViewPager) container).removeView(pageview.get(position));

            }

            @NonNull
            @Override
            public Object instantiateItem(@NonNull ViewGroup container, int position) {
                ((ViewPager) container).addView(pageview.get(position));
                return pageview.get(position);

            }
        };
        viewpager.setAdapter(mPagerAdapter);


        return view;
    }

}
