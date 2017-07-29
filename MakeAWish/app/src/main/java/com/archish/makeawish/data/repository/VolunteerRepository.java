package com.archish.makeawish.data.repository;

import com.archish.makeawish.data.model.ErrorResponse;
import com.archish.makeawish.data.model.Success;

import rx.Observable;

/**
 * Created by Archish on 7/29/2017.
 */

public interface VolunteerRepository {
    Observable<Success> fetchData(String fullname, String info, String sPrefLoc, String emailid, String want);
}
