package com.xiang.data;

/**
 * Created by Administrator on 2016/7/13.
 */
public class TaskType {
    private int id;
    private boolean invalid;
    private int status;
    private long createdDatetime;
    private long updatedDatetime;
    private int orderTag;
    private Object user;
    private int pageSize;
    private int start;
    private Object sortOrder;
    private Object sortField;
    private String name;
    private int type;
    private int pageNo;
    private int currentPage;

    public long getCreatedDatetime() {
        return createdDatetime;
    }

    public void setCreatedDatetime(long createdDatetime) {
        this.createdDatetime = createdDatetime;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isInvalid() {
        return invalid;
    }

    public void setInvalid(boolean invalid) {
        this.invalid = invalid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOrderTag() {
        return orderTag;
    }

    public void setOrderTag(int orderTag) {
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public long getUpdatedDatetime() {
        return updatedDatetime;
    }

    public void setUpdatedDatetime(long updatedDatetime) {
        this.updatedDatetime = updatedDatetime;
    }

    public Object getUser() {
        return user;
    }

    public void setUser(Object user) {
        this.user = user;
    }
}
