package com.xiang.data;

import java.util.List;

/**
 * Created by Administrator on 2016/7/13.
 */
public class SectionData extends BaseResponse{
    String nanme;
    List<SubprojectData> subprojects;
    private ResultBean result;
    public List<SubprojectData> getSubprojects() {
        return subprojects;
    }

    public void setSubprojects(List<SubprojectData> subprojects) {
        this.subprojects = subprojects;
    }

    public String getNanme() {
        return nanme;
    }

    public void setNanme(String nanme) {
        this.nanme = nanme;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        private int total;
        private int totalAll;
        private List<?> rows;

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

        public List<?> getRows() {
            return rows;
        }

        public void setRows(List<?> rows) {
            this.rows = rows;
        }
    }
}
