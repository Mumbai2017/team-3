package com.archish.makeawish.data.remote;

import com.archish.makeawish.data.model.ErrorResponse;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Archish on 7/29/2017.
 */

public interface VolunteerRestService {
    @GET("data.php")
    Observable<ErrorResponse> fetchData();
}
