package com.archish.makeawish.volunteer;

import com.archish.makeawish.common.BaseContract;
import com.archish.makeawish.data.model.Success;

import rx.Observable;

/**
 * Created by Archish on 7/29/2017.
 */

public interface VolunteerSignupContracts {
    interface VolunteerSignupView extends BaseContract.BaseView {
        void onData(Success success);
    }

    interface VolunteerSignupPresenter {
        void fetchData(String fullname,String mobileno, String info, String sPrefLoc, String emailid, String want,String password);
    }
}
