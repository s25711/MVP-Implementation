package com.gabar.mvpsample.login;

/**
 * Created by sanjeev on 7/8/17.
 */

public class LoginPresenterImpl implements LoginPresenter {
    LoginView loginView;
    LoginInteracter loginInteracter;
    LoginPresenterImpl(LoginView loginView){
        this.loginView=loginView;
        this.loginInteracter=new LoginIteracterImpl(loginView);
    }
    @Override
    public void loginCredential(String emailId, String password) {

        if (loginView!=null){
            if (emailId.isEmpty()){
                loginView.setUsernameError();
            }else if (password.isEmpty()){
                loginView.setPasswordError();
            }else{
                loginInteracter.login(emailId,password);
            }
        }

    }

    @Override
    public void signupNavigation() {
        loginView.navigateToRegisterScreen();
    }
}
