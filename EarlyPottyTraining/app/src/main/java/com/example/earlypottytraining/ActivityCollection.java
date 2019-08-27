package com.example.earlypottytraining;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

public class ActivityCollection {

    // activity list
    public static List<Activity> activities = new ArrayList<Activity>();

    // add activity
    public static void addActivity(Activity activity){
        activities.add(activity);
    }

    // remove activity
    public static void removeActivity(Activity activity){
        activities.remove(activity);
    }

    // get the current activity context
    public static Activity getCurrentContext(){
        Activity currentActivity = activities.get(activities.size() - 1);
        return currentActivity;
    }

}