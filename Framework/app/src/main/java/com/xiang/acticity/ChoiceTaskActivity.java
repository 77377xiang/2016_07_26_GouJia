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

/**
 * Created by Administrator on 2016/7/13.
 */
public class ChoiceTaskActivity extends BaseActivity {
    @BindView(R.id.backIV)
    ImageView backIV;

    @BindView(R.id.allRL)
    RelativeLayout allRL;
    @BindView(R.id.allIV)
    ImageView allIV;

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
        return R.layout.activity_choicetask;
    }

    @Override
    protected void initViews(Bundle bundle) {

    }

    @OnClick({R.id.backIV, R.id.noBeginRL, R.id.underwayRL, R.id.deferredRL, R.id.cancellationRL, R.id.fishRL,R.id.allRL})
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
            case R.id.allRL:
                all();
                reply(5);
                break;

        }
    }

    //回传状态给 ChoiceTaskActivity
    private void reply(int state) {
        Intent intent = new Intent();
        intent.putExtra( "state", state);
        setResult(RESULT_OK, intent);
        finish();
    }

    private void all() {
        allIV.setVisibility(View.VISIBLE);
        noBeginIV.setVisibility(View.GONE);
        underwayIV.setVisibility(View.GONE);
        deferredIV.setVisibility(View.GONE);
        cancellationIV.setVisibility(View.GONE);
        fishIV.setVisibility(View.GONE);
    }
    private void noBegin() {
        allIV.setVisibility(View.GONE);
        noBeginIV.setVisibility(View.VISIBLE);
        underwayIV.setVisibility(View.GONE);
        deferredIV.setVisibility(View.GONE);
        cancellationIV.setVisibility(View.GONE);
        fishIV.setVisibility(View.GONE);
    }

    private void underway() {
        allIV.setVisibility(View.GONE);
        noBeginIV.setVisibility(View.GONE);
        underwayIV.setVisibility(View.VISIBLE);
        deferredIV.setVisibility(View.GONE);
        cancellationIV.setVisibility(View.GONE);
        fishIV.setVisibility(View.GONE);
    }

    private void deferred() {
        allIV.setVisibility(View.GONE);
        noBeginIV.setVisibility(View.GONE);
        underwayIV.setVisibility(View.GONE);
        deferredIV.setVisibility(View.VISIBLE);
        cancellationIV.setVisibility(View.GONE);
        fishIV.setVisibility(View.GONE);
    }

    private void cancellation() {
        allIV.setVisibility(View.GONE);
        noBeginIV.setVisibility(View.GONE);
        underwayIV.setVisibility(View.GONE);
        deferredIV.setVisibility(View.GONE);
        cancellationIV.setVisibility(View.VISIBLE);
        fishIV.setVisibility(View.GONE);
    }

    private void alreadyOver() {
        allIV.setVisibility(View.GONE);
        noBeginIV.setVisibility(View.GONE);
        underwayIV.setVisibility(View.GONE);
        deferredIV.setVisibility(View.GONE);
        cancellationIV.setVisibility(View.GONE);
        fishIV.setVisibility(View.VISIBLE);
    }
}
