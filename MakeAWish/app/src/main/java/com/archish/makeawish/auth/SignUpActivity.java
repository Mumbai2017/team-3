package com.archish.makeawish.auth;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.widget.LinearLayout;

import com.archish.makeawish.R;
import com.archish.makeawish.common.BaseActivity;
import com.archish.makeawish.volunteer.VolunteerSignupActivity;


public class SignUpActivity extends BaseActivity {
    LinearLayout llVolunteer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        initViews();
    }
    private void initViews()
    {
        llVolunteer = (LinearLayout) findViewById(R.id.llVolunteer);
        llVolunteer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), VolunteerSignupActivity.class);
                startActivity(i);
            }
        });
    }
}
