package com.xiang.data;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/7/12.
 */
    public  class CoreSeekData implements Serializable {
        private long createTime;
        private long planStartDate;
        private Object chatContent;
        private Object latestTime;
        private long planEndDate;
        private Object isDeal;
        private int id;
        private String content;
        private Object picPath;
        private Object parentId;
        private int taskStatus;
        private String userName;
        private Object parentContent;
        private int type=1;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public long getPlanStartDate() {
            return planStartDate;
        }

        public void setPlanStartDate(long planStartDate) {
            this.planStartDate = planStartDate;
        }

        public Object getChatContent() {
            return chatContent;
        }

        public void setChatContent(Object chatContent) {
            this.chatContent = chatContent;
        }

        public Object getLatestTime() {
            return latestTime;
        }

        public void setLatestTime(Object latestTime) {
            this.latestTime = latestTime;
        }

        public long getPlanEndDate() {
            return planEndDate;
        }

        public void setPlanEndDate(long planEndDate) {
            this.planEndDate = planEndDate;
        }

        public Object getIsDeal() {
            return isDeal;
        }

        public void setIsDeal(Object isDeal) {
            this.isDeal = isDeal;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public Object getPicPath() {
            return picPath;
        }

        public void setPicPath(Object picPath) {
            this.picPath = picPath;
        }

        public Object getParentId() {
            return parentId;
        }

        public void setParentId(Object parentId) {
            this.parentId = parentId;
        }

        public int getTaskStatus() {
            return taskStatus;
        }

        public void setTaskStatus(int taskStatus) {
            this.taskStatus = taskStatus;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public Object getParentContent() {
            return parentContent;
        }

        public void setParentContent(Object parentContent) {
            this.parentContent = parentContent;
        }

}

