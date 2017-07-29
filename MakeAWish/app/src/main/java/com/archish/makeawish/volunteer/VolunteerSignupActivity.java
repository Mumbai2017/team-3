package com.archish.makeawish.volunteer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatSpinner;
import android.view.View;
import android.widget.RadioGroup;

import com.archish.makeawish.R;
import com.archish.makeawish.common.BaseActivity;
import com.archish.makeawish.common.MakeAWishApp;
import com.archish.makeawish.data.model.Success;
import com.archish.makeawish.data.repository.VolunteerRepository;
import com.archish.makeawish.ui.widgets.BaseButton;
import com.archish.makeawish.ui.widgets.BaseEditText;

/**
 * Created by Archish on 7/29/2017.
 */

public class VolunteerSignupActivity extends BaseActivity implements VolunteerSignupContracts.VolunteerSignupView {
    BaseEditText etFullName, etWant, etEmailid, etMobile;
    RadioGroup tvInfo;
    AppCompatSpinner appCompatSpinner;
    BaseButton bSubmit;

    VolunteerSignupPresenter volunteerSignupPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_volunteer);
        initViews();
    }

    @Override
    public void onNetworkException(Throwable e) {
        super.onNetworkException(e);
    }

    private void initViews() {
        final VolunteerRepository volunteerRepository = ((MakeAWishApp) getApplication()).getComponent().volunteerRepository();
        volunteerSignupPresenter = new VolunteerSignupPresenter(volunteerRepository, this);

        etEmailid = (BaseEditText) findViewById(R.id.tvEmailid);
        etMobile = (BaseEditText) findViewById(R.id.tvMobile);
        etFullName = (BaseEditText) findViewById(R.id.etFullName);
        tvInfo = (RadioGroup) findViewById(R.id.tvInfo);
        appCompatSpinner = (AppCompatSpinner) findViewById(R.id.sPrefLoc);
        etWant = (BaseEditText) findViewById(R.id.etWant);
        bSubmit = (BaseButton) findViewById(R.id.bSubmit);
        bSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                volunteerSignupPresenter.fetchData(etFullName.getText().toString()
                ,tvInfo.get);
            }
        });
    }

    @Override
    public void onData(Success success) {

    }
}