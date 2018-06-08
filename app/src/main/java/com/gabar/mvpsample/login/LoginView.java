package com.gabar.mvpsample.login;

/**
 * Created by sanjeev on 7/8/17.
 */


public interface LoginView {
    void showProgress();

    void hideProgress();

    void setUsernameError();

    void setPasswordError();

    void navigateToHome();

    void navigateToRegisterScreen();
}
