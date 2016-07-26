package com.xiang.data;

import java.util.List;

/**
 * Created by Administrator on 2016/7/13.
 */
public class DepartmentListOneData {
    private String name;
    private List<Type> children;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Type> getChildren() {
        return children;
    }

    public void setChildren(List<Type> children) {
        this.children = children;
    }
}
