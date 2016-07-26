package com.xiang.util;

import android.content.Context;
import android.content.SharedPreferences;

public class MySharedPreferencesAccountAndPassword {
    public static void setMySharedPreferences(Context context,String account,String passwordTwo,String  token,String role) {
        SharedPreferences sharedPreferences =context.getSharedPreferences("key", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("account", account);
        editor.putString("password", passwordTwo);
        editor.putString("isfrist", "isfrist");
        editor.putString("token", token);
        editor.putString("role",role);
        editor.commit();
    }

}
