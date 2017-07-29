package com.archish.makeawish.data.repository;

import com.archish.makeawish.data.model.ErrorResponse;
import com.archish.makeawish.data.model.Success;

import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Archish on 7/29/2017.
 */

public interface VolunteerRepository {
    Observable<Success> getData(String q);
    Observable<Success> fetchData(String fullname, String mobileno, String info, String sPrefLoc, String emailid, String want, String password);
}
