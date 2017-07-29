package com.archish.makeawish.data.repository;


import com.archish.makeawish.data.model.HomeWrapper;
import com.archish.makeawish.data.model.Success;
import com.archish.makeawish.data.model.UserResponse;

import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Archish on 1/14/2017.
 */

public interface UserRepository {


    Observable<UserResponse> setLogin(String fcm_token, String emailid, String password);

    Observable<UserResponse> logout(String accessToken);


}
