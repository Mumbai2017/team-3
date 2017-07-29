package com.archish.makeawish.data.implementations;

import com.archish.makeawish.data.model.ErrorResponse;
import com.archish.makeawish.data.model.Success;
import com.archish.makeawish.data.remote.VolunteerRestService;
import com.archish.makeawish.data.repository.VolunteerRepository;

import rx.Observable;

/**
 * Created by Archish on 7/29/2017.
 */

public class VolunteerImpl implements VolunteerRepository {
    private VolunteerRestService volunteerService;

    public VolunteerImpl(VolunteerRestService volunteerService) {
        this.volunteerService = volunteerService;
    }



    @Override
    public Observable<Success> fetchData(String fullname,String mobileno, String info, String sPrefLoc, String emailid, String want,String password) {
        return volunteerService.fetchData(fullname,mobileno,info,sPrefLoc,emailid,want,password);
    }
}
