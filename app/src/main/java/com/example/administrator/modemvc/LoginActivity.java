package com.example.administrator.modemvc;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends Activity implements View.OnClickListener, LoginModel.LoginListener {

    private Button btn_login;
    private EditText et_account , et_password;
    private LoginModel model;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        model = new LoginModel(this , this);
        initView();
    }

    private void initView() {
        btn_login = findViewById(R.id.btn_login);
        et_account = findViewById(R.id.et_account);
        et_password = findViewById(R.id.et_password);
        btn_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_login:
                model.userLogin(et_account.getText().toString().trim() , et_password.getText().toString().trim());
                break;
        }
    }

    @Override
    public void onUserLoginSuccess() {
        btn_login.setVisibility(View.GONE);
    }

    @Override
    public void onUserLoginError() {

    }
}
