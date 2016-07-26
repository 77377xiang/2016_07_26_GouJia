package com.xiang.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.xiang.data.DepartmentListOneData;
import com.xiang.data.SectionData;
import com.xiang.framework.R;
import com.xiang.view.NoScrollGroudView;

import java.util.List;

public class ResumeSelectionAdapter extends CommAdapter<DepartmentListOneData> {
    int typeId = 0;
    int mPosition = 0;

    public ResumeSelectionAdapter(List<DepartmentListOneData> t, Context context) {
        super(t, context, R.layout.item_list_sectiond);
    }

    @Override
    public void convert(final ViewHolder holder, final DepartmentListOneData data) {
        holder.setText(R.id.nickName, data.getName());
        final NoScrollGroudView noGroudView = holder.getView(R.id.noGridView);
        mPosition = holder.getPostion();
        final TwoSubprojectAdapter twoSubprojectAdapter = new TwoSubprojectAdapter(holder.getContext(), data.getChildren());
        noGroudView.setAdapter(twoSubprojectAdapter);
        noGroudView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                typeId = data.getChildren().get(position).getId();
                twoSubprojectAdapter.clearSelection(typeId);
                //    notifyDataSetChanged();
            }
        });

    }
}
