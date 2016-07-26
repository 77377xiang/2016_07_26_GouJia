package com.xiang.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.xiang.data.Type;
import com.xiang.framework.R;

import java.util.List;

public class TwoSubprojectAdapter extends BaseAdapter {
    List<Type> types;
    Context context;
    private int typeId = 0;

    public TwoSubprojectAdapter(Context context, List<Type> types) {
        this.context = context;
        this.types = types;
    }

    @Override

    public int getCount() {
        return types.size();
    }

    @Override
    public Object getItem(int position) {
        return types.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        holderTwo holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_senticond__two, null);
            holder = new holderTwo();
            holder.buttonBTN = (TextView) convertView.findViewById(R.id.buttonBTN);
            convertView.setTag(holder);
        } else {
            holder = (holderTwo) convertView.getTag();
        }
        Type name = types.get(position);
        holder.buttonBTN.setText(name.getName());
        if (typeId == name.getId()) {
            holder.buttonBTN.setBackgroundResource(R.drawable.item_button);
        } else {
            holder.buttonBTN.setBackgroundResource(R.drawable.register_button);
        }
        return convertView;
    }

    class holderTwo {
        TextView buttonBTN;
    }

    public void clearSelection(int typeId) {
        this.typeId = typeId;
        notifyDataSetChanged();
    }
}
