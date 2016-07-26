package com.xiang.interfaces;

import com.xiang.data.AllPowerful;
import com.xiang.data.AuditaData;
import com.xiang.data.BaseResponse;
import com.xiang.data.CommissionData;
import com.xiang.data.DialogBoxeDelete;
import com.xiang.data.DialogBoxeSend;
import com.xiang.data.FeedbackResul;
import com.xiang.data.GetDialogBoxes;
import com.xiang.data.MemberData;
import com.xiang.data.NodeData;
import com.xiang.data.SeekData;
import com.xiang.data.StatusBar;
import com.xiang.data.TaskManager;
import com.xiang.data.UserResponse;
import com.xiang.data.WorkData;
import com.xiang.data.vupResule;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface HttpService {
    //登录有加密
    @FormUrlEncoded
    @POST("appLoginMD5")
    Call<UserResponse> getUserByLogin(@Field("account") String account, @Field("passwordKey") String passwordKey);

    //任务
    @GET("projectTask/taskList")
    Call<CommissionData> getTaskList(@Header("Cookie") String Cookie, @Query("difference") String difference, @Query("isDeal") String isDeal, @Query("pageSize") String pageSize, @Query("number") String number);

    //更改任务是否已办
    @GET("projectTask/updateTaskDeal")
    Call<TaskManager> getchange(@Header("Cookie") String Cookie, @Query("id") String taskId, @Query("isDeal") String isDeal);

    //交流列表
    @GET("communication/list")
    Call<GetDialogBoxes> getDialogBoxes(@Header("Cookie") String Cookie, @Query("id") String id, @Query("pageSize") String pageSize, @Query("number") String number, @Query("mobileLogin") String mobileLogin);

    //更改任务状态是否已办
    @GET("projectTask/updateTaskStatus")
    Call<StatusBar> getRequestModified(@Header("Cookie") String Cookie, @Query("id") String taskId, @Query("taskStatus") String taskStatus);

    //发送交流类容
    @GET("communication/publish")
    Call<DialogBoxeSend> setSendNew(@Header("Cookie") String Cookie, @Query("taskId") String taskId, @Query("content") String taskStatus, @Query("parentId") String parentId);

    //删除交流类容
    @GET("communication/delete")
    Call<DialogBoxeDelete> getDialogBoxesDelete(@Header("Cookie") String Cookie, @Query("communicationID") String communicationID);

    //成员列表
    @GET("taskparticipant/memberList")
    Call<MemberData> setMember(@Header("Cookie") String Cookie, @Query("taskId") String taskId);

    //收索
    @GET("projectTask/findTaskById")
    Call<SeekData> setSeek(@Header("Cookie") String Cookie, @Query("taskId") String taskId);

    //任务筛选
    @GET("projectTask/taskList")
    Call<BaseResponse> getSelect(@Header("Cookie") String Cookie, @Query("difference") String taskId, @Query("isDeal") String isDeal, @Query("pageSize") String pageSize, @Query("number") String number, @Query("taskStatus") String taskStatus, @Query("typeId") String typeId);

    //任务类型
    @GET("tasktye/listType")
    Call<AllPowerful> getType(@Header("Cookie") String Cookie, @Query("type") String type);

    //工作
    @GET("shopProjectJson/userworklist")
    Call<WorkData> getWork(@Header("Cookie") String Cookie, @Query("userId") String userId, @Query("pageSize") String pageSize, @Query("pageNum") String pageNum);

    @GET("customer/getNodeList.html")
    Call<NodeData> getNode(@Header("Cookie") String Cookie, @Query("productId") String productId);

    @GET("shopProjectNodeJson/getNodeDetailList")
    Call<AuditaData> getNodeDetailList(@Header("Cookie") String Cookie, @Query("nodeId") String nodeId);

    //意见反馈
    @GET("shopFeedbackJson/save_shopFeedback")
    Call<FeedbackResul> setContent(@Header("Cookie") String Cookie, @Query("content") String content);

    //版本更新
    @GET("shopVersionJson/packageUpdate")
    Call<vupResule> getVUP(@Header("Cookie") String Cookie, @Query("appType") String appType, @Query("version") String version);

    //退出
    @GET("shopVersionJson/packageUpdate")
    Call<BaseResponse> exitParams(@Header("Cookie") String Cookie);
}
