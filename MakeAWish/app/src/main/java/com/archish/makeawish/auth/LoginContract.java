package com.archish.makeawish.auth;


import com.archish.makeawish.common.BaseContract;
import com.archish.makeawish.data.model.UserResponse;

public interface LoginContract {
    interface LoginView extends BaseContract.BaseView {
        void onLogin(UserResponse userResponse);

        void onLogout(UserResponse userResponse);

    }

    interface LoginPresenter {
        void login(String fcm_token, String emailid, String password);

        void logout(String accessToken);
    }
}
