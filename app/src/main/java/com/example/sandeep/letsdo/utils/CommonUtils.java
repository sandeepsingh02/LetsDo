package com.example.sandeep.letsdo.utils;

import android.text.TextUtils;
import android.util.Patterns;

public class CommonUtils {
    public  static String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    public  static String passwordPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    public static boolean isValidEmail(String email) {
        if (email.matches(emailPattern))
        {
            return  true;
        }
        return false;
    }
    public  static boolean isValidPhone(String phoneNo) {
        if (phoneNo == null || phoneNo.isEmpty()) {
            return  false;
        } else if (phoneNo.trim().length() == 10) {
            return !TextUtils.isEmpty(phoneNo) &&
                    Patterns.PHONE.matcher(phoneNo).matches();
        }
        return false;
    }
     public  static boolean isValidPassword(String password) {
         if (password.matches(passwordPattern))
         {
             return  true;
         }
         return false;
    }

}
