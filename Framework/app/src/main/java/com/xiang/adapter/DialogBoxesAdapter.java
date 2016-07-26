package com.xiang.adapter;

import android.content.Context;

import com.xiang.data.DialogBoxeSendData;
import com.xiang.data.GetDialogBoxes;
import com.xiang.data.GetDialogBoxesDate;
import com.xiang.framework.R;
import com.xiang.util.RetrofitTask;

import java.util.List;

/**
 * Created by Administrator on 2016/7/11.
 */
public class DialogBoxesAdapter extends CommAdapter<GetDialogBoxesDate>{
    public DialogBoxesAdapter(List<GetDialogBoxesDate> t, Context context) {
        super(t, context, R.layout.item_dialogboxes);
    }

    @Override
    public void convert(ViewHolder holder,GetDialogBoxesDate data) {
        holder.setText(R.id.nameTV,data.getCommitUser());
        holder.setText(R.id.textDescriptionTV,data.getContent());
        holder.setText(R.id.timeTV, RetrofitTask. getTime(data.getGmtCreate()));

    }
}
