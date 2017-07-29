package com.archish.makeawish.data.remote;

import com.archish.makeawish.data.model.ErrorResponse;
import com.archish.makeawish.data.model.Success;

import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by Archish on 7/29/2017.
 */

public interface VolunteerRestService {
    @POST("volunteer_signup.php")
    Observable<Success> fetchData(@Field("vname") String fullname, @Field("vcontact") String mobileno, @Field("vname") String info, @Field("reference") String sPrefLoc, @Field("emailid") String emailid, @Field("want") String want, @Field("password") String password);
}
