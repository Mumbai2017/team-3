package com.archish.makeawish.volunteer;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatSpinner;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.archish.makeawish.R;
import com.archish.makeawish.common.BaseActivity;
import com.archish.makeawish.common.JSONParser;
import com.archish.makeawish.common.MakeAWishApp;
import com.archish.makeawish.data.model.Success;
import com.archish.makeawish.data.repository.VolunteerRepository;
import com.archish.makeawish.ui.widgets.BaseButton;
import com.archish.makeawish.ui.widgets.BaseEditText;
import com.google.gson.JsonParser;

import org.json.JSONObject;

/**
 * Created by Archish on 7/29/2017.
 */

public class VolunteerSignupActivity extends BaseActivity implements VolunteerSignupContracts.VolunteerSignupView {
    BaseEditText etFullName, etWant, etEmailid, etMobile, etPassword;
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


    private void initViews() {
        final VolunteerRepository volunteerRepository = ((MakeAWishApp) getApplication()).getComponent().volunteerRepository();
        volunteerSignupPresenter = new VolunteerSignupPresenter(volunteerRepository, this);
        etPassword = (BaseEditText) findViewById(R.id.etPassword);
        etEmailid = (BaseEditText) findViewById(R.id.tvEmailid);
        etMobile = (BaseEditText) findViewById(R.id.tvMobile);
        etFullName = (BaseEditText) findViewById(R.id.etFullName);
        tvInfo = (RadioGroup) findViewById(R.id.tvInfo);
        appCompatSpinner = (AppCompatSpinner) findViewById(R.id.sPrefLoc);
        etWant = (BaseEditText) findViewById(R.id.etWant);
        bSubmit = (BaseButton) findViewById(R.id.bSubmit);
        new
//        bSubmit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                int selectedId = tvInfo.getCheckedRadioButtonId();
//                RadioButton radioButton = (RadioButton) findViewById(selectedId);
//                volunteerSignupPresenter.fetchData(etFullName.getText().toString(), etMobile.getText().toString()
//                        , radioButton.getText().toString(), String.valueOf(appCompatSpinner.getSelectedItemPosition() + 1), etEmailid.getText().toString(), etWant.getText().toString(), etPassword.getText().toString());
//            }
//        });
    }

class PushDataTask extends AsyncTask<String,String,JSONObject>{

    @Override
    protected JSONObject doInBackground(String... params) {
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = jsonParser.getJSONFromUrl(url)
        return ;
    }
}
    @Override
    public void onData(Success success) {
        Toast.makeText(VolunteerSignupActivity.this, "Called", Toast.LENGTH_SHORT).show();
    }
}