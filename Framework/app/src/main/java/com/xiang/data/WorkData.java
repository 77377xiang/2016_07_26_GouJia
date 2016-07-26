package com.xiang.data;

import java.util.List;

/**
 * Created by Administrator on 2016/7/8.
 */
public class WorkData extends BaseResponse {
    private List<WorkResult> result;
    public List<WorkResult> getResult() {
        return result;
    }
    public void setResult(List<WorkResult> result) {
        this.result = result;
    }
}
