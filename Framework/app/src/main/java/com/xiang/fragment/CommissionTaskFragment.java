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

public class CommissionTaskFragment extends BaseFragment {
    Boolean judge = true;
    String status = "0";
    @BindView(R.id.commissionLV)
    PullToRefreshListView commissionLV;
    int number = 0;
    View view;

    List<Task> alreadyDatas = new ArrayList<>();
    AlreadyTaskAdapter alreadyTaskAdapter;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_task;
    }

    @Override
    protected void initViews(Bundle bundle) {
        view = LayoutInflater.from(getContext()).inflate(R.layout.null_listview, null);
        alreadyTaskAdapter = new AlreadyTaskAdapter(alreadyDatas, getContext());
        commissionLV.setAdapter(alreadyTaskAdapter);
        commissionLV.setMode(PullToRefreshBase.Mode.BOTH);//设置打开方式
        refresh();
        if (judge) {
            getTask();
            judge = false;
        }
        commissionLVclick();
    }

    //下拉 上拉
    private void refresh() {
        commissionLV.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
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
       commissionLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                JumpListItem.jumpListItem(getContext(), position , alreadyDatas);
            }
        });
        
        commissionLV.getRefreshableView().setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(), "长按了" + position, Toast.LENGTH_LONG).show();
                alreadyDatas.remove(alreadyDatas.get(position-1));
                alreadyTaskAdapter.notifyDataSetChanged();
                
                if (alreadyDatas.size()==0){
                    commissionLV.setEmptyView(view);
                }
                return true;
            }
        });
    }

    private void getTask() {
        Call<CommissionData> call = RetrofitUtil.getHttpService().getTaskList(BaseActivity.getToken(context), "1", status, "5", number + "");
        call.enqueue(new Callback<CommissionData>() {
            @Override
            public void onResponse(Call<CommissionData> call, Response<CommissionData> response) {
                commissionLV.onRefreshComplete();
                List<Task> rowsBean = response.body().getResult().getRows();
                if (number == 0) {
                    alreadyDatas.clear();
                    if (rowsBean.size() == 0 || rowsBean.isEmpty()) {
                        commissionLV.setEmptyView(view);
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
                commissionLV.onRefreshComplete();
            }
        });
    }
}
