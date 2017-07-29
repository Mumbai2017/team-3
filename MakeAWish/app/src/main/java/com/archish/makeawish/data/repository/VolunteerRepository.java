package com.archish.makeawish.data.repository;

import com.archish.makeawish.data.model.ErrorResponse;

import rx.Observable;

/**
 * Created by Archish on 7/29/2017.
 */

public interface VolunteerRepository {
    Observable<ErrorResponse> fetchData();
}
