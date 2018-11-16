package com.example.sandeep.letsdo.utils;

import android.content.Context;

import com.example.sandeep.letsdo.R;

public class Url {
    public static  String getBaseUrl(Context context) {
        return context.getResources().getString(R.string.server_url);
    }
    public static String getLoginUrl(Context context) {
        return getBaseUrl(context)+"Services/getMasters?";
    }

}
