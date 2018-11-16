package com.example.sandeep.letsdo.activities.tutorials;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.sandeep.letsdo.R;
import com.example.sandeep.letsdo.activities.LoginActivity;
import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class TutorialActivity extends Activity implements View.OnClickListener{
    Context mContext;
    ViewPager viewpager;
    ArrayList<Drawable> imagesList;
    CirclePageIndicator indicator;
    PageListener pageListener;
    TextView textViewSubmit;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);
        mContext = this;
        viewpager = findViewById(R.id.viewpager);
        indicator = findViewById(R.id.indicator);
        textViewSubmit = findViewById(R.id.textview_submit);
        textViewSubmit.setOnClickListener(this);
        imagesList=new ArrayList<>();
        imagesList.add(getResources().getDrawable(R.drawable.splash));
        imagesList.add(getResources().getDrawable(R.drawable.splash));
        imagesList.add(getResources().getDrawable(R.drawable.splash));

        if (imagesList != null && imagesList.size() > 0) {
            CustomImagePagerAdapter customPagerAdapter = new CustomImagePagerAdapter(mContext);
            viewpager.setAdapter(customPagerAdapter);
            indicator.setViewPager(viewpager);
        }

        pageListener = new PageListener();
        viewpager.addOnPageChangeListener(pageListener);
    }
    int currentPage=0;
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.textview_submit:
                if(currentPage==imagesList.size()-1){
                    //SharedPref.write(Constants.isPrevLaunched,true);
                    startActivity(new Intent(mContext,LoginActivity.class));
                    finish();
                }
                else{
                    viewpager.setCurrentItem(imagesList.size()-1);
                    indicator.setCurrentItem(imagesList.size()-1);
                    //indicator.setViewPager(viewpager);
                }
                break;
            default:break;
        }
    }

    private class PageListener extends ViewPager.SimpleOnPageChangeListener {
        public void onPageSelected(int position) {
            Log.i(TAG, "page selected " + position);
            currentPage = position;
            if(position == imagesList.size()-1){
                textViewSubmit.setText(getResources().getString(R.string._continue));
            }
            else {
                textViewSubmit.setText(getResources().getString(R.string.skip));
            }
        }
    }

}


