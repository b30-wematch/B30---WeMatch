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
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.earlypottytraining.R;

import java.util.ArrayList;

public class Methods extends BaseActivity {


    private LayoutInflater inflater;
    private ViewPager viewpager;
    private ArrayList<View> pageview;

    private ScrollView scrollView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_methods);

        //home icon
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_home_black_24dp);

        //viewpager
        viewpager = (ViewPager) findViewById(R.id.vp_img_list);
        final TextView textView = (TextView) findViewById(R.id.tv_detail);
        textView.setText("Click flag to show information...");

        inflater = getLayoutInflater();
        View view1 = inflater.inflate(R.layout.view_kenya_flag, null);
        View view2 = inflater.inflate(R.layout.view_vietnam_flag, null);
        View view3 = inflater.inflate(R.layout.view_china_flag, null);

        //view event
        view1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("Kenya- Digo Community Potty training Method\n" +
                        "Since the mother spends most of her time with the child during the first months toilet training can be started at about 2-3 weeks of age. Place the infant in a special training position that mimics sitting in a toilet (traditionally mothers sit with her legs straight out in front of her  and placing the baby between her knees, with the baby facing away from the mother). Make a “shuus”  noise – the baby will learn to associate this sound with voiding. Do this activity many times a day and in the night. When the child voids as the “shuus” sound is made reward him/her for his behaviour by feeding, close contact, or other pleasurable activity. Gradually the child is expected to become more articulate in communicating his/her elimination needs. He/she should be able to urinate in position and on command by 5 months of age.\n" +
                        "For bowel moment follow the same process but with a more appropriate positioning (traditionally mothers sit on the floor with her knees bent. The infant sits facing her on the lower parts of her legs, with his legs over hers and leaning slightly forward, the support of her feet providing a kind of “potty” ). Do not make noises like bladder training, the stimulus for elimination is position of the baby. Reward the child if he/she voids, if not return to the previous activity. \n" +
                        "Perform these activities when you feel the child needs to go to toilet through signs like grunting, crying, or facing going red etc. Continue these methods for months while also trying to associate toilet with elimination. Start to teach your child more independence at the age of 12 months.\n");
            }
        });
        view2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("Vietnam Potty training Method\n" +
                        "For a new born try to recognize signs when the child needs to urinate or poo. Child could make a particular face, start kicking, crying or any other sign. Establish suitable times when you think the child needs to urinate, usually after feeding, before and after nap, and then hourly. Use a whistling sound to encourage child to urinate. Occasionally this practice can be stopped for short periods if there are too many accidents and use diaper. Continue this method for months and slowly you will learn when the child prefers to urinate. You will also have learnt the signs when the child is getting ready to urinate. At night you can get your child to wear diaper if necessary. With time the child will start responding to whistling sound more often.\n" +
                        "When the child is older (9 months or more) his/her ability to communicate will improve. There might be constant need of reminding the child to use potty. It is expected to have higher success rates in these months as the child is more aware of toilet needs. Continue this process as the communication between you and your child improves. \n" +
                        "At 18 months there will be a higher possibility of two-way communication. The child will be able to communicate the need to go to the toilet. However, it would be good to follow routine and remind the child to go to the toilet before sleep and after meals. Focus on teaching your child independence by showing where the child needs to go for toilet. There is a good possibility the child might start acting independently. Continue this process and by 24 months it is expected for the child to be able to manage elimination needs independently.\n");
            }
        });
        view3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("China Potty Training Method\n" +
                        "Toilet training can start a few days after the baby is born. You can instigate child’s peeing and pooping with little tricks.  Before and after sleep, feeding, drinking or whenever there’s time, hold the baby into a squat or “straddle” position over the toilet and make a monotoned whistling or “ssss” sounds. If the baby voids reward him/her with hugs, praises and kisses otherwise do not pressure or scold the baby. If nothing happens after whistling and squatting (not more than a minute or two), end the training and try again later. To encourage bowel moment, hold the baby in an appropriate position over the toilet and make a different sound like “uh-uh”.  Reward the baby with positive reinforcement of he/she poos. Continue these methods for a few months. Try to catch opportunities for training throughout the day and be diligent. The baby will start associating toilet and sounds with elimination process. With time you will get better in understanding the signals from the baby and the baby’s communication will also improve.\n" +
                        "You can also introduce split-crotch pants to you child around the age of 3-4 months for use at home as it may not be appropriate for use outside. In these pants the crotch area of the pants is left open, so that when the baby needs to squat, the pants would open, the business would be done and there would be little to no mess to clean.\n");
            }
        });

        pageview = new ArrayList<View>();
        pageview.add(view1);
        pageview.add(view2);
        pageview.add(view3);

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
