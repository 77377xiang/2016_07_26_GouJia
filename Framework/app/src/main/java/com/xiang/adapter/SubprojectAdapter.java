package com.xiang.adapter;

import android.content.Context;
import android.graphics.Color;

import com.xiang.data.SubprojectData;
import com.xiang.data.Type;
import com.xiang.framework.R;

import java.util.List;

/**
 * Created by Administrator on 2016/7/13.
 */
public class SubprojectAdapter extends CommAdapter<Type>{
    public SubprojectAdapter(List<Type> t, Context context) {
        super(t, context, R.layout.item_senticond__two);
    }
    @Override
    public void convert(ViewHolder holder, Type data) {
        holder.setText(R.id.buttonBTN,data.getName());
    }


}
