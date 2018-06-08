package com.gabar.mvpsample.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gabar.mvpsample.MyCustomApplciation;
import com.gabar.mvpsample.R;
import com.gabar.mvpsample.mainScreen.MainActivity;
import com.gabar.mvpsample.register.RegisterActivity;
import com.tuyenmonkey.mkloader.MKLoader;
/**
 * Created by sanjeev on 7/8/17.
 */

public class LoginActivity extends AppCompatActivity implements LoginView,View.OnClickListener {

    EditText edtEmail,edtPassword;
    Button btnLogin;
    LinearLayout loader;
    TextView txtRegister;

    LoginPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setUpViews();



    }

    public void setUpViews(){

        presenter=new LoginPresenterImpl(this);
        edtEmail= (EditText) findViewById(R.id.edtEmail);
        edtPassword=(EditText)findViewById(R.id.edtPassword);
        btnLogin= (Button) findViewById(R.id.btnLogin);
        loader=(LinearLayout) findViewById(R.id.loader);
        txtRegister=(TextView)findViewById(R.id.txtRegister);

        btnLogin.setOnClickListener(this);
        txtRegister.setOnClickListener(this);

    }

    @Override
    public void showProgress() {
        loader.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        loader.setVisibility(View.GONE);
    }

    @Override
    public void setUsernameError() {
        edtEmail.setError("Please enter Email");
    }

    @Override
    public void setPasswordError()  {

        edtPassword.setError("Please enter Password");
    }

    @Override
    public void navigateToHome() {
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
        finish();
    }

    @Override
    public void navigateToRegisterScreen() {
        startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
        finish();
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btnLogin:
                presenter.loginCredential(edtEmail.getText().toString(),edtPassword.getText().toString());

                break;
            case R.id.txtRegister:
                presenter.signupNavigation();
                break;

        }

    }

   /* public void getException() throws MyCustomException{
        if (sample.getText().toString().equals("")){
            throw new MyCustomException("Password  is null");
        }else{

        }
    }

    public class MyCustomException extends Exception{
        MyCustomException(String s){
            super(s);
        }

    }*/

}
