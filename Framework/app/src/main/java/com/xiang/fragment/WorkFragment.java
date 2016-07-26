package com.xiang.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.xiang.acticity.NodeActivity;
import com.xiang.adapter.WorkAdapter;
import com.xiang.base.BaseActivity;
import com.xiang.base.BaseFragment;
import com.xiang.data.WorkData;
import com.xiang.data.WorkResult;
import com.xiang.framework.R;
import com.xiang.util.RetrofitUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WorkFragment extends BaseFragment {
    int userId;
    List<WorkResult> myWorkDatas;
    @BindView(R.id.workLV)
    ListView workLV;
    @BindView(R.id.hintIV)
    ImageView hintIV;
    List<WorkResult> workDatas = new ArrayList<>();
    WorkAdapter workAdapter;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_work;
    }

    @Override
    protected void initViews(Bundle bundle) {
        userId = getActivity().getIntent().getIntExtra("userId", 0);
        getWork();
        workAdapter = new WorkAdapter(workDatas, getContext());
        workLV.setAdapter(workAdapter);
        clickList();
    }

    private void clickList() {
        workLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                clickIntent( position);
            }
        });
    }

    private void clickIntent(int position) {
        int productId = myWorkDatas.get(position).getProductStatus();
        switch (productId) {
            case 0:
                Toast.makeText(getContext(), "未知不可以进入", Toast.LENGTH_LONG).show();
                break;
            case 1:
                Toast.makeText(getContext(), "为开工不可以进入", Toast.LENGTH_LONG).show();
                break;
            case 2:
                IntentNodeActivity(position);
                break;
            case 3:
                IntentNodeActivity(position);
            break;
            case 4:
                IntentNodeActivity(position);
                break;
            case 5:
                IntentNodeActivity(position);
                break;
        }
    }

    private void IntentNodeActivity(int position){
        Intent intent = new Intent(getContext(), NodeActivity.class);
        int productId = myWorkDatas.get(position).getProductId();
        intent.putExtra("productId", productId);
        startActivity(intent);
        Toast.makeText(getContext(), "点击了" + position, Toast.LENGTH_LONG).show();
    }

    @OnClick({R.id.hintIV})
    void click(View v) {
        switch (v.getId()) {
            case R.id.hintIV:
                Toast.makeText(getContext(), "点击了消息提示", Toast.LENGTH_LONG).show();
                break;
        }
    }

    private void getWork() {
        Call<WorkData> call = RetrofitUtil.getHttpService().getWork(BaseActivity.getToken(context), userId + "", "10", 0 + "");
        call.enqueue(new Callback<WorkData>() {
            @Override
            public void onResponse(Call<WorkData> call, Response<WorkData> response) {
                myWorkDatas = response.body().getResult();
                workDatas.addAll(myWorkDatas);
                workAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<WorkData> call, Throwable t) {
            }
        });
    }
}
