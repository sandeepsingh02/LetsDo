package com.example.sandeep.letsdo.utils;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

public class CustomToast {
    public static void toast(Context context,String msg) {
        Toast.makeText(context,msg,Toast.LENGTH_SHORT).show();
    }
    public static void toastXY(Context context,String msg) {
        Toast.makeText(context,msg,Toast.LENGTH_SHORT).setGravity(Gravity.CENTER,100,100);
    }
}
