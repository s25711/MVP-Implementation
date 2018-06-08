package com.gabar.mvpsample.register;

/**
 * Created by sanjeev on 7/8/17.
 */

public interface RegisterPresenter {
    void registerCredential(String username,String email,String password,String confirmPassword);

    void backtoLoginClick();
}
