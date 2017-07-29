package com.archish.makeawish.volunteer;

import com.archish.makeawish.data.model.Success;

import rx.Observable;

/**
 * Created by Archish on 7/29/2017.
 */

public interface VolunteerSignupContracts {
    interface VolunteerSignupView{
        void onData(Success success);
    }
    interface VolunteerSignupPresenter{
        void fetchData(String );
    }
}
