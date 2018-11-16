package com.example.webservices;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;
import android.widget.ImageView;


class CustomDialoge extends Dialog {
    Dialog dialog=this;
    public CustomDialoge(Context context,boolean cancelable) {
        super(context);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.custom_dialog);
        dialog.setCancelable(cancelable);

    }
}
