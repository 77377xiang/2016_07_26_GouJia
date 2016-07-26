package com.xiang.acticity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.xiang.base.BaseActivity;
import com.xiang.data.UserResponse;
import com.xiang.framework.R;
import com.xiang.data.BaseResponse;
import com.xiang.util.MD5Utils;
import com.xiang.util.MySharedPreferencesAccountAndPassword;
import com.xiang.util.RetrofitUtil;


import butterknife.BindView;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends BaseActivity {
    String token;
    @BindView(R.id.registerBTN)
    Button registerBTN;
    @BindView(R.id.accountET)
    EditText accountET;
    @BindView(R.id.passwordET)
    EditText passwordET;

    String account;
    String password;
    String passwordTwo;
    // String mAccount = "sc";
    String mAccount = "AppTest1";
    String mPasswordKey = MD5Utils.getMD5Str("123456");

    @Override
    public int getContentViewId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initViews(Bundle bundle) {
        getAccountAndPassword();
    }

    @OnClick(R.id.registerBTN)
    void click(View v) {
        switch (v.getId()) {
            case R.id.registerBTN:
                login();
                showDialogwithString("正在加载请稍后");
                break;
        }
    }

    private void getAccountAndPassword() {
        SharedPreferences sharedPreferences = getSharedPreferences("key", Context.MODE_PRIVATE);
        String account = sharedPreferences.getString("account", "");
        String password = sharedPreferences.getString("password", "");
        String isfrist = sharedPreferences.getString("isfrist", "");
        if (!isfrist.equals("")) {
            accountET.setText(account);
            passwordET.setText(password);
        }
    }

    private void login() {
        account = accountET.getText().toString().trim();
        passwordTwo = passwordET.getText().toString().trim();
        password = MD5Utils.getMD5Str(passwordTwo);
        if ((account.equals(mAccount)) && (password.equals(mPasswordKey))) {
            Call<UserResponse> call = RetrofitUtil.getHttpService().getUserByLogin(account, password);
            call.enqueue(new Callback<UserResponse>() {
                @Override//请求成功
                public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                    token = response.body().getResult().getJSESSIONID();
                    String role = response.body().getResult().getRole();
                    MySharedPreferencesAccountAndPassword.setMySharedPreferences(LoginActivity.this, account, passwordTwo, token,role);
                    Intent intent = new Intent(LoginActivity.this, ThereActivity.class);
                    int userId = response.body().getResult().getUserId();
                    intent.putExtra("userId", userId);

                    startActivity(intent);


                    startActivity(intent);
                    dissDialog();
                    finish();
                    Toast.makeText(LoginActivity.this, "链接成功", Toast.LENGTH_LONG).show();
                }

                @Override//请求失败
                public void onFailure(Call<UserResponse> call, Throwable t) {
                    Toast.makeText(LoginActivity.this, "链接失败", Toast.LENGTH_LONG).show();
                }
            });
        } else {
            Toast.makeText(LoginActivity.this, "输入有误请重新输入", Toast.LENGTH_LONG).show();
        }
    }
}
