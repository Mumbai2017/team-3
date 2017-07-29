package com.archish.makeawish.common;

/**
 * Created by Archish on 7/30/2017.
 */

import android.app.Application;
import android.app.Application;

import com.archish.makeawish.di.AppComponent;
import com.archish.makeawish.di.AppModule;
import com.archish.makeawish.di.DaggerAppComponent;


public class MakeAWishApp extends Application {
    private AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        initCompontent();
    }

    private void initCompontent() {
        component = DaggerAppComponent.builder().appModule(new AppModule()).build();
    }

    public AppComponent getComponent() {
        return component;
    }
}
