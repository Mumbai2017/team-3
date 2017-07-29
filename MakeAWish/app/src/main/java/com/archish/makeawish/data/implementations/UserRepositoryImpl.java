package com.archish.makeawish.data.implementations;


import com.archish.makeawish.data.model.HomeWrapper;
import com.archish.makeawish.data.model.UserResponse;
import com.archish.makeawish.data.remote.UserRestService;
import com.archish.makeawish.data.repository.UserRepository;

import rx.Observable;

public class UserRepositoryImpl implements UserRepository {

    private UserRestService userRestService;

    public UserRepositoryImpl(UserRestService userRestService) {
        this.userRestService = userRestService;
    }


    @Override
    public Observable<UserResponse> setUser(String fcm_token, String fname, String lname, String emailid, String phoneno, String password, int role) {
        return null;
    }

    @Override
    public Observable<UserResponse> getUser() {
        return null;
    }

    @Override
    public Observable<HomeWrapper> getHomeData(String accessToken) {
        return null;
    }

    @Override
    public Observable<UserResponse> setLogin(String fcm_token, String phoneno, String password) {
        return userRestService.setLogin(fcm_token, phoneno, password);
    }

    @Override
    public Observable<UserResponse> logout(String accessToken) {
        return userRestService.logout(accessToken);
    }


}
