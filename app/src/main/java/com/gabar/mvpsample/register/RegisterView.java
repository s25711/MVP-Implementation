package com.gabar.mvpsample.register;

/**
 * Created by sanjeev on 7/8/17.
 */

public interface RegisterView {

    void showProgress();

    void hideProgress();

    void userNameError();

    void emailError();

    void passwordError();

    void confirmPassword();

    void navigateToHomeAfterSuccessFullRegisteration();

    void navigateToLoginScreen();
}
