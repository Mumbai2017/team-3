package com.archish.makeawish.di;

import com.archish.makeawish.common.Config;
import com.archish.makeawish.data.implementations.VolunteerImpl;
import com.archish.makeawish.data.remote.VolunteerRestService;
import com.archish.makeawish.data.repository.VolunteerRepository;
import com.archish.makeawish.network.RxErrorHandlingCallAdapterFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Archish on 7/29/2017.
 */
@Module
public class AppModule {
    @Provides
    @Singleton
    VolunteerRepository provideVolunteerRepository(VolunteerRestService volunteerRestService) {
        return new VolunteerImpl(volunteerRestService);
    }

    @Provides
    @Singleton
    VolunteerRestService provideVolunteerRestService(Retrofit retrofit) {
        return retrofit.create(VolunteerRestService.class);
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(Config.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxErrorHandlingCallAdapterFactory.create())
                .build();
    }
}