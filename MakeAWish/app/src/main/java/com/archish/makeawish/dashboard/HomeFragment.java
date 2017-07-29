package com.archish.makeawish.dashboard;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.archish.makeawish.R;
import com.archish.makeawish.data.local.SharedPreferenceManager;
import com.archish.makeawish.data.model.Home;
import com.archish.makeawish.data.model.HomeWrapper;
import com.archish.makeawish.data.repository.UserRepository;

import java.util.ArrayList;

public class HomeFragment extends Fragment implements HomeContract.HomeView, HomeAdapter.LikeItemUpdateListener {

    SwipeRefreshLayout swipeRefreshLayout;
    RecyclerView rvHome;
    HomePresenter homePresenter;
    ProgressBar pgProgress;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        rvHome = (RecyclerView) view.findViewById(R.id.rvHome);
        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.srlHome);
        rvHome.setHasFixedSize(true);
        rvHome.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        homePresenter.fetchHomeData(new SharedPreferenceManager(getActivity().getApplicationContext()).getAccessToken());
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //        homePresenter.fetchHomeData(new SharedPreferenceManager(getActivity().getApplicationContext()).getAccessToken());
            }
        });
        return view;
    }

    @Override
    public void onHomeData(HomeWrapper homeWrapper) {
        ArrayList<Home> homes = new ArrayList<>();
        for (int i = 0; i < homeWrapper.data.size(); i++) {
            Home home = new Home(homeWrapper.data.get(i).getHid()
                    , homeWrapper.data.get(i).getHtitle()
                    , homeWrapper.data.get(i).getHdesc()
                    , homeWrapper.data.get(i).getHimage());
            homes.add(home);
        }
        HomeAdapter homeAdapter = new HomeAdapter(homes, this);
        rvHome.setAdapter(homeAdapter);
        if (swipeRefreshLayout.isRefreshing())
            swipeRefreshLayout.setRefreshing(false);
        pgProgress.setVisibility(View.GONE);
    }

    @Override
    public void onItemStatusChanged(Home home) {
        Intent sharingIntent = new Intent(Intent.ACTION_SEND);
        sharingIntent.setType("text/html");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, home.getHtitle() + "\n" + home.getHdesc());
        startActivity(Intent.createChooser(sharingIntent, "Share using"));
    }

    @Override
    public void onItemCardClicked(Home home) {

    }

    @Override
    public void onNetworkException(Throwable e) {

    }
}