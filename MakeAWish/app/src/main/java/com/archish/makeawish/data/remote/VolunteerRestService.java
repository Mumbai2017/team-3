package com.archish.makeawish.data.remote;

import com.archish.makeawish.data.model.ErrorResponse;
import com.archish.makeawish.data.model.Success;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Archish on 7/29/2017.
 */

public interface VolunteerRestService {
    @FormUrlEncoded
    @POST("/backend/volunteer/volunteer_signup.php")
    Observable<Success> fetchData(@Field("vname") String fullname, @Field("vcontact") String mobileno, @Field("reference") String info, @Field("prefloc") String sPrefLoc, @Field("vemail") String emailid, @Field("reason") String want, @Field("password") String password);

    @GET("/")
    Observable<Success> getData(@Query("q") String q);
}
