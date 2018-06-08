package com.gabar.mvpsample.login;

import java.util.logging.Handler;

/**
 * Created by sanjeev on 7/8/17.
 */


public class LoginIteracterImpl implements LoginInteracter {
    LoginView loginView;

    LoginIteracterImpl(LoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void login(String email, String Password) {


        loginView.showProgress();
        android.os.Handler handler = new android.os.Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                loginView.hideProgress();
                loginView.navigateToHome();

            }
        }, 3000);

    }

}
