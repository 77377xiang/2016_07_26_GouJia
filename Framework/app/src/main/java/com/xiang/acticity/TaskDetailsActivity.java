package com.xiang.acticity;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xiang.adapter.DialogBoxesAdapter;
import com.xiang.base.BaseActivity;
import com.xiang.data.CommissionData;
import com.xiang.data.CoreMemberData;
import com.xiang.data.CoreSeekData;
import com.xiang.data.DialogBoxeDelete;
import com.xiang.data.DialogBoxeSend;
import com.xiang.data.DialogBoxeSendData;
import com.xiang.data.GetDialogBoxes;
import com.xiang.data.GetDialogBoxesDate;
import com.xiang.data.MemberData;
import com.xiang.data.SeekData;
import com.xiang.data.StatusBar;
import com.xiang.data.Task;
import com.xiang.data.TaskManager;
import com.xiang.framework.R;
import com.xiang.util.RetrofitTask;
import com.xiang.util.RetrofitUtil;
import com.xiang.view.NoScrollListView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TaskDetailsActivity extends BaseActivity {
    int getId;
    int cuntent;
    int myRequestCode = 1;
    String text[] = {"未开始", "进行中", "已延期", "已取消", "已完成"};
    int photo[] = {R.drawable.await, R.drawable.ongoing, R.drawable.not, R.drawable.x, R.drawable.accomplish};
    List<GetDialogBoxesDate> getDialogBoxes = new ArrayList<>();
    DialogBoxesAdapter dialogBoxesAdapter;
    String getChatContent;
    String getContent;
    int getTaskStatus;
    int getIsDeal;
    @BindView(R.id.idTV)
    TextView idTV;
    @BindView(R.id.textTV)
    TextView textTV;
    @BindView(R.id.nameTV)
    TextView nameTV;

    @BindView(R.id.backIV)
    ImageView backIV;
    @BindView(R.id.waitingTV)
    TextView waitingTV;
    @BindView(R.id.alreadyTV)
    TextView alreadyTV;
    @BindView(R.id.startAndStopTimeTV)
    TextView startAndStopTimeTV;
    @BindView(R.id.modifiedLL)
    LinearLayout modifiedLL;
    @BindView(R.id.memberTV)
    TextView memberTV;
    //状态
    @BindView(R.id.stateTV)
    TextView stateTV;
    @BindView(R.id.showStatusIV)
    ImageView showStatusIV;

    @BindView(R.id.dialogNoSrollLV)
    NoScrollListView noScrollListView;
    @BindView(R.id.relativeLayoutRL)
    RelativeLayout relativeLayoutRL;

    @BindView(R.id.contentEd)
    EditText contentEd;
    @BindView(R.id.sendBT)
    Button sendBT;

    List<CoreMemberData> member;
    CoreSeekData rowsBean;
    Task rowsBeans;
    int type = 0;
    long PlanEndDate;
    long PlanStartDate;
    @Override

    public int getContentViewId() {
        return R.layout.activity_taskdetails;
    }

    @Override
    protected void initViews(Bundle bundle) {
        getType();
        initSetText();
        corresponding(getTaskStatus);
        getDialogBoxes();
        dialogBoxesAdapter = new DialogBoxesAdapter(getDialogBoxes, TaskDetailsActivity.this);
        noScrollListView.setAdapter(dialogBoxesAdapter);
        clickNoListView();
        getMember();
    }

    //发表交流处理
    private void clickNoListView() {
        noScrollListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name = getDialogBoxes.get(position).getCommitUser();
                SpannableString ss = new SpannableString(name);
                ss.setSpan(new ForegroundColorSpan(0xffffcc00), 0, name.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                contentEd.setText(ss);
            }
        });
        noScrollListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                getDialogBoxes.remove(position);
                dialogBoxesAdapter.notifyDataSetChanged();
                deleteNew();
                return true;
            }
        });
    }

    private void initDialogData(Response<GetDialogBoxes> response) {
        List<GetDialogBoxesDate> rowsBean = response.body().getResult().getRows();
        getDialogBoxes.addAll(rowsBean);
        dialogBoxesAdapter.notifyDataSetChanged();
        if (getDialogBoxes.size() == 0) {
            relativeLayoutRL.setVisibility(View.VISIBLE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == myRequestCode && resultCode == RESULT_OK) {
            cuntent = data.getIntExtra("number", 0);
            corresponding(cuntent);
        }
        requestModified();
    }

    //判断数据来源 已办 代办 全部   及其状态
    private void judgeData() {
        getId = rowsBeans.getId();
        getChatContent = rowsBeans.getChatContent();
        getContent = rowsBeans.getContent();
        getTaskStatus = rowsBeans.getTaskStatus();
        getIsDeal = rowsBeans.getIsDeal();
        PlanStartDate = rowsBeans.getPlanStartDate();
        PlanEndDate = rowsBeans.getPlanEndDate();
    }

    private void getType() {
        rowsBeans = (Task) getIntent().getSerializableExtra("key");
        rowsBean = (CoreSeekData) getIntent().getSerializableExtra("seek");

        if (rowsBeans == null) {
            type = rowsBean.getType();
        }
        if (type == 1) {
            judgeDataTwo();
        } else {
            judgeData();
        }
    }

    private void judgeDataTwo() {
        getId = rowsBean.getId();
        getChatContent = String.valueOf(rowsBean.getChatContent());
        getContent = rowsBean.getContent();
        getTaskStatus = rowsBean.getTaskStatus();
        PlanStartDate = rowsBean.getPlanStartDate();
        PlanEndDate = rowsBean.getPlanEndDate();
        //   getIsDeal = (int) rowsBean.getIsDeal();
    }

    //数据放到各个控件
    private void initSetText() {
        idTV.setText(getId + "");
        textTV.setText(getContent);
        nameTV.setText(getChatContent);
        startAndStopTimeTV.setText( RetrofitTask.getNoTime(PlanStartDate)+ "-"+RetrofitTask.getNoTime(PlanEndDate));
        if (getIsDeal == 0) {
            waiting();
        } else {
            already();
        }
    }

    @OnClick({R.id.backIV, R.id.waitingTV, R.id.alreadyTV, R.id.modifiedLL, R.id.memberTV, R.id.sendBT})
    void click(View v) {
        switch (v.getId()) {
            case R.id.backIV:
                finish();
                break;
            case R.id.waitingTV:
                waiting();
                //需要请求网路修改成功
                taskManager();
                showDialogwithString("正在加载请稍后");
                break;
            case R.id.alreadyTV:
                already();
                taskManager();
                showDialogwithString("正在加载请稍后");
                break;
            case R.id.modifiedLL:
                //改变状态
                Intent intent = new Intent(TaskDetailsActivity.this, ModificationActivity.class);
                intent.putExtra("TaskStatus", getTaskStatus);
                startActivityForResult(intent, 1);
                break;
            case R.id.memberTV:
                // 共有成员
                Intent intentMember = new Intent(TaskDetailsActivity.this, MemberActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("member", (Serializable) member);
                intentMember.putExtras(bundle);
                startActivity(intentMember);
                // 共有成员
                break;
            case R.id.sendBT:
                sendNew();
                break;
        }
    }

    //添加发送的消息
    private void sendNew() {
        String content = contentEd.getText().toString();
        Call<DialogBoxeSend> call = RetrofitUtil.getHttpService().setSendNew(getToken(TaskDetailsActivity.this), getId + "", content, 4100 + "");
        call.enqueue(new Callback<DialogBoxeSend>() {
            @Override
            public void onResponse(Call<DialogBoxeSend> call, Response<DialogBoxeSend> response) {
                getDialogBoxes.clear();
                contentEd.setText("");
                getDialogBoxes();
            }

            @Override
            public void onFailure(Call<DialogBoxeSend> call, Throwable t) {
            }
        });
    }

    //删除消息
    private void deleteNew() {
        Call<DialogBoxeDelete> call = RetrofitUtil.getHttpService().getDialogBoxesDelete(getToken(TaskDetailsActivity.this), 4110 + "");
        call.enqueue(new Callback<DialogBoxeDelete>() {
            @Override
            public void onResponse(Call<DialogBoxeDelete> call, Response<DialogBoxeDelete> response) {
            }

            @Override
            public void onFailure(Call<DialogBoxeDelete> call, Throwable t) {
            }
        });
    }

    public void requestModified() {
        Call<StatusBar> call = RetrofitUtil.getHttpService().getRequestModified(getToken(TaskDetailsActivity.this), getId + "", "4");
        call.enqueue(new Callback<StatusBar>() {
            @Override
            public void onResponse(Call<StatusBar> call, Response<StatusBar> response) {
            }

            @Override
            public void onFailure(Call<StatusBar> call, Throwable t) {
            }
        });
    }

    public void taskManager() {
        Call<TaskManager> call = RetrofitUtil.getHttpService().getchange(getToken(TaskDetailsActivity.this), getId + "", "2");
        call.enqueue(new Callback<TaskManager>() {
            @Override
            public void onResponse(Call<TaskManager> call, Response<TaskManager> response) {
                dissDialog();
            }

            @Override
            public void onFailure(Call<TaskManager> call, Throwable t) {
            }
        });
    }

    public void getDialogBoxes() {
        Call<GetDialogBoxes> call = RetrofitUtil.getHttpService().getDialogBoxes(getToken(TaskDetailsActivity.this), getId + "", "5", "1", "1");
        call.enqueue(new Callback<GetDialogBoxes>() {
            @Override
            public void onResponse(Call<GetDialogBoxes> call, Response<GetDialogBoxes> response) {
                initDialogData(response);
            }

            @Override
            public void onFailure(Call<GetDialogBoxes> call, Throwable t) {
            }
        });
    }

    //请求成员列表
    private void getMember() {
        Call<MemberData> call = RetrofitUtil.getHttpService().setMember(getToken(TaskDetailsActivity.this), getId + "");
        call.enqueue(new Callback<MemberData>() {
            @Override
            public void onResponse(Call<MemberData> call, Response<MemberData> response) {
                member = response.body().getResult().getRows();
                memberTV.setText("共有" + (member.size() - 1) + "成员");
            }

            @Override
            public void onFailure(Call<MemberData> call, Throwable t) {
            }
        });
    }

    private void corresponding(int number) {
        switch (number) {
            case 0:
                stateTV.setText(text[0]);
                showStatusIV.setImageResource(photo[0]);
                break;
            case 1:
                stateTV.setText(text[1]);
                showStatusIV.setImageResource(photo[1]);
                break;
            case 2:
                stateTV.setText(text[2]);
                showStatusIV.setImageResource(photo[2]);
                break;
            case 3:
                stateTV.setText(text[3]);
                showStatusIV.setImageResource(photo[3]);
                break;
            case 4:
                stateTV.setText(text[4]);
                showStatusIV.setImageResource(photo[4]);
                break;
        }
    }

    //代办
    private void waiting() {
        waitingTV.setBackgroundColor(0xff877e7e);//深灰
        waitingTV.setTextColor(0xffffffff);
        alreadyTV.setBackgroundColor(0xff969696);//浅灰
        alreadyTV.setTextColor(0xff969696);
    }

    //已办
    private void already() {
        waitingTV.setBackgroundColor(0xff969696);
        waitingTV.setTextColor(0xff969696);
        alreadyTV.setBackgroundColor(0xff40b2cf);
        alreadyTV.setTextColor(0xffffffff);
    }
}
