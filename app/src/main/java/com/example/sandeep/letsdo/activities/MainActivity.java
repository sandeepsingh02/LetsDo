package com.example.sandeep.letsdo.activities;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.sandeep.letsdo.R;
import com.example.sandeep.letsdo.models.MainActivityModel;
import com.example.sandeep.letsdo.models.MainActvityInterface;
import com.example.sandeep.letsdo.presenters.MainActivityPresenter;

public class MainActivity extends AppCompatActivity implements MainActvityInterface {
    private Context context;
    private MainActivityModel mainActivityModel;
    private MainActvityInterface mainActvityInterface;
    private MainActivityPresenter mainActivityPresenter;
    private TextView textViewName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DataBindingUtil.setContentView(this,R.layout.activity_main);
        this.context=this;
        mainActivityModel=new MainActivityModel();
        mainActvityInterface=this;
        mainActivityPresenter=new MainActivityPresenter(context,mainActvityInterface);
        mainActivityPresenter.setTextValue();
        initView();
    }

    private void initView() {
        textViewName=findViewById(R.id.textview_home);
        textViewName.setText(mainActivityModel.getName());
    }

    @Override
    public void onResponse(String response) {
        textViewName.setText(response);
    }
}
