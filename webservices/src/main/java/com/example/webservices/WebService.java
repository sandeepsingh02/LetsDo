package com.example.webservices;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class WebService extends AsyncTask<String,String,String> {
    private WebServicesInterface webServicesInterface;
    private String url;
    private HashMap<String,String> hashMap;
    private ArrayList<File> arrayListFile;
    private String params;
    @SuppressLint("StaticFieldLeak")
    private Context context;
    private OkHttpClient client;
    private String error="";
    private CustomDialoge customDialoge;
    public  WebService(Context context,WebServicesInterface webServicesInterface, String url, HashMap<String,String> hashMapParams) {
        this.context=context;
        this.webServicesInterface=webServicesInterface;
        this.url=url;
        this.hashMap=hashMapParams;
        client = new OkHttpClient();
    }

    public WebService(Context context,WebServicesInterface webServicesInterface, String url, HashMap<String, String> hashMapParams, ArrayList<File> arrayListFile) {
        this.context=context;
        this.webServicesInterface=webServicesInterface;
        this.url=url;
        this.hashMap=hashMapParams;
        this.arrayListFile=arrayListFile;
        client = new OkHttpClient();
    }
    public  WebService(Context context,WebServicesInterface webServicesInterface, String url,String  params) {
        this.context=context;
        this.webServicesInterface=webServicesInterface;
        this.url=url;
        this.params=params;
        client = new OkHttpClient();
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        //loLaodingBar.initLazyLoader();
        customDialoge=new CustomDialoge(context,true);
        customDialoge.show();
    }

    @Override
    protected String doInBackground(String... strings) {
        String result=null;
        try {
            if (arrayListFile == null) {
                result = postDataHashMap();
            } else {

            }
        } catch (Exception e) {
            error=e.getMessage();
            e.printStackTrace();
        }
        return result;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        if (customDialoge.isShowing()) {
            customDialoge.dismiss();
        }

        if (s != null) {
            webServicesInterface.onServerResponseSuccess(s);
        } else {
            webServicesInterface.onHandleFailure(error);
        }
    }
    private  String postDataHashMap() throws Exception {
        RequestBody requestBody;
        Request request = null;
        if (hashMap != null && arrayListFile == null) {
            requestBody=addParamsFromHashMap();
            request = new Request.Builder()
                    .url(url)
                    .post(requestBody)
                    .build();
        } else if (params != null) {
            try {
                request = new Request.Builder()
                        .url(url+params)
                        .build();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        Response response = client.newCall(request).execute();
            return response.body().string();

    }

    private  RequestBody addParamsFromHashMap() {
        FormBody.Builder requestBody= new FormBody.Builder();
        Set keys = hashMap.keySet();

        for (Object key1 : keys) {
            String key = (String) key1;
            String value = hashMap.get(key);
            requestBody.add(key, value);
        }
        return requestBody.build();
    }

}
