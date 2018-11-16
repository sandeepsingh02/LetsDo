package com.example.sandeep.letsdo.activities;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;

import com.example.sandeep.letsdo.R;
import com.example.sandeep.letsdo.presenters.SplashScreenPresenter;

public class SplashScreenActivity extends Activity {
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        this.context=this;
        SplashScreenPresenter splashScreenPresenter=new SplashScreenPresenter(context);
        splashScreenPresenter.getResult();
    }
}
