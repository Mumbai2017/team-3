package com.archish.makeawish.auth;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Toast;


import com.archish.makeawish.MainActivity;
import com.archish.makeawish.R;
import com.archish.makeawish.common.BaseActivity;
import com.archish.makeawish.data.local.SharedPreferenceManager;
import com.archish.makeawish.data.model.UserResponse;
import com.archish.makeawish.data.repository.UserRepository;
import com.archish.makeawish.donor.DonorFragment;
import com.archish.makeawish.ui.widgets.BaseButton;
import com.archish.makeawish.ui.widgets.BaseEditText;
import com.archish.makeawish.ui.widgets.BaseTextView;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;
import static android.Manifest.permission.CAMERA;
import static android.Manifest.permission.GET_ACCOUNTS;
import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

/**
 * Created by Archish on 1/20/2017.
 */

public class LoginActivity extends BaseActivity implements LoginContract.LoginView {

    BaseTextView tvForgotPassword, tvCreateAccount;
    BaseEditText etEmailid, etPassword;
    BaseButton bLogin, bDonate;
    LoginPresenter loginPresenter;


    @Override
    public void onNetworkException(Throwable e) {
        super.onNetworkException(e);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestPermission();
        if (new SharedPreferenceManager(getApplicationContext()).getMainPage() != 0) {
            Intent i = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(i);
            finish();
        }
        setContentView(R.layout.activity_login);
        initViews();

        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean status = validate();
                if (status) {
                    showProgressDialog();
                    //            loginPresenter.login(new SharedPreferenceManager(getApplicationContext()).getDeviceToken(), etEmailid.getText().toString(), etPassword.getText().toString());
                    new SharedPreferenceManager(getApplicationContext()).saveMainPage(1);
                    new SharedPreferenceManager(getApplicationContext()).saveCategory(2);
                    Intent i = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        });
        tvCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), SignUpActivity.class);
                startActivity(i);
                finish();
            }
        });
    }

    private void initViews() {
        etEmailid = (BaseEditText) findViewById(R.id.etMobileNo);
        etPassword = (BaseEditText) findViewById(R.id.etPassword);
        tvCreateAccount = (BaseTextView) findViewById(R.id.tvCreate);
        bLogin = (BaseButton) findViewById(R.id.bLogin);
        bDonate = (BaseButton) findViewById(R.id.bDonate);
        bDonate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SharedPreferenceManager(getApplicationContext()).saveCategory(3);
                Intent i = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    public void onLogin(UserResponse userResponse) {
        dismissProgressDialog();
    }

    @Override
    public void onLogout(UserResponse userResponse) {

    }

    private boolean validate() {
        if (etEmailid.getText().toString().isEmpty()) {
            etEmailid.setError("Email Id cannot be empty");
            etEmailid.setFocusable(true);
            return false;
        } else if (etPassword.getText().toString().isEmpty()) {
            etPassword.setError("Password cannot be empty");
            etPassword.setFocusable(true);
            return false;
        }
        return true;
    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void requestPermission() {

        ActivityCompat.requestPermissions(this, new String[]{ACCESS_FINE_LOCATION, CAMERA, READ_EXTERNAL_STORAGE, WRITE_EXTERNAL_STORAGE, GET_ACCOUNTS}, 1001);

    }

    private void showMessageOKCancel(String message, DialogInterface.OnClickListener okListener) {
        new AlertDialog.Builder(LoginActivity.this)
                .setMessage(message)
                .setPositiveButton("OK", okListener)
                .setNegativeButton("Cancel", null)
                .create()
                .show();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1001:
                if (grantResults.length > 0) {


                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        if (shouldShowRequestPermissionRationale(ACCESS_FINE_LOCATION)) {
                            showMessageOKCancel("You need to allow access all the permissions",
                                    new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                                requestPermissions(new String[]{ACCESS_FINE_LOCATION, CAMERA, READ_EXTERNAL_STORAGE, WRITE_EXTERNAL_STORAGE, GET_ACCOUNTS},
                                                        1001);
                                            }
                                        }
                                    });
                            return;
                        }
                    }

                }
                break;
        }
    }

}
