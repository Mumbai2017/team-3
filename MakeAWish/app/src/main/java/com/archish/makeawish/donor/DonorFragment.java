package com.archish.makeawish.donor;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.archish.makeawish.R;
import com.archish.makeawish.ui.widgets.BaseButton;

/**
 * Created by Archish on 7/30/2017.
 */

public class DonorFragment extends android.support.v4.app.Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.donor, container, false);
        Button baseButton = (Button) view.findViewById(R.id.button1);
        baseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), DonorInfoActivity.class);
                startActivity(i);
            }
        });
        Button baseButton1 = (Button) view.findViewById(R.id.button);
        baseButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), DonateNowActivity.class);
                startActivity(i);
            }
        });
        return view;
    }
}
