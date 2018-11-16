package com.example.sandeep.letsdo.presenters;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.example.sandeep.letsdo.activities.LoginActivity;
import com.example.sandeep.letsdo.activities.SplashScreenActivity;
import com.example.sandeep.letsdo.activities.tutorials.TutorialActivity;

import static android.content.Intent.*;

public class SplashScreenPresenter {
    private final Context context;
    private  final static int SCREEN_TIMEOUT_TIME=5000;
    public SplashScreenPresenter(Context context) {
        this.context=context;
    }

    public void getResult() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                context.startActivity(new Intent(context,TutorialActivity.class).addFlags(FLAG_ACTIVITY_CLEAR_TASK|FLAG_ACTIVITY_CLEAR_TOP));
            }
        },SCREEN_TIMEOUT_TIME);
        //((SplashScreenActivity)context).finish();
    }
}
