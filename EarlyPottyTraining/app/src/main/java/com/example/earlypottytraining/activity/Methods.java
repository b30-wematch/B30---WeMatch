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
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.earlypottytraining.R;

import java.util.ArrayList;

public class Methods extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_methods);

        //home icon
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_home_black_24dp);

        Button btn_china = (Button) findViewById(R.id.btn_china);
        Button btn_kenya = (Button) findViewById(R.id.btn_kenya);
        Button btn_vietnam = (Button) findViewById(R.id.btn_vietnam);

        // view event
        btn_china.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Methods.this, DisplayActivity.class);
                intent.putExtra("country", "china");
                startActivity(intent);
            }
        });
        btn_kenya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Methods.this, DisplayActivity.class);
                intent.putExtra("country", "kenya");
                startActivity(intent);
            }
        });
        btn_vietnam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Methods.this, DisplayActivity.class);
                intent.putExtra("country", "vietnam");
                startActivity(intent);
            }
        });


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
