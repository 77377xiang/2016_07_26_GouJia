package com.xiang.acticity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.xiang.base.BaseActivity;
import com.xiang.data.FeedbackResul;
import com.xiang.framework.R;
import com.xiang.util.RetrofitUtil;

import butterknife.BindView;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FeedbackActivity extends BaseActivity {
    String intport;
    @BindView(R.id.backIV)
    ImageView backIV;

    @BindView(R.id.setFeedbackET)
    EditText setFeedbackET;

    @BindView(R.id.proportionTV)
    TextView proportionTV;

    @BindView(R.id.submitTV)
    TextView submitTV;

    @Override
    public int getContentViewId() {
        return R.layout.activity_feedback;
    }

    @Override
    protected void initViews(Bundle bundle) {
        clickSetEdit();
    }

    private void clickSetEdit() {
        setFeedbackET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                proportionTV.setText(s.length() + "/" + "500");
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    @OnClick({R.id.backIV, R.id.proportionTV, R.id.submitTV})
    void click(View v) {
        switch (v.getId()) {
            case R.id.backIV:
                finish();
                break;
            case R.id.submitTV:
                intport = setFeedbackET.getText().toString();
                setFeedback();
                break;
        }
    }

    private void setFeedback() {
        if (!intport.equals("")) {
            Call<FeedbackResul> call = RetrofitUtil.getHttpService().setContent(getToken(FeedbackActivity.this), intport);
            call.enqueue(new Callback<FeedbackResul>() {
                @Override
                public void onResponse(Call<FeedbackResul> call, Response<FeedbackResul> response) {
                    finish();
                }

                @Override
                public void onFailure(Call<FeedbackResul> call, Throwable t) {
                    Toast.makeText(FeedbackActivity.this, "提交失败", Toast.LENGTH_LONG).show();
                }
            });
        }else {
            Toast.makeText(FeedbackActivity.this, "请输入类容", Toast.LENGTH_LONG).show();
        }
    }

}
