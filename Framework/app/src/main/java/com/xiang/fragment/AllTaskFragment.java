package com.xiang.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.xiang.adapter.AlreadyTaskAdapter;
import com.xiang.base.BaseActivity;
import com.xiang.base.BaseFragment;
import com.xiang.data.CommissionData;
import com.xiang.data.Task;
import com.xiang.framework.R;
import com.xiang.util.JumpListItem;
import com.xiang.util.RetrofitUtil;
import com.xiang.wechat.listviewpull.PullToRefreshBase;
import com.xiang.wechat.listviewpull.PullToRefreshListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AllTaskFragment extends BaseFragment {
    @BindView(R.id.allLV)
    PullToRefreshListView allLV;
    Boolean judge = true;
    String status = "2";
    int number = 0;
    View view;

    List<Task> alreadyDatas = new ArrayList<>();
    AlreadyTaskAdapter alreadyTaskAdapter;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_yaskbar_all;
    }

    @Override
    protected void initViews(Bundle bundle) {
        view = LayoutInflater.from(getContext()).inflate(R.layout.null_listview, null);
        alreadyTaskAdapter = new AlreadyTaskAdapter(alreadyDatas, getContext());
        allLV.setAdapter(alreadyTaskAdapter);
        refresh();
        if (judge) {
            getTask();
            judge = false;
        }
        commissionLVclick();
    }

    private void refresh() {
        allLV.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                number = 0;
                getTask();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {

                number = number + 5;
                getTask();
            }
        });
    }

    private void commissionLVclick() {
        allLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                JumpListItem.jumpListItem(getContext(), position, alreadyDatas);
            }
        });
        allLV.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(), "长按了" + position, Toast.LENGTH_LONG).show();
                alreadyDatas.remove(alreadyDatas.get(position));
                alreadyTaskAdapter.notifyDataSetChanged();
                return true;
            }
        });
    }

    private void getTask() {
        Call<CommissionData> call = RetrofitUtil.getHttpService().getTaskList(BaseActivity.getToken(context), "1", status, "5", number + "");
        call.enqueue(new Callback<CommissionData>() {
            @Override
            public void onResponse(Call<CommissionData> call, Response<CommissionData> response) {
                allLV.onRefreshComplete();
                List<Task> rowsBean = response.body().getResult().getRows();
                if (number == 0) {
                    alreadyDatas.clear();
                    if (rowsBean.size() == 0 || rowsBean.isEmpty()) {
                        allLV.setEmptyView(view);
                    } else {
                        alreadyDatas.addAll(rowsBean);
                        alreadyTaskAdapter.notifyDataSetChanged();
                    }
                } else {
                    if (rowsBean.size() == 0 || rowsBean.isEmpty()) {
                        Toast.makeText(getContext(), "没有更多数据了", Toast.LENGTH_SHORT).show();
                    } else {
                        alreadyDatas.addAll(rowsBean);
                        alreadyTaskAdapter.notifyDataSetChanged();
                    }
                }
            }

            @Override
            public void onFailure(Call<CommissionData> call, Throwable t) {
                allLV.onRefreshComplete();
            }
        });
    }

//    private void getTask() {
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
//                RetrofitTask. initlistData(response, alreadyDatas, alreadyTaskAdapter);
//            }
//
//            @Override
//            public void onFailure(Call<CommissionData> call, Throwable t) {
//            }
//        });
//    }

}
