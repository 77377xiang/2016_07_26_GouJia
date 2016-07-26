package com.xiang.adapter;

import android.content.Context;

import com.xiang.data.CoreMemberData;
import com.xiang.data.MemberData;
import com.xiang.framework.R;

import java.util.List;

/**
 * Created by Administrator on 2016/7/11.
 */
public class MemberAdapter extends CommAdapter<CoreMemberData> {
    public MemberAdapter(List<CoreMemberData> t, Context context) {
        super(t, context, R.layout.item_member);
    }

    @Override
    public void convert(ViewHolder holder, CoreMemberData data) {

        if (data.getType() == 0) {
            holder.setText(R.id.typeTV, "参与人");
        }
        if (data.getType() == 1) {
            holder.setText(R.id.typeTV, "负者人");
        }
        holder.setText(R.id.nieckNameTV, data.getUserName());
        int a = data.getIsHandle();
        if (data.getIsHandle() == 0) {
            holder.setText(R.id.isHandleTV, "任务代办");
        } else {
            holder.setText(R.id.isHandleTV,  "任务代办");
        }
    }
}
