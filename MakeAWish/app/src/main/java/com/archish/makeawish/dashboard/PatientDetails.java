package com.archish.makeawish.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.archish.makeawish.R;
import com.archish.makeawish.data.model.Home;

/**
 * Created by Archish on 7/30/2017.
 */

public class PatientDetails extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_details);
        Intent t = getIntent();
        Home home = t.getParcelableExtra("home");

    }
}
