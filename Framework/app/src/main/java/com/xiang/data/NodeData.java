package com.xiang.data;

import java.util.List;

/**
 * Created by Administrator on 2016/7/14.
 */
public class NodeData extends BaseResponse {
    private List<NodeResul> result;
    public List<NodeResul> getResult() {
        return result;
    }
    public void setResult(List<NodeResul> result) {
        this.result = result;
    }
}
