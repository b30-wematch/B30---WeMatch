package com.example.earlypottytraining;

import android.app.Activity;
import android.os.Handler;
import android.widget.ImageView;

import com.kaopiz.kprogresshud.KProgressHUD;

public class Common {
    public static final String GOOGLE_MAP_API_KEY = "AIzaSyBSAk3ZXxNRom0CmW9JWeIrPPhqOqWo9ok";
    public static final String GOOGLE_GEOCODING_API_KEY = "AIzaSyA8cwM3yPCYhxGLUVX60ft9GXXcJURuo3E";

    public static final String GEOCODE_API = "https://maps.googleapis.com/maps/api/geocode/json?latlng=-37.8136,144.963&key=AIzaSyDHIoNiWgmP3ti9djx2qjmUPgvS8ZRhH6w";

    public static void popMessage(String message) {
        popDialog(message, R.drawable.check_mark);
    }

    public static void popFailMessage(String message) {
        popDialog(message, R.drawable.delete_mark);
    }

    public static void popDialog(final String message, int imageResource) {
        final Activity context = ActivityCollection.getCurrentContext();
        if (context == null) {
            return;
        }
        final ImageView imageView = new ImageView(context);
        imageView.setImageResource(imageResource);
        final KProgressHUD progressHUD = KProgressHUD.create(context)
                .setCustomView(imageView)
                .setAutoDismiss(true)
                .setLabel(message)
                .show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                progressHUD.dismiss();
            }
        }, 1000);
    }
}
