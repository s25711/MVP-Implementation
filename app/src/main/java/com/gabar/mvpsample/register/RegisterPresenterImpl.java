package com.gabar.mvpsample.register;

import android.widget.Toast;

/**
 * Created by sanjeev on 7/8/17.
 */


public class RegisterPresenterImpl implements RegisterPresenter  {

    RegisterView registerView;
    RegisterInteracter registerInteracter;

    RegisterPresenterImpl(RegisterView registerView){
        this.registerView=registerView;
        this.registerInteracter=new RegisterIntracterImpl(registerView);
    }
    @Override
    public void registerCredential(String username, String email, String password, String confirmPassword) {
        if (registerView!=null){
            if (username.isEmpty()){
               registerView.userNameError();
            }else if (email.isEmpty()){
                registerView.emailError();
            }else if (password.isEmpty()){
                registerView.passwordError();
            }else if (confirmPassword.isEmpty()){
                registerView.confirmPassword();
            }else{
                registerInteracter.Registeration(username,email,password,confirmPassword);
            }
        }
    }

    @Override
    public void backtoLoginClick() {
        registerView.navigateToLoginScreen();
    }
}
