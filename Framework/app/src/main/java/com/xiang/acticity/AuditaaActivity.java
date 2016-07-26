package com.xiang.acticity;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.xiang.adapter.AuditaAdapter;
import com.xiang.base.BaseActivity;
import com.xiang.data.AcceptanceItemListResul;
import com.xiang.data.AuditaData;
import com.xiang.data.BaseResponse;
import com.xiang.data.NodeData;
import com.xiang.framework.R;
import com.xiang.util.RetrofitUtil;
import com.xiang.view.NoScrollGroudView;
import com.xiang.view.NoScrollListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AuditaaActivity extends BaseActivity {
    int nodeId;
    @BindView(R.id.backIV)
    ImageView backIV;

    @BindView(R.id.confirmTV)
    TextView confirmTV;

    @BindView(R.id.auditaGV)
    NoScrollGroudView auditaGV;
    List<AcceptanceItemListResul> acceptanceItemListResuls = new ArrayList<>();
    AuditaAdapter auditaAdapter;

    @Override
    public int getContentViewId() {
        return R.layout.activity_audit;
    }

    @Override
    protected void initViews(Bundle bundle) {
        nodeId = getIntent().getIntExtra("nodeId", 0);
        getNode();
        auditaAdapter = new AuditaAdapter(acceptanceItemListResuls, AuditaaActivity.this);
        auditaGV.setAdapter(auditaAdapter);
    }

    @OnClick({R.id.backIV,R.id.confirmTV})
    void click(View v) {
        switch (v.getId()) {
            case R.id.backIV:
                finish();
                break;
            case R.id.confirmTV:
                Toast.makeText(AuditaaActivity.this,"点击了提交",Toast.LENGTH_LONG).show();
                break;
        }
    }


    private void getNode() {
        Call<AuditaData> call = RetrofitUtil.getHttpService().getNodeDetailList(getToken(AuditaaActivity.this), nodeId + "");
        call.enqueue(new Callback<AuditaData>() {
            @Override
            public void onResponse(Call<AuditaData> call, Response<AuditaData> response) {
                acceptanceItemListResuls.addAll(response.body().getResult().getAcceptanceItemList());
                auditaAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<AuditaData> call, Throwable t) {
            }
        });
    }
}
