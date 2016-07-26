package com.xiang.acticity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.xiang.base.BaseActivity;
import com.xiang.framework.R;

import butterknife.BindView;
import butterknife.OnClick;
public class ModificationActivity extends BaseActivity {
    @BindView(R.id.backIV)
    ImageView backIV;
    @BindView(R.id.noBeginRL)
    RelativeLayout noBeginRL;
    @BindView(R.id.noBeginIV)
    ImageView noBeginIV;

    @BindView(R.id.underwayRL)
    RelativeLayout underwayRL;
    @BindView(R.id.underwayIV)
    ImageView underwayIV;

    @BindView(R.id.deferredRL)
    RelativeLayout deferredRL;
    @BindView(R.id.deferredIV)
    ImageView deferredIV;

    @BindView(R.id.cancellationRL)
    RelativeLayout cancellationRL;
    @BindView(R.id.cancellationIV)
    ImageView cancellationIV;

    @BindView(R.id.fishRL)
    RelativeLayout fishRL;
    @BindView(R.id.fishIV)
    ImageView fishIV;

    @Override
    public int getContentViewId() {
        return R.layout.activity_modification;
    }

    @Override
    protected void initViews(Bundle bundle) {
        initGetTaskStatus();
    }
    @OnClick({R.id.backIV, R.id.noBeginRL, R.id.underwayRL, R.id.deferredRL, R.id.cancellationRL, R.id.fishRL})
    void clivk(View v) {
        switch (v.getId()) {
            case R.id.backIV:
                finish();
                break;
            case R.id.noBeginRL:
                noBegin();
                reply(0);
                break;
            case R.id.underwayRL:
                underway();
                reply(1);
                break;
            case R.id.deferredRL:
                deferred();
                reply(2);
                break;
            case R.id.cancellationRL:
                cancellation();
                reply(3);
                break;
            case R.id.fishRL:
                alreadyOver();
                reply(4);
                break;
        }
    }
    private void initGetTaskStatus(){
     int  TaskStatus=  getIntent().getIntExtra("TaskStatus",0);
        switch (TaskStatus) {
            case 0:
                noBegin();
                break;
            case 1:
                underway();
                break;
            case 2:
                deferred();
                break;
            case 3:
                cancellation();
                break;
            case 4:
                alreadyOver();
                break;
        }
    }

    //回传数据个TaskDetailsActivity
    private void reply(int number) {
        Intent intent = new Intent();
        intent.putExtra( "number", number);
        setResult(RESULT_OK, intent);
        finish();
    }

    private void noBegin() {
        noBeginIV.setVisibility(View.GONE);
        underwayIV.setVisibility(View.VISIBLE);
        deferredIV.setVisibility(View.GONE);
        cancellationIV.setVisibility(View.GONE);
        fishIV.setVisibility(View.GONE);
    }

    private void underway() {
        noBeginIV.setVisibility(View.GONE);
        underwayIV.setVisibility(View.VISIBLE);
        deferredIV.setVisibility(View.GONE);
        cancellationIV.setVisibility(View.GONE);
        fishIV.setVisibility(View.GONE);
    }

    private void deferred() {
        noBeginIV.setVisibility(View.GONE);
        underwayIV.setVisibility(View.GONE);
        deferredIV.setVisibility(View.VISIBLE);
        cancellationIV.setVisibility(View.GONE);
        fishIV.setVisibility(View.GONE);
    }

    private void cancellation() {
        noBeginIV.setVisibility(View.GONE);
        underwayIV.setVisibility(View.GONE);
        deferredIV.setVisibility(View.GONE);
        cancellationIV.setVisibility(View.VISIBLE);
        fishIV.setVisibility(View.GONE);
    }

    private void alreadyOver() {
        noBeginIV.setVisibility(View.GONE);
        underwayIV.setVisibility(View.GONE);
        deferredIV.setVisibility(View.GONE);
        cancellationIV.setVisibility(View.GONE);
        fishIV.setVisibility(View.VISIBLE);
    }
}
