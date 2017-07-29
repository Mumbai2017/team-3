package com.archish.makeawish;

import android.util.Log;

import com.archish.makeawish.data.local.SharedPreferenceManager;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;



public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {

    private static final String TAG = "MyFirebaseIIDService";


    @Override
    public void onTokenRefresh() {
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, refreshedToken);
        storeToken(refreshedToken);
    }


    private void storeToken(String token) {
        //saving the token on shared preferences
        new SharedPreferenceManager(getApplicationContext()).saveDeviceToken(token);
    }


}