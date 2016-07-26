package com.xiang.util;

import com.xiang.interfaces.HttpService;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtil {
    static HttpService service = null;

    public static HttpService getHttpService() {
        if (service == null) {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient httpClient = new OkHttpClient.Builder()
                    .addInterceptor(logging)//添加打印拦截器
                    .connectTimeout(30, TimeUnit.SECONDS)//设置请求超时时间
                    .retryOnConnectionFailure(true)//设置出现错误进行重新连接。
                    .build();

            Retrofit retrofit = new Retrofit.Builder().baseUrl(ConstUtil.WEB_URL).client(httpClient).addConverterFactory(GsonConverterFactory.create()).build();
            service=retrofit.create(HttpService.class);
            return service;
        } else {

            return service;
        }

    }
}
