package com.xiang.data;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/7/12.
 */
public class SeekData  extends BaseResponse implements Serializable{
    private CoreSeekData result;
    public CoreSeekData getResult() {
        return result;
    }

    public void setResult(CoreSeekData result) {
        this.result = result;
    }

}
