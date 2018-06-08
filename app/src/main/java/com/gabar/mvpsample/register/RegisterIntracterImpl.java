package com.gabar.mvpsample.register;

import android.os.Handler;

import com.gabar.mvpsample.login.LoginView;

/**
 * Created by sanjeev on 7/8/17.
 */
public class RegisterIntracterImpl implements RegisterInteracter  {

    RegisterView registerView;

    RegisterIntracterImpl(RegisterView registerView){
        this.registerView=registerView;
    }
    @Override
    public void Registeration(String username, String email, String password, String confirmPassword) {
        registerView.showProgress();
        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                registerView.navigateToHomeAfterSuccessFullRegisteration();
                registerView.hideProgress();
            }
        },3000);
    }
}
