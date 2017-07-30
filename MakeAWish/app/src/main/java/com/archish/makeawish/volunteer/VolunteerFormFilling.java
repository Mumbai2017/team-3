package com.archish.makeawish.volunteer;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.archish.makeawish.R;
import com.archish.makeawish.ui.widgets.BaseButton;

/**
 * Created by Archish on 7/30/2017.
 */

public class VolunteerFormFilling extends AppCompatActivity {
    BaseButton baseButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capture_by_volunteer);
        baseButton = (BaseButton) findViewById(R.id.bSubmit);
        baseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(VolunteerFormFilling.this, SpeechToTextActivity.class);
                startActivity(i);
            }
        });
    }
}
