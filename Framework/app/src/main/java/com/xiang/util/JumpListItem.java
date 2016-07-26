package com.xiang.util;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.xiang.acticity.TaskDetailsActivity;
import com.xiang.data.Task;

import java.util.List;
public class JumpListItem {
    public static void jumpListItem(Context context,int position,List<Task> alreadyDatas ){
        Intent intent = new Intent(context, TaskDetailsActivity.class);
        Task information = alreadyDatas.get(position-1);
        Bundle bundle = new Bundle();
        bundle.putSerializable("key",information);
        intent.putExtras(bundle);
        context. startActivity(intent);
    }
}
