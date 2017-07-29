package com.archish.makeawish.data.remote;

import com.archish.makeawish.data.model.UserResponse;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by Archish on 7/29/2017.
 */

public interface UserRestService {

    @FormUrlEncoded
    @POST("auth/login")
    Observable<UserResponse> setLogin(@Field("fcm_token") String fcm_token, @Field("phoneno") String phoneno, @Field("password") String password);

    @FormUrlEncoded
    @POST("auth/logout")
    Observable<UserResponse> logout(@Field("accessToken") String accessToken);

}
