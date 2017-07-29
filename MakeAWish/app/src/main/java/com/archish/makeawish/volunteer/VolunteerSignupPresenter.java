package com.archish.makeawish.volunteer;

import com.archish.makeawish.data.model.Success;

import rx.Observable;

/**
 * Created by Archish on 7/29/2017.
 */

public class VolunteerSignupPresenter implements VolunteerSignupContracts.VolunteerSignupPresenter {

    VolunteerContracts.LoginView view;
    UserRepository userRepository;

    public LoginPresenter(UserRepository userRepository, LoginContract.LoginView view) {
        this.view = view;
        this.userRepository = userRepository;
    }

}
