package com.example.earlypottytraining.activity;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.earlypottytraining.R;
import com.example.earlypottytraining.fragment_nav.Home;
import com.example.earlypottytraining.fragment_nav.IterationOne;
import com.example.earlypottytraining.fragment_nav.IterationThree;
import com.example.earlypottytraining.fragment_nav.IterationTwo;

public class MainActivity extends BaseActivity {
    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:

                    IterationOne iterOne = new IterationOne();
                    getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, iterOne, "Iteration One")
                            .commit();
                    return true;
                case R.id.navigation_dashboard:
                    IterationTwo iterTwo = new IterationTwo();
                    getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, iterTwo, "Iteration One")
                            .commit();
                    return true;
                case R.id.navigation_notifications:
                    IterationThree iterThree = new IterationThree();
                    getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, iterThree, "Iteration One")
                            .commit();
                    return true;
            }
            return false;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //home icon
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_home_black_24dp);

        //init the nav.
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        //start the home page
        Home home = new Home();
        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, home, "Home")
                .commit();
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
