package com.xiang.acticity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.xiang.base.BaseActivity;
import com.xiang.framework.R;

public class SplashActivity extends BaseActivity {
    @Override
    public int getContentViewId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initViews(Bundle bundle) {
        initIntent();

    }

    public void initIntent() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2000);
    }
}
