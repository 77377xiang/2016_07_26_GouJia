package com.xiang.data;

import java.util.List;

/**
 * Created by Administrator on 2016/7/12.
 */
public class DialogBoxeSendData {
    private int id;
    private Object invalid;
    private Object status;
    private Object createdDatetime;
    private long updatedDatetime;
    private Object orderTag;
    private Object user;
    private int pageSize;
    private int start;
    private Object sortOrder;
    private Object sortField;
    private int taskId;
    private Object number;
    private Object userId;
    private String content;
    private String commitUser;
    private long gmtCreate;
    private Object customerId;
    private Object customerType;
    private int parentId;
    private Object rootId;
    private Object updateTime;

    public Object getActualEndDate() {
        return actualEndDate;
    }

    public void setActualEndDate(Object actualEndDate) {
        this.actualEndDate = actualEndDate;
    }

    public Object getActualStartDate() {
        return actualStartDate;
    }

    public void setActualStartDate(Object actualStartDate) {
        this.actualStartDate = actualStartDate;
    }

    public Object getAttachmentIds() {
        return attachmentIds;
    }

    public void setAttachmentIds(Object attachmentIds) {
        this.attachmentIds = attachmentIds;
    }

    public List<?> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<?> attachments) {
        this.attachments = attachments;
    }

    public Object getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(Object checkDate) {
        this.checkDate = checkDate;
    }

    public String getCommitUser() {
        return commitUser;
    }

    public void setCommitUser(String commitUser) {
        this.commitUser = commitUser;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Object getCreatedDatetime() {
        return createdDatetime;
    }

    public void setCreatedDatetime(Object createdDatetime) {
        this.createdDatetime = createdDatetime;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public Object getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Object customerId) {
        this.customerId = customerId;
    }

    public Object getCustomerType() {
        return customerType;
    }

    public void setCustomerType(Object customerType) {
        this.customerType = customerType;
    }

    public long getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Object getHeadPortrait() {
        return headPortrait;
    }

    public void setHeadPortrait(Object headPortrait) {
        this.headPortrait = headPortrait;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIfDelete() {
        return ifDelete;
    }

    public void setIfDelete(String ifDelete) {
        this.ifDelete = ifDelete;
    }

    public Object getInvalid() {
        return invalid;
    }

    public void setInvalid(Object invalid) {
        this.invalid = invalid;
    }

    public Object getIsHandle() {
        return isHandle;
    }

    public void setIsHandle(Object isHandle) {
        this.isHandle = isHandle;
    }

    public Object getNumber() {
        return number;
    }

    public void setNumber(Object number) {
        this.number = number;
    }

    public Object getOrderTag() {
        return orderTag;
    }

    public void setOrderTag(Object orderTag) {
        this.orderTag = orderTag;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public Object getRootId() {
        return rootId;
    }

    public void setRootId(Object rootId) {
        this.rootId = rootId;
    }

    public Object getSortField() {
        return sortField;
    }

    public void setSortField(Object sortField) {
        this.sortField = sortField;
    }

    public Object getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Object sortOrder) {
        this.sortOrder = sortOrder;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public Object getStatus() {
        return status;
    }

    public void setStatus(Object status) {
        this.status = status;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public long getUpdatedDatetime() {
        return updatedDatetime;
    }

    public void setUpdatedDatetime(long updatedDatetime) {
        this.updatedDatetime = updatedDatetime;
    }

    public Object getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Object updateTime) {
        this.updateTime = updateTime;
    }

    public Object getUser() {
        return user;
    }

    public void setUser(Object user) {
        this.user = user;
    }

    public Object getUserId() {
        return userId;
    }

    public void setUserId(Object userId) {
        this.userId = userId;
    }

    private Object headPortrait;
    private Object attachmentIds;
    private Object isHandle;
    private String ifDelete;
    private Object checkDate;
    private Object actualStartDate;
    private Object actualEndDate;
    private int pageNo;
    private int currentPage;
    private List<?> attachments;
}
