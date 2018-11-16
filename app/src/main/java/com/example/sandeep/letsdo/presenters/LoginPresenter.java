package com.example.sandeep.letsdo.presenters;

import android.content.Context;

import com.example.sandeep.letsdo.R;
import com.example.sandeep.letsdo.enums.LetsDoEnum;
import com.example.sandeep.letsdo.models.LoginActivityModel;
import com.example.sandeep.letsdo.utils.CommonUtils;
import com.example.sandeep.letsdo.utils.CustomToast;
import com.example.sandeep.letsdo.utils.Url;
import com.example.webservices.WebService;
import com.example.webservices.WebServicesInterface;

public class LoginPresenter  implements  WebServicesInterface{
    WebServicesInterface webServicesInterface=this;
    WebService webService;
    Context context;
    LoginActivityModel loginActivityModel;
    public LoginPresenter(Context context, LoginActivityModel loginActivityModel) {
        this.context=context;
        this.loginActivityModel=loginActivityModel;
    }

    public boolean validateEmailFeilds(String userID) {
        if (CommonUtils.isValidEmail(userID)) {
            return true;
        } else if (CommonUtils.isValidPhone(userID)) {
            return true;
        }
        return false;
    }
    public boolean validatePasswordFeilds(String password) {
        if (password != null && !password.isEmpty()) {
            return true;
        }
        return false;
    }

    public void saveDataOnServer(String userName,String password) {
        //http://13.251.4.151:8081/Services/getMasters?mallId=3&type=MacIdInfo&propKey=mobileNo&keyWord=8299870797
        //String params="userName="+userName+"&password="+password;
        String params=LetsDoEnum.MallID +"="+context.getResources().getString(R.string.mallId)
                +"&"+LetsDoEnum.Type+"=MacIdInfo&"+LetsDoEnum.PropKey+"=mobileNo&"+
                LetsDoEnum.Keyword+"="+userName;
        webService=new WebService(context,webServicesInterface,Url.getLoginUrl(context),params);
        webService.execute();
    }

    @Override
    public void onServerResponseSuccess(String serverResponse) {
        loginActivityModel.onLoginActivityResponse(serverResponse);
        CustomToast.toast(context,serverResponse);

    }

    @Override
    public void onHandleFailure(String error) {
        CustomToast.toast(context,error);
    }
}
