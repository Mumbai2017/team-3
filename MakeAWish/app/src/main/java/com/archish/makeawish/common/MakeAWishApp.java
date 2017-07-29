package com.archish.makeawish.common;

import android.app.Application;

import com.archish.makeawish.di.AppComponent;
import com.archish.makeawish.di.AppModule;

/**
 * Created by Archish on 2/23/2017.
 */

public class MakeAWishApp extends Application {
    private AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        initCompontent();
    }
    private void initCompontent()
    {
        component = DaggerAppComponent.builder().appModule(new AppModule()).build();
    }
    public AppComponent getComponent() {
        return component;
    }
}
