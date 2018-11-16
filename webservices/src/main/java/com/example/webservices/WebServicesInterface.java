package com.example.webservices;

public interface WebServicesInterface {
    void onServerResponseSuccess(String serverResponse);
    void onHandleFailure(String error);
}
