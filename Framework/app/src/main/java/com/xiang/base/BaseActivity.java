package com.xiang.base;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.xiang.dialog.RequestDialog;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity extends AppCompatActivity {
    public abstract int getContentViewId();
    private Unbinder unbinder;
    RequestDialog requestDialog;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());
        requestDialog = new RequestDialog(BaseActivity.this);
        unbinder = ButterKnife.bind(this);
        initViews(savedInstanceState);
    }

    protected abstract void initViews(Bundle bundle);
    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    public void showDialog() {
        if (requestDialog != null && !requestDialog.isShowing()) {
            requestDialog.show();
        }
    }

    //显示对话框并显示有字体
    public void showDialogwithString(String string) {
        if (requestDialog != null && !requestDialog.isShowing()) {
            requestDialog.setDialogString(string);
            requestDialog.show();
        }
    }

    // 关闭对话框
    public void dissDialog() {
        if (requestDialog != null && requestDialog.isShowing()) {
            requestDialog.dismiss();
        }
    }
    public static String getToken(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("key", Context.MODE_PRIVATE);
        return "JSESSIONID="+sharedPreferences.getString("token", "");
    }
}
