package com.xiang.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.xiang.acticity.FeedbackActivity;
import com.xiang.acticity.LoginActivity;
import com.xiang.base.BaseActivity;
import com.xiang.base.BaseFragment;
import com.xiang.data.BaseResponse;
import com.xiang.data.CommissionData;
import com.xiang.data.Task;
import com.xiang.data.vupResule;
import com.xiang.framework.R;
import com.xiang.util.RetrofitUtil;
import com.xiang.wechat.listviewpull.LoadingLayout;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyFragment extends BaseFragment {
    String role;
    String account;
    @BindView(R.id.nickNameTV)
    TextView nickNameTV;
    @BindView(R.id.describeTV)
    TextView describeTV;

    @BindView(R.id.feedbackLL)
    LinearLayout feedbackLL;
    @BindView(R.id.whereofLL)
    LinearLayout whereofLL;
    @BindView(R.id.VUPLL)
    LinearLayout VUPLL;
    @BindView(R.id.outTV)
    TextView outTV;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_my;
    }

    @Override
    protected void initViews(Bundle bundle) {
        getResume();
        setResume();
    }

    @OnClick({R.id.feedbackLL, R.id.whereofLL, R.id.VUPLL, R.id.outTV})
    void click(View v) {
        switch (v.getId()) {
            case R.id.feedbackLL:
                Intent intent = new Intent(getContext(), FeedbackActivity.class);
                startActivity(intent);
                break;
            case R.id.whereofLL:
//关于
                break;
            case R.id.VUPLL:
                getVUP();
                break;
            case R.id.outTV:
                exitParams();
                Intent intentOen = new Intent(getContext(), LoginActivity.class);
                startActivity(intentOen);
                getActivity().finish();
                break;
        }
    }

    private void getResume() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("key", Context.MODE_PRIVATE);
        role = sharedPreferences.getString("role", "");
        account = sharedPreferences.getString("account", "");
    }

    private void setResume() {
        nickNameTV.setText(account);
        describeTV.setText(role);
    }

    private void getVUP() {
        Call<vupResule> call = RetrofitUtil.getHttpService().getVUP(BaseActivity.getToken(context), "1", "1");
        call.enqueue(new Callback<vupResule>() {
            @Override
            public void onResponse(Call<vupResule> call, Response<vupResule> response) {
                //  if (response.body().getResult().getUpdateContent().equals())
                Toast.makeText(getContext(), "已经是最新版本", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onFailure(Call<vupResule> call, Throwable t) {
            }
        });
    }

    private void exitParams() {
        Call<BaseResponse> call = RetrofitUtil.getHttpService().exitParams(BaseActivity.getToken(context));
        call.enqueue(new Callback<BaseResponse>() {
            @Override
            public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
                Toast.makeText(getContext(), "您已经退出程序", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<BaseResponse> call, Throwable t) {
            }
        });

    }
}

