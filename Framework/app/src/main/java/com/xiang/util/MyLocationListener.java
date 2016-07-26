package com.xiang.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;

/**
 * Created by Administrator on 2016/7/17.
 */
public class MyLocationListener implements BDLocationListener {
    private String nowPosition;

    @Override
    public void onReceiveLocation(BDLocation location) {
        com.baidu.location.Address address = location.getAddress();
        nowPosition = address.city.toString();
        SharedPreferences sharedPreferences = MyApplication.getContent().getSharedPreferences("nowPosition", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("nowPosition",nowPosition);
        editor.commit();
        Log.i("sss",nowPosition);
    }
}
