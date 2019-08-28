package com.example.earlypottytraining.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.earlypottytraining.R;

import java.util.ArrayList;

public class Methods extends BaseActivity {


    private LayoutInflater inflater;
    private ViewPager viewpager;
    private ArrayList<View> pageview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_methods);

        //home icon
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_home_black_24dp);

        //viewpager
        viewpager = (ViewPager)findViewById(R.id.vp_img_list);

        inflater = getLayoutInflater();
        View view1 = inflater.inflate(R.layout.item01,null);
        View view2 = inflater.inflate(R.layout.item02,null);

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
                return view==o;
            }

            @Override
            public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
                ((ViewPager) container).removeView(pageview.get(position));

            }

            @NonNull
            @Override
            public Object instantiateItem(@NonNull ViewGroup container, int position) {
                ((ViewPager)container).addView(pageview.get(position));
                return pageview.get(position);

            }
        };
        viewpager.setAdapter(mPagerAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            returnHome(this);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void returnHome(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(intent);
    }
}
