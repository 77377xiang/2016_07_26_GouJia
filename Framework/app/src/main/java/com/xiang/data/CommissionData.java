package com.xiang.data;

import java.io.Serializable;
import java.util.List;

public class CommissionData extends BaseResponse implements Serializable {
    private ResultData result;
    public ResultData getResult() {
        return result;
    }
    public void setResult(ResultData result) {
        this.result = result;
    }
    public static class ResultData implements Serializable {
        private int total;
        private int totalAll;
        private List<Task> rows;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getTotalAll() {
            return totalAll;
        }

        public void setTotalAll(int totalAll) {
            this.totalAll = totalAll;
        }

        public List<Task> getRows() {
            return rows;
        }

        public void setRows(List<Task> rows) {
            this.rows = rows;
        }

    }
}
