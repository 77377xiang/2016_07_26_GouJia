package com.xiang.acticity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xiang.adapter.ThereAdapter;
import com.xiang.base.BaseActivity;
import com.xiang.fragment.MyFragment;
import com.xiang.fragment.TaskbarFragment;
import com.xiang.fragment.WorkFragment;
import com.xiang.framework.R;
import com.xiang.view.NoScrollViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/7/7.
 */
public class ThereActivity extends BaseActivity {
    @BindView(R.id.iv1)
    ImageView iv1;
    @BindView(R.id.iv2)
    ImageView iv2;
    @BindView(R.id.iv3)
    ImageView iv3;
    @BindView(R.id.tv1)
    TextView tv1;
    @BindView(R.id.tv2)
    TextView tv2;
    @BindView(R.id.tv3)
    TextView tv3;
    @BindView(R.id.taskLL)
    LinearLayout taskLL;
    @BindView(R.id.workLL)
    LinearLayout workLL;
    @BindView(R.id.myLL)
    LinearLayout myLL;
    NoScrollViewPager therePager;
    private List<Fragment> fragments = new ArrayList<>();
    ThereAdapter adapter;
    @Override
    public int getContentViewId() {
        return R.layout.activit_there;
    }

    @Override
    protected void initViews(Bundle bundle) {
        therePager = (NoScrollViewPager) findViewById(R.id.therePager);
        fragments.add(new TaskbarFragment());
        fragments.add(new WorkFragment());
        fragments.add(new MyFragment());
        adapter = new ThereAdapter(getSupportFragmentManager(), fragments);
        therePager.setAdapter(adapter);
        therePager.setOffscreenPageLimit(3);
        defaultChecked();
    }

    private void defaultChecked() {
        therePager.setCurrentItem(0);
        iv1.setImageResource(R.drawable.common_ic_googleplayservices);
        iv2.setImageResource(R.drawable.camera);
        iv3.setImageResource(R.drawable.camera);
        tv1.setTextColor(0xff11cd6e);
        tv2.setTextColor(0xffffffff);
        tv3.setTextColor(0xffffffff);
    }

    @OnClick({R.id.taskLL, R.id.workLL, R.id.myLL})
    void click(View v) {
        switch (v.getId()) {
            case R.id.taskLL:
                therePager.setCurrentItem(0);
                iv1.setImageResource(R.drawable.common_ic_googleplayservices);
                iv2.setImageResource(R.drawable.camera);
                iv3.setImageResource(R.drawable.camera);
                tv1.setTextColor(0xff11cd6e);
                tv2.setTextColor(0xffffffff);
                tv3.setTextColor(0xffffffff);
                break;
            case R.id.workLL:
                therePager.setCurrentItem(1);
                iv1.setImageResource(R.drawable.camera);
                iv2.setImageResource(R.drawable.common_ic_googleplayservices);
                iv3.setImageResource(R.drawable.camera);
                tv1.setTextColor(0xffffffff);
                tv2.setTextColor(0xff11cd6e);
                tv3.setTextColor(0xffffffff);
                break;
            case R.id.myLL:
                therePager.setCurrentItem(2);
                iv1.setImageResource(R.drawable.camera);
                iv2.setImageResource(R.drawable.camera);
                iv3.setImageResource(R.drawable.common_ic_googleplayservices);
                tv1.setTextColor(0xffffffff);
                tv2.setTextColor(0xffffffff);
                tv3.setTextColor(0xff11cd6e);
                break;
            default:
                break;

        }
    }

}


