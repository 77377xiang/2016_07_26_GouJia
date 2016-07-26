package com.xiang.data;

import java.io.Serializable;

public class Task implements Serializable {
    private long createTime;
    private long planStartDate;
    private String chatContent;
    private boolean isUrgency;
    private long latestTime;
    private long planEndDate;
    private int isDeal;
    private int id;
    private String content;
    private Object picPath;
    private Object parentId;
    private int taskStatus;
    private String userName;
    private Object parentContent;
    private int type;

    public String getChatContent() {
        return chatContent;
    }

    public void setChatContent(String chatContent) {
        this.chatContent = chatContent;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIsDeal() {
        return isDeal;
    }

    public void setIsDeal(int isDeal) {
        this.isDeal = isDeal;
    }

    public boolean isUrgency() {
        return isUrgency;
    }

    public void setUrgency(boolean urgency) {
        isUrgency = urgency;
    }

    public long getLatestTime() {
        return latestTime;
    }

    public void setLatestTime(long latestTime) {
        this.latestTime = latestTime;
    }

    public Object getParentContent() {
        return parentContent;
    }

    public void setParentContent(Object parentContent) {
        this.parentContent = parentContent;
    }

    public Object getParentId() {
        return parentId;
    }

    public void setParentId(Object parentId) {
        this.parentId = parentId;
    }

    public Object getPicPath() {
        return picPath;
    }

    public void setPicPath(Object picPath) {
        this.picPath = picPath;
    }

    public long getPlanEndDate() {
        return planEndDate;
    }

    public void setPlanEndDate(long planEndDate) {
        this.planEndDate = planEndDate;
    }

    public long getPlanStartDate() {
        return planStartDate;
    }

    public void setPlanStartDate(long planStartDate) {
        this.planStartDate = planStartDate;
    }

    public int getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(int taskStatus) {
        this.taskStatus = taskStatus;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
