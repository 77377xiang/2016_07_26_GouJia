package com.xiang.data;

import java.util.List;

/**
 * Created by Administrator on 2016/7/11.
 */
public class GetDialogBoxes extends BaseResponse{

    private ResultBean result;
    public ResultBean getResult() {
        return result;
    }
    public void setResult(ResultBean result) {
        this.result = result;
    }
    public static class ResultBean {
        private int total;

        private List<GetDialogBoxesDate> rows;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<GetDialogBoxesDate> getRows() {
            return rows;
        }

        public void setRows(List<GetDialogBoxesDate> rows) {
            this.rows = rows;
        }

    }
}
