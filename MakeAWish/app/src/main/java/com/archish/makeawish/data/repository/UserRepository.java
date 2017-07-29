package com.archish.makeawish.data.repository;


import com.archish.makeawish.data.model.HomeWrapper;
import com.archish.makeawish.data.model.UserResponse;

import rx.Observable;

/**
 * Created by Archish on 1/14/2017.
 */

public interface UserRepository {
    Observable<UserResponse> setUser(String fcm_token,
                                     String fname,
                                     String lname,
                                     String emailid,
                                     String phoneno,
                                     String password,
                                     int role);

    Observable<UserResponse> getUser();


    Observable<HomeWrapper> getHomeData(String accessToken);


    Observable<UserResponse> setLogin(String fcm_token, String emailid, String password);
    Observable<UserResponse> logout(String accessToken);


}
