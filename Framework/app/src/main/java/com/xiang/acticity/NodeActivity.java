package com.xiang.acticity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.xiang.adapter.NodeAdapter;
import com.xiang.base.BaseActivity;
import com.xiang.data.NodeData;
import com.xiang.data.NodeResul;
import com.xiang.framework.R;
import com.xiang.util.RetrofitUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NodeActivity extends BaseActivity {
    int productId;
    String add;
    String foots;
    @BindView(R.id.backIV)
    ImageView backIV;
    @BindView(R.id.nodeLV)
    ListView nodeLV;
    List<NodeResul> nodeResuls = new ArrayList<>();
    NodeAdapter nodeAdapter;
    View header;
    View foot;
    TextView headerTV;
    TextView footTV;
    @Override

    public int getContentViewId() {
        return R.layout.activity_node;
    }

    @Override
    protected void initViews(Bundle bundle) {
        productId = getIntent().getIntExtra("productId", 0);
        getNode();
        header();
        foot();
        nodeLV.addHeaderView(header);
        nodeAdapter = new NodeAdapter(nodeResuls, NodeActivity.this);
        nodeLV.addFooterView(foot);
        nodeLV.setAdapter(nodeAdapter);
        initClivkList();
    }

    @OnClick({R.id.backIV})
    void click(View v) {
        switch (v.getId()) {
            case R.id.backIV:
                finish();
                break;
        }
    }

    private void initClivkList(){
        nodeLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(NodeActivity.this,AuditaaActivity.class);
                intent.putExtra("nodeId",nodeResuls.get(position).getNodeId());
                startActivity(intent);
            }
        });
    }

    private void header() {
        header = LayoutInflater.from(NodeActivity.this).inflate(R.layout.header_item, null);
        headerTV= (TextView) header.findViewById(R.id.headerTV);

    }


    private void foot() {
        foot = LayoutInflater.from(NodeActivity.this).inflate(R.layout.foot_list_node, null);
         footTV= (TextView) foot.findViewById(R.id.footTV);

    }
    private void getNode() {
        Call<NodeData> call = RetrofitUtil.getHttpService().getNode(getToken(NodeActivity.this), productId + "");
        call.enqueue(new Callback<NodeData>() {
            @Override
            public void onResponse(Call<NodeData> call, Response<NodeData> response) {
                nodeResuls.addAll(response.body().getResult());
                nodeAdapter.notifyDataSetChanged();

                add=nodeResuls.get(0).getName();
                Log.i("sss",add);
                headerTV.setText(add);
                foots=nodeResuls.get(nodeResuls.size()-1).getName();
                footTV.setText(foots);

                Log.i("sss",foots);
                nodeResuls.remove(0);
                nodeResuls.remove(nodeResuls.size()-1);
                nodeAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<NodeData> call, Throwable t) {
            }
        });
    }
}
