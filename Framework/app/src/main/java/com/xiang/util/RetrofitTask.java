package com.xiang.util;

import com.xiang.adapter.AlreadyTaskAdapter;
import com.xiang.data.CommissionData;
import com.xiang.data.Task;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import retrofit2.Response;

public class RetrofitTask {

    //请求网络或的任务 状态
//    public static void getTask(String status, Context context, final List<CommissionData.ResultBean.RowsBean> alreadyDatas, final AlreadyTaskAdapter alreadyTaskAdapter) {
//        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
//        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
//        OkHttpClient httpClient = new OkHttpClient.Builder()
//                .addInterceptor(logging)//添加打印拦截器
//                .connectTimeout(30, TimeUnit.SECONDS)//设置请求超时时间
//                .retryOnConnectionFailure(true)//设置出现错误进行重新连接。
//                .build();
//        Retrofit retrofit = new Retrofit.Builder().baseUrl(ConstUtil.WEB_URL).client(httpClient).addConverterFactory(GsonConverterFactory.create()).build();
//        HttpService httpService = retrofit.create(HttpService.class);
//        Call<CommissionData> call = httpService.getTaskList(BaseActivity.getToken(context), "1", status, "5", "0");
//        call.enqueue(new Callback<CommissionData>() {
//            @Override
//            public void onResponse(Call<CommissionData> call, Response<CommissionData> response) {
//                initlistData(response, alreadyDatas, alreadyTaskAdapter);
//            }
//
//            @Override
//            public void onFailure(Call<CommissionData> call, Throwable t) {
//            }
//        });
//    }

    //  状态数据源
    public static void initlistData(Response<CommissionData> response, List<Task> alreadyDatas, AlreadyTaskAdapter alreadyTaskAdapter) {
    }

    //毫秒转换为时间日期格式
    public static String getTime(long time) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d1 = new Date(time);
        return format.format(d1);

    }

    public static String getNoTime(long time) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd ");
        Date d1 = new Date(time);
        return format.format(d1);

    }
}
