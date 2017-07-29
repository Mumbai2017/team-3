package com.archish.makeawish.di;

import com.archish.makeawish.data.implementations.VolunteerImpl;
import com.archish.makeawish.data.repository.VolunteerRepository;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Archish on 7/29/2017.
 */

@Component(modules = AppModule.class)
public interface AppComponent {
    VolunteerRepository volunteerRepository();

}
