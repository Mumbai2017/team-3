package com.archish.makeawish.volunteer;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatSpinner;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.archish.makeawish.R;
import com.archish.makeawish.common.BaseActivity;
import com.archish.makeawish.common.JSONParser;
import com.archish.makeawish.data.model.Success;
import com.archish.makeawish.ui.widgets.BaseButton;
import com.archish.makeawish.ui.widgets.BaseEditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Archish on 7/29/2017.
 */

public class VolunteerSignupActivity extends BaseActivity implements VolunteerSignupContracts.VolunteerSignupView {
    BaseEditText etFullName, etWant, etEmailid, etMobile, etPassword;
    RadioGroup tvInfo;
    AppCompatSpinner appCompatSpinner;
    BaseButton bSubmit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_volunteer);
        initViews();
    }


    private void initViews() {
        etPassword = (BaseEditText) findViewById(R.id.etPassword);
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
                int selectedId = tvInfo.getCheckedRadioButtonId();
                RadioButton radioButton = (RadioButton) findViewById(selectedId);
                new PushDataTask(etFullName.getText().toString(), etMobile.getText().toString()
                        , radioButton.getText().toString(), String.valueOf(appCompatSpinner.getSelectedItemPosition() + 1), etEmailid.getText().toString(), etWant.getText().toString(), etPassword.getText().toString()).execute();
            }
        });
    }

    class PushDataTask extends AsyncTask<String, String, JSONObject> {
        String fullName;
        String mobileNo;
        String tvInfo;
        String spinner;
        String email, etWant, etPassword;

        public PushDataTask(String fullName, String mobileNo, String tvInfo, String spinner, String email, String etWant, String etPassword) {
            this.fullName = fullName;
            this.mobileNo = mobileNo;
            this.tvInfo = tvInfo;
            this.spinner = spinner;
            this.email = email;
            this.etWant = etWant;
            this.etPassword = etPassword;
        }

        @Override
        protected JSONObject doInBackground(String... params) {
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = jsonParser.getJSONFromUrl("http://54.255.246.22/temp.php");
            return jsonObject;
        }

        @Override
        protected void onPostExecute(JSONObject jsonObject) {
            super.onPostExecute(jsonObject);
            try {
                JSONArray jsonArray = jsonObject.getJSONArray("data");
                JSONObject jsonObject1 = jsonArray.getJSONObject(0);
                String id = jsonObject1.getString("id");
                String name = jsonObject1.getString("name");
                String email = jsonObject1.getString("email");
                Log.d("Main Value", id + name + email);
            } catch (JSONException e) {
                e.printStackTrace();
            }


        }
    }

    @Override
    public void onData(Success success) {
        Toast.makeText(VolunteerSignupActivity.this, "Called", Toast.LENGTH_SHORT).show();
    }
}