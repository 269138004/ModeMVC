package com.example.administrator.modemvc;

import android.content.Context;
import android.text.TextUtils;
import android.view.TextureView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class LoginModel implements LoginIModel {

    private Context context;
    private LoginListener loginListener;

    public LoginModel(Context context , LoginListener loginListener) {
        this.context = context;
        this.loginListener = loginListener;
    }

    @Override
    public void userLogin(String account, String password) {

        if (TextUtils.isEmpty(account)){
            Toast.makeText(context, "请输入账号...", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(password)){
            Toast.makeText(context, "请输入密码...", Toast.LENGTH_SHORT).show();
            return;
        }
        loginListener.onUserLoginSuccess();
    }

    public interface LoginListener{
        void onUserLoginSuccess();
        void onUserLoginError();
    }
}
