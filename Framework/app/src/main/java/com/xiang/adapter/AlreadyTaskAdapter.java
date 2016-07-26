package com.xiang.adapter;

import android.content.Context;

import com.xiang.data.CommissionData;
import com.xiang.data.Task;
import com.xiang.framework.R;
import com.xiang.util.RetrofitTask;

import java.util.List;

/**
 * Created by Administrator on 2016/7/7.
 */
public class AlreadyTaskAdapter extends CommAdapter<Task> {
    public AlreadyTaskAdapter(List<Task> t, Context context) {
        super(t, context, R.layout.item_alreadytask);
    }

    @Override
    public void convert(ViewHolder holder, Task data) {
        holder.setText(R.id.textTV, data.getContent());
        holder.setText(R.id.idTV, (data.getId()) + "");
        holder.setText(R.id.nameTV, data.getUserName() + ":" + data.getChatContent());
        holder.setText(R.id.timeTV, RetrofitTask.getTime(data.getLatestTime()));
    }

}
