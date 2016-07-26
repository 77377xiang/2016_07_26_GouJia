package com.xiang.util;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Administrator on 2016/6/20.
 */
public class MyApplication extends Application {
    static Context mcontext;
    @Override
    public void onCreate() {
        super.onCreate();
        //以下只可以选择一个、第一个为系统默认，第二个 是自己定义的

        //ImageUtil.initConfig(getApplicationContext());
        ImageUtil.initConfigdefult(getApplicationContext());
        mcontext = getApplicationContext();
        BaiDuUtil.onCreate(getApplicationContext());
    }
    public static Context getContent() {
        return mcontext;
    }
}
