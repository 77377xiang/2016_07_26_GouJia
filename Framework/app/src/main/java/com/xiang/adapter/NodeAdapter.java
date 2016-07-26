package com.xiang.adapter;

import android.content.Context;
import android.widget.BaseAdapter;

import com.xiang.data.NodeResul;
import com.xiang.framework.R;

import java.util.List;

/**
 * Created by Administrator on 2016/7/15.
 */
public class NodeAdapter extends CommAdapter<NodeResul> {
    public NodeAdapter(List<NodeResul> t, Context context) {
        super(t, context, R.layout.item_list_node);
    }
    @Override
    public void convert(ViewHolder holder, NodeResul data) {
        holder.setText(R.id.nodeTV,data.getName());
    }

}
