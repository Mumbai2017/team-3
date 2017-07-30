package com.archish.makeawish.volunteer;

import com.archish.makeawish.data.model.Success;
import com.archish.makeawish.data.repository.VolunteerRepository;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Archish on 7/29/2017.
 */

public class VolunteerSignupPresenter implements VolunteerSignupContracts.VolunteerSignupPresenter {

    VolunteerSignupContracts.VolunteerSignupView view;
    VolunteerRepository volunteerRepository;

    public VolunteerSignupPresenter(VolunteerRepository volunteerRepository, VolunteerSignupContracts.VolunteerSignupView view) {
        this.view = view;
        this.volunteerRepository = volunteerRepository;
    }

    @Override
    public void fetchData(String fullname, String mobileno, String info, String sPrefLoc, String emailid, String want, String password) {
        volunteerRepository.fetchData(fullname, mobileno, info, sPrefLoc, emailid, want, password)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Success>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        if (view != null) {
                            e.printStackTrace();
                            view.onNetworkException(e);

                        }

                    }

                    @Override
                    public void onNext(Success success) {
                        if (view != null)
                            view.onData(success);

                    }
                });
    }

    @Override
    public void getData(String q) {
        volunteerRepository.getData(q).observeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Success>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(Success success) {
                        if (view != null)
                            view.onData(success);
                    }
                });
    }
}
