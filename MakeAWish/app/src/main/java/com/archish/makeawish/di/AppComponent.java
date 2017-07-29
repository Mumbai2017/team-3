package com.archish.makeawish.di;

/**
 * Created by Archish on 7/30/2017.
 */

import com.archish.makeawish.data.repository.UserRepository;
import com.archish.makeawish.data.repository.VolunteerRepository;

import javax.inject.Singleton;

import dagger.Component;


/**
 * Created by Archish on 7/29/2017.
 */

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    VolunteerRepository volunteerRepository();

    UserRepository userRepository();

}
