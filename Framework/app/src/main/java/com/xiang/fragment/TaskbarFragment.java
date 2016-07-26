package com.xiang.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xiang.acticity.ResumeSelectionActivity;
import com.xiang.acticity.SeekActivity;
import com.xiang.adapter.TaskbartAdapter;
import com.xiang.base.BaseFragment;
import com.xiang.framework.R;
import com.xiang.util.BaiDuUtil;
import com.xiang.util.MyLocationListener;
import com.xiang.view.NoScrollViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class TaskbarFragment extends BaseFragment {
    @BindView(R.id.commissionLL)
    LinearLayout commissionLL;
    @BindView(R.id.alreadyLL)
    LinearLayout alreadyLL;
    @BindView(R.id.allLL)
    LinearLayout allLL;

    @BindView(R.id.commissionTV)
    TextView commissionTV;
    @BindView(R.id.alreadyTV)
    TextView alreadyTV;
    @BindView(R.id.allTV)
    TextView allTV;
    @BindView(R.id.nowTV)
    TextView nowTV;

    @BindView(R.id.commissionTwoTV)
    TextView commissionTwoTV;
    @BindView(R.id.alreadyTwoTV)
    TextView alreadyTwoTV;
    @BindView(R.id.allTwoTV)
    TextView allTwoTV;
    @BindView(R.id.seekIV)
    ImageView seekIV;
    @BindView(R.id.taskbarIV)
    ImageView taskbarIV;

    @BindView(R.id.twoPager)
    NoScrollViewPager twoPager;
    private List<Fragment> twoFragments = new ArrayList<>();
    TaskbartAdapter twoAdapter;
    @Override
    public int getContentViewId() {
        return R.layout.fragment_taskbar;
    }

    @Override
    protected void initViews(Bundle bundle) {
        SharedPreferences nowPosition = getContext().getSharedPreferences("nowPosition", Context.MODE_PRIVATE);
        String nowPositions = nowPosition.getString("nowPosition", "");
        nowTV.setText(nowPositions);

        TwoPager();
    }
   private void TwoPager(){
       twoFragments.add(new CommissionTaskFragment());
       twoFragments.add(new AlreadyTaskFragment());
       twoFragments.add(new AllTaskFragment());
       twoAdapter= new TaskbartAdapter(getChildFragmentManager(),twoFragments);
       twoPager.setOffscreenPageLimit(3);
       twoPager.setAdapter(twoAdapter);
   }

    @OnClick({R.id.commissionLL, R.id.alreadyLL, R.id.allLL,R.id.seekIV,R.id.taskbarIV})
    void click(View v) {
        switch (v.getId()) {
            case R.id.commissionLL:
                twoPager.setCurrentItem(0);
                commissionTwoTV.setBackgroundColor(0xffff8400);
                alreadyTwoTV.setBackgroundColor(0xffffffff);
                allTwoTV.setBackgroundColor(0xffffffff);
                commissionTV.setTextColor(0xffff8400);
                alreadyTV.setTextColor(0xff000000);
                allTV.setTextColor(0xff000000);
                break;
            case R.id.alreadyLL:
                twoPager.setCurrentItem(1);
                commissionTwoTV.setBackgroundColor(0xffffffff);
                alreadyTwoTV.setBackgroundColor(0xffff8400);
                allTwoTV.setBackgroundColor(0xffffffff);
                commissionTV.setTextColor(0xff000000);
                alreadyTV.setTextColor(0xffff8400);
                allTV.setTextColor(0xff000000);
                break;
            case R.id.allLL:
                twoPager.setCurrentItem(2);
                commissionTwoTV.setBackgroundColor(0xffffffff);
                alreadyTwoTV.setBackgroundColor(0xffffffff);
                allTwoTV.setBackgroundColor(0xffff8400);
                commissionTV.setTextColor(0xff000000);
                alreadyTV.setTextColor(0xff000000);
                allTV.setTextColor(0xffff8400);
                break;
            case  R.id.seekIV :
                Intent intentSeek =new Intent(getContext(), SeekActivity.class);
                startActivity(intentSeek);
                //收索
            break;
            case R.id.taskbarIV :
                Intent intentResumeSelection =new Intent(getContext(), ResumeSelectionActivity.class);
                startActivity(intentResumeSelection);
                //任务详情况
            break;
            default:
                break;


        }
    }
}
