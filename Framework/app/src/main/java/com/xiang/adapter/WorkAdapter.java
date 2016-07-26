package com.xiang.adapter;

import android.content.Context;

import com.xiang.data.WorkData;
import com.xiang.data.WorkResult;
import com.xiang.framework.R;

import java.util.List;

/**
 * Created by Administrator on 2016/7/8.
 */
public class WorkAdapter extends CommAdapter<WorkResult> {
    public WorkAdapter(List<WorkResult> t, Context context) {
        super(t, context, R.layout.item_fragment_work_list);
    }
    @Override
    public void convert(ViewHolder holder, WorkResult data) {
        holder.setText(R.id.themeTV, data.getName());
        holder.setText(R.id.siteTV, data.getShopName());
        workStatus(holder,data);
    }
    private void workStatus(ViewHolder holder, WorkResult data){
        switch (data.getProductStatus()){
            case 0:
                holder.setText(R.id.stateTV, "未知");
            break;
            case 1:
                holder.setText(R.id.stateTV, "为开工");
                break;
            case 2:
                holder.setText(R.id.stateTV, "待审核");
                break;
            case 3:
                holder.setText(R.id.stateTV, "审核失败");
                break;
            case 4:
                holder.setText(R.id.stateTV, "施工中");
                break;
            case 5:
                holder.setText(R.id.stateTV, "已完成");
                break;
        }
    }
}
