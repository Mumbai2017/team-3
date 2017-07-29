package com.archish.makeawish.volunteer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatSpinner;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.archish.makeawish.R;
import com.archish.makeawish.data.model.Success;
import com.archish.makeawish.ui.widgets.BaseButton;
import com.archish.makeawish.ui.widgets.BaseEditText;
import com.archish.makeawish.ui.widgets.BaseRadioButton;

/**
 * Created by Archish on 7/29/2017.
 */

public class VolunteerSignupActivity extends AppCompatActivity implements VolunteerSignupContracts.VolunteerSignupView {
    BaseEditText etFullName,etWant;
    RadioGroup tvInfo;
    AppCompatSpinner appCompatSpinner;
    BaseButton bSubmit;
    Volunteer
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_volunteer);
        initViews();
    }

    private void initViews() {
        etFullName = (BaseEditText) findViewById(R.id.etFullName);
        tvInfo = (RadioGroup) findViewById(R.id.tvInfo);
        appCompatSpinner = (AppCompatSpinner) findViewById(R.id.sPrefLoc);
        etWant = (BaseEditText) findViewById(R.id.etWant);
        bSubmit = (BaseButton) findViewById(R.id.bSubmit);
        bSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public void onData(Success success) {

    }
}
