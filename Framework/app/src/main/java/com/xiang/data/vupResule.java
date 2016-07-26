package com.xiang.data;

/**
 * Created by Administrator on 2016/7/16.
 */
public class vupResule extends BaseResponse {

    private ResultBean result;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        private Object updateContent;
        private String updata;
        private String url;

        public Object getUpdateContent() {
            return updateContent;
        }

        public void setUpdateContent(Object updateContent) {
            this.updateContent = updateContent;
        }

        public String getUpdata() {
            return updata;
        }

        public void setUpdata(String updata) {
            this.updata = updata;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
