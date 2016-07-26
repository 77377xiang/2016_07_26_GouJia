package com.xiang.adapter;

import android.content.Context;

import com.xiang.data.AcceptanceItemListResul;
import com.xiang.framework.R;

import java.util.List;

/**
 * Created by Administrator on 2016/7/15.
 */
public class AuditaAdapter extends CommAdapter<AcceptanceItemListResul> {
    public AuditaAdapter(List<AcceptanceItemListResul> t, Context context) {
        super(t, context, R.layout.item_grid_audita);
    }

    @Override
    public void convert(ViewHolder holder, AcceptanceItemListResul data) {
        holder.setText(R.id.nameTV,data.getName());
    }
}
