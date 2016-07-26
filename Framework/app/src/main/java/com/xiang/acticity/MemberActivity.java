package com.xiang.acticity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.xiang.adapter.MemberAdapter;
import com.xiang.base.BaseActivity;
import com.xiang.data.AllPowerful;
import com.xiang.data.CoreMemberData;
import com.xiang.data.DialogBoxeSend;
import com.xiang.data.MemberData;
import com.xiang.framework.R;
import com.xiang.util.RetrofitUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2016/7/11.
 */
public class MemberActivity extends BaseActivity {
    @BindView(R.id.backIV)
    ImageView backIV;
    @BindView(R.id.otherLV)
    ListView otherLV;
    //   // List<MemberData.ResultBean.RowsBean> members = new ArrayList<>();
    List<CoreMemberData> members;
    MemberAdapter memberAdapter;
    View addHeader;
    TextView waitingTV;
    TextView alreadyTV;
    TextView typeTV;

    @Override
    public int getContentViewId() {
        return R.layout.activity_member;
    }

    @Override
    protected void initViews(Bundle bundle) {
        Intent intent = getIntent();
        members = (List<CoreMemberData>) intent.getSerializableExtra("member");
        memberAdapter = new MemberAdapter(members, MemberActivity.this);
        AddHeader();
        initData();
        otherLV.addHeaderView(addHeader);
        otherLV.setAdapter(memberAdapter);
    }


    private void AddHeader() {
        addHeader = LayoutInflater.from(MemberActivity.this).inflate(R.layout.header_member, null);
        waitingTV = (TextView) addHeader.findViewById(R.id.waitingTV);
        alreadyTV = (TextView) addHeader.findViewById(R.id.alreadyTV);
        typeTV = (TextView) addHeader.findViewById(R.id.typeTV);
        waitingTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                waiting();
            }
        });
        alreadyTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                already();
            }
        });
    }

    private void waiting() {
        waitingTV.setBackgroundColor(0xff877e7e);//深灰
        waitingTV.setTextColor(0xffffffff);
        alreadyTV.setBackgroundColor(0xff969696);//浅灰
        alreadyTV.setTextColor(0xff969696);
    }

    //已办
    private void already() {
        waitingTV.setBackgroundColor(0xff969696);
        waitingTV.setTextColor(0xff969696);
        alreadyTV.setBackgroundColor(0xff40b2cf);
        alreadyTV.setTextColor(0xffffffff);
    }

    private void initData() {
        if ( members.get(0).getType()==0){
            typeTV.setText("参与人");
        }else {
        typeTV.setText("负者人");
        }

        if (members.get(0).getIsHandle() == 1) {
            already();
        }
        if (members.get(0).getIsHandle() == 0) {
            waiting();
        }
        members.remove(0);
    }

}
