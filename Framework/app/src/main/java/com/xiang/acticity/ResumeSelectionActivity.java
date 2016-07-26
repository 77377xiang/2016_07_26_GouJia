package com.xiang.acticity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xiang.adapter.ResumeSelectionAdapter;
import com.xiang.base.BaseActivity;
import com.xiang.data.AllPowerful;
import com.xiang.data.BaseResponse;
import com.xiang.data.DepartmentListOneData;
import com.xiang.data.DialogBoxeSend;
import com.xiang.data.SectionData;
import com.xiang.data.SubprojectData;
import com.xiang.data.Type;
import com.xiang.framework.R;
import com.xiang.util.RetrofitUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ResumeSelectionActivity extends BaseActivity {
    int taskStatus;
    @BindView(R.id.allTV)
    TextView allTV;
    @BindView(R.id.backIV)
    ImageView backIV;
    @BindView(R.id.pitchOnRL)
    RelativeLayout pitchOnRL;
    @BindView(R.id.confirmTV)
    TextView confirmTV;

    @BindView(R.id.sectionLV)
    ListView sectionLV;
    List<DepartmentListOneData> sectionDatas = new ArrayList<>();
    ResumeSelectionAdapter adapter;

    @Override
    public int getContentViewId() {
        return R.layout.activity_resumeselection;
    }

    @Override
    protected void initViews(Bundle bundle) {
        getType();
        select();
      // sectionLV.setItemsCanFocus(true);
        adapter = new ResumeSelectionAdapter(sectionDatas, ResumeSelectionActivity.this);
        sectionLV.setAdapter(adapter);
    }

    @OnClick({R.id.backIV, R.id.pitchOnRL, R.id.confirmTV})
    void click(View v) {
        switch (v.getId()) {
            case R.id.backIV:
                finish();

                break;
            case R.id.pitchOnRL:
                //点击后页面跳转，有回传状态
                Intent intent = new Intent(ResumeSelectionActivity.this, ChoiceTaskActivity.class);
                startActivityForResult(intent, 1);
                break;
            case R.id.confirmTV:
                finish();

                //点击确定后  页面关闭
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            taskStatus = data.getIntExtra("state", 5);
            showState();
            select();
        }
    }

    private void showState() {
        switch (taskStatus) {
            case 0 :
                allTV.setText("未开始");
                break;
            case 1 :
                allTV.setText("进行中");
                break;
            case 2 :
                allTV.setText("已延期");

                break;
            case 3 :
                allTV.setText("已取消");
                break;
            case 4 :
                allTV.setText("已完成");
                break;
            case 5 :
                allTV.setText("全部");
                break;
        }
    }
    //任务筛选
    private void select() {
        Call<BaseResponse> call = RetrofitUtil.getHttpService().getSelect(getToken(ResumeSelectionActivity.this), "1", "1", "3", "5", taskStatus+"", "0");
        call.enqueue(new Callback<BaseResponse>() {
            @Override
            public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {

            }

            @Override
            public void onFailure(Call<BaseResponse> call, Throwable t) {
            }
        });
    }
//任务类型
    private void getType() {
        Call<AllPowerful> call = RetrofitUtil.getHttpService().getType(getToken(ResumeSelectionActivity.this), "1");
        call.enqueue(new Callback<AllPowerful>() {
            @Override
            public void onResponse(Call<AllPowerful> call, Response<AllPowerful> response) {
                sectionDatas.addAll(response.body().getResult());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<AllPowerful> call, Throwable t) {
            }
        });
    }
}
