package com.example.sandeep.letsdo.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import com.example.sandeep.letsdo.R;
import com.example.sandeep.letsdo.models.LoginActivityModel;
import com.example.sandeep.letsdo.presenters.LoginPresenter;
import com.example.sandeep.letsdo.utils.CustomToast;

public class LoginActivity extends Activity implements LoginActivityModel {
    LoginActivityModel loginActivityModel=this;
    Context context;
    LoginPresenter loginPresenter;
    EditText editTextUserName,editTextPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        this.context=this;
        loginPresenter=new LoginPresenter(context,loginActivityModel);
        initView();

    }

    private void initView() {
        editTextUserName=findViewById(R.id.edittext_userID);
        editTextPassword=findViewById(R.id.edittext_password);
    }

    public void onClick(View view) {
        String msg="";
        switch (view.getId()) {
            case R.id.button_login:
                if (loginPresenter.validateEmailFeilds(editTextUserName.getText().toString().trim())) {
                    if (loginPresenter.validatePasswordFeilds(editTextPassword.getText().toString().trim())) {
                        loginPresenter.saveDataOnServer(editTextUserName.getText().toString().
                                trim(),editTextPassword.getText().toString().trim());
                    } else {
                        editTextPassword.setError("Enter Password");
                        CustomToast.toast(context,"Enter Password");
                    }
                } else {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        editTextUserName.setError("Enter Valid Email/Phone", getDrawable(R.drawable.ic_person));
                    } else {
                        editTextUserName.setError("Enter Valid Email/Phone");
                    }
                    CustomToast.toast(context,"Enter Valid Email/Phone");
                }
                break;
            case R.id.text_signup:
                msg="SignUp Press";
                break;
            case R.id.text_forgot_pwd:
                msg="Forgot Password Press";
                break;
            default: break;
        }
        CustomToast.toast(context,msg);
    }

    @Override
    public void onLoginActivityResponse(String response) {
        startActivity();
    }
    private void startActivity() {
        startActivity(new Intent(context,MainActivity.class));
        finish();
    }
}
