package com.archish.makeawish.dashboard;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ProgressBar;

import com.archish.makeawish.MainActivity;
import com.archish.makeawish.R;
import com.archish.makeawish.data.local.SharedPreferenceManager;
import com.archish.makeawish.data.model.Home;
import com.archish.makeawish.data.model.HomeWrapper;
import com.archish.makeawish.data.repository.UserRepository;
import com.archish.makeawish.volunteer.VolunteerFormFilling;

import java.util.ArrayList;

public class HomeFragment extends Fragment implements HomeContract.HomeView, HomeAdapter.LikeItemUpdateListener {
    RecyclerView rvHome;
    FloatingActionButton floatingActionButton;
    WebView tvWeb;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        rvHome = (RecyclerView) view.findViewById(R.id.rvHome);
        tvWeb = (WebView) view.findViewById(R.id.tvWeb);
        tvWeb.loadUrl("http://");
        floatingActionButton = (FloatingActionButton) view.findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), VolunteerFormFilling.class);
                startActivity(i);
            }
        });
        rvHome.setHasFixedSize(true);
        rvHome.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        ArrayList<Home> homes = new ArrayList<>();
        homes.add(new Home(1, "Ram Mohan", "To meet Sachin Tendulkar.", "10/12/2015", "Yes", 3, "Mumbai"));
        homes.add(new Home(2, "Neha", "To have Doll .", "10/12/2015", "Yes", 2, "Mumbai"));
        homes.add(new Home(3, "Karan", "To be Famous.", "10/12/2015", "Yes", 1, "Mumbai"));
        homes.add(new Home(4, "Rashi", "To meet Steve Jobs.", "10/12/2015", "Yes", 3, "Mumbai"));
        homes.add(new Home(5, "Raj", "To meet Sachin Tendulkar.", "3/2/2016", "Yes", 2, "Mumbai"));
        homes.add(new Home(6, "Mihir", "To have Doll .", "10/12/2015", "No", 1, "Mumbai"));
        homes.add(new Home(7, "Joy", "To be Famous.", "6/11/2017", "No", 1, "Mumbai"));
        homes.add(new Home(8, "Kajal", "To be Singer.", "10/12/2017", "Yes", 2, "Mumbai"));

        HomeAdapter homeAdapter = new HomeAdapter(homes, this);
        rvHome.setAdapter(homeAdapter);
        return view;
    }


    @Override
    public void onItemStatusChanged(Home home) {

    }

    @Override
    public void onItemCardClicked(Home home) {
        Intent i = new Intent(getActivity(), PatientDetails.class);
        i.putExtra("home", home);
        startActivity(i);

    }

    @Override
    public void onNetworkException(Throwable e) {

    }

    @Override
    public void onHomeData(HomeWrapper homeWrapper) {

    }
}