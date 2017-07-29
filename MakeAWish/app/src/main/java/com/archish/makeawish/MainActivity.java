package com.archish.makeawish;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.archish.makeawish.auth.LoginActivity;
import com.archish.makeawish.auth.LoginContract;
import com.archish.makeawish.auth.LoginPresenter;
import com.archish.makeawish.common.BaseActivity;
import com.archish.makeawish.common.Config;
import com.archish.makeawish.common.CustomFontLoader;
import com.archish.makeawish.common.MakeAWishApp;
import com.archish.makeawish.dashboard.HomeFragment;
import com.archish.makeawish.data.local.SharedPreferenceManager;
import com.archish.makeawish.data.model.UserResponse;
import com.archish.makeawish.data.repository.UserRepository;


/***
 * MainActivity
 * includes
 * NavigationDrawer.
 */

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener, LoginContract.LoginView {
    NavigationView navigationView = null;
    Toolbar toolbar = null;

    @Override
    public void onNetworkException(Throwable e) {
        super.onNetworkException(e);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.logout) {
            UserRepository userRepository = ((MakeAWishApp) getApplication()).getComponent().userRepository();
            LoginPresenter loginPresenter = new LoginPresenter(userRepository, this);
            loginPresenter.logout(new SharedPreferenceManager(getApplicationContext()).getAccessToken());
            showProgressDialog();
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        RepairRequestsListActivity fragment = new RepairRequestsListActivity();
//        android.support.v4.app.FragmentTransaction fragmentTransaction =
//                getSupportFragmentManager().beginTransaction();
//        fragmentTransaction.replace(R.id.fragment_container, fragment);
//        fragmentTransaction.commit();
        HomeFragment fragment = new HomeFragment();
        android.support.v4.app.FragmentTransaction fragmentTransaction =
                getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);

        //How to change elements in the header programatically
        View headerView = navigationView.getHeaderView(0);
        TextView role = (TextView) headerView.findViewById(R.id.email);
        if (new SharedPreferenceManager(getApplicationContext()).getCategory() == 3)
            role.setText(getString(R.string.volunteer));
        else if (new SharedPreferenceManager(getApplicationContext()).getCategory() == 4)
            role.setText(getString(R.string.donor));

        navigationView.setNavigationItemSelectedListener(this);
//        if (new SharedPreferenceManager(getApplicationContext()).getCategory() == 3)
//            navigationView.getMenu().findItem(R.id.nav_subscription).setVisible(false);
//        else if (new SharedPreferenceManager(getApplicationContext()).getCategory() == 4)
//            navigationView.getMenu().findItem(R.id.nav_assignment).setVisible(false);


    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        switch (id) {
            case R.id.nav_home:
                HomeFragment fragment = new HomeFragment();
                android.support.v4.app.FragmentTransaction fragmentTransaction =
                        getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.commit();
                break;

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void onLogin(UserResponse userResponse) {

    }

    @Override
    public void onLogout(UserResponse userResponse) {
        if (userResponse.getSuccess()) {
            dismissProgressDialog();
            new SharedPreferenceManager(getApplicationContext()).removeAccessToken();
            new SharedPreferenceManager(getApplicationContext()).removeCategory();
            new SharedPreferenceManager(getApplicationContext()).removeMainPage();
            Intent i = new Intent(MainActivity.this, LoginActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(i);
            finish();


        } else {
            dismissProgressDialog();
            Toast.makeText(MainActivity.this, "Oops something went wrong.", Toast.LENGTH_SHORT).show();
        }
    }

}
