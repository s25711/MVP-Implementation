package com.gabar.mvpsample.register;

import android.content.Intent;
import android.opengl.Visibility;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gabar.mvpsample.R;
import com.gabar.mvpsample.login.LoginActivity;
import com.gabar.mvpsample.mainScreen.MainActivity;
import com.tuyenmonkey.mkloader.MKLoader;
/**
 * Created by sanjeev on 7/8/17.
 */

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener,RegisterView{

    EditText edtUsername,edtEmail,edtPassword,edtConfirmPassword;
    TextView btnRegister;
    TextView txtLogin;
    LinearLayout loader;

    RegisterPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setUpViews();
    }

    public void setUpViews(){

        edtUsername=(EditText)findViewById(R.id.edtUsername);
        edtEmail=(EditText)findViewById(R.id.edtEmail);
        edtPassword=(EditText)findViewById(R.id.edtPassword);
        edtConfirmPassword=(EditText)findViewById(R.id.edtConfirmPassword);
        txtLogin=(TextView) findViewById(R.id.txtLogin);
        btnRegister=(TextView) findViewById(R.id.btnRegister);
        loader=(LinearLayout) findViewById(R.id.loader);

        txtLogin.setOnClickListener(this);
        btnRegister.setOnClickListener(this);

        presenter=new RegisterPresenterImpl(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.txtLogin:
                presenter.backtoLoginClick();
                break;

            case R.id.btnRegister:
                presenter.registerCredential(edtUsername.getText().toString(),
                        edtEmail.getText().toString(),
                        edtPassword.getText().toString(),
                        edtConfirmPassword.getText().toString());
                break;
        }
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
    public void userNameError() {
        edtUsername.setError("Please enter username");
    }

    @Override
    public void emailError() {
        edtEmail.setError("Please enter email");
    }

    @Override
    public void passwordError() {
        edtPassword.setError("Please enter password");
    }

    @Override
    public void confirmPassword() {
        edtConfirmPassword.setError("Please enter password again");
    }

    @Override
    public void navigateToHomeAfterSuccessFullRegisteration() {
        startActivity(new Intent(RegisterActivity.this, MainActivity.class));
        finish();
    }

    @Override
    public void navigateToLoginScreen() {
        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
        finish();
    }
}
