package com.xiang.data;

import java.io.Serializable;
import java.util.List;

public class MemberData extends BaseResponse implements Serializable{
    private ResultBean result;
    public ResultBean getResult() {
        return result;
    }
    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean implements Serializable{
        private int total;
        private List<CoreMemberData> rows;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<CoreMemberData> getRows() {
            return rows;
        }

        public void setRows(List<CoreMemberData> rows) {
            this.rows = rows;
        }

    }
}
