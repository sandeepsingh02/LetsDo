package com.example.sandeep.letsdo.presenters;

import android.content.Context;

import com.example.sandeep.letsdo.models.MainActivityModel;
import com.example.sandeep.letsdo.models.MainActvityInterface;

public class MainActivityPresenter {
    private Context context;
    private MainActvityInterface mainActvityInterface;
    public MainActivityPresenter(Context context, MainActvityInterface mainActvityInterface) {
        this.context=context;
        this.mainActvityInterface=mainActvityInterface;
    }

    public void setTextValue() {
        MainActivityModel mainActivityModel=new MainActivityModel();
        mainActivityModel.setName("Hello! Sandeep");
    }
}
