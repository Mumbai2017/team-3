package com.archish.makeawish.dashboard;


import com.archish.makeawish.common.BaseContract;
import com.archish.makeawish.data.model.HomeWrapper;

public interface HomeContract {
    interface HomeView extends BaseContract.BaseView{
        void onHomeData(HomeWrapper homeWrapper);
    }
    interface HomePresenter{
        void fetchHomeData(String accessToken);
    }
}
