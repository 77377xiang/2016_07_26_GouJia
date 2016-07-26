package com.xiang.acticity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.xiang.base.BaseActivity;
import com.xiang.data.CommissionData;
import com.xiang.data.CoreSeekData;
import com.xiang.data.SeekData;
import com.xiang.framework.R;
import com.xiang.util.RetrofitUtil;

import butterknife.BindView;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SeekActivity extends BaseActivity {
    @BindView(R.id.seekET)
    EditText seekET;

    @BindView(R.id.taskbarTV)
    TextView taskbarTV;


    @Override
    public int getContentViewId() {
        return R.layout.activity_seek;
    }

    @Override
    protected void initViews(Bundle bundle) {
    }

    @OnClick({R.id.taskbarTV})
    void click(View v) {
        switch (v.getId()) {
            case R.id.taskbarTV:
                initNO();
                showDialogwithString("正在加载");
                break;
        }
    }

    private void initNO() {
        if (seekET.getText().toString().length() != 0) {
            getSeek();
        } else {
            Toast.makeText(SeekActivity.this, "收索为空", Toast.LENGTH_LONG).show();
            dissDialog();
        }
    }

    private void getSeek() {
        Call<SeekData> call = RetrofitUtil.getHttpService().setSeek(getToken(SeekActivity.this), seekET.getText().toString());
        call.enqueue(new Callback<SeekData>() {
            @Override
            public void onResponse(Call<SeekData> call, Response<SeekData> response) {
                if (response.body().getResult() == null) {
                    Toast.makeText(SeekActivity.this, "收索为空", Toast.LENGTH_LONG).show();
                    dissDialog();
                } else {
                    Toast.makeText(SeekActivity.this, response.body().getResult().getIsDeal() + "", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(SeekActivity.this, TaskDetailsActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("seek", response.body().getResult());
                    intent.putExtras(bundle);
                    startActivity(intent);
                    dissDialog();
                }
            }

            @Override
            public void onFailure(Call<SeekData> call, Throwable t) {
                dissDialog();
                Toast.makeText(SeekActivity.this, "链接失败", Toast.LENGTH_LONG).show();
            }
        });
    }

}
