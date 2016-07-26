package com.xiang.data;

import java.util.List;


public class GetDialogBoxesDate {
        private String content;
        private int id;
        private long gmtCreate;
        private String commitUser;
        private String ifDelete;
        private Object headPortrait;
        private List<?> attachments;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public long getGmtCreate() {
            return gmtCreate;
        }

        public void setGmtCreate(long gmtCreate) {
            this.gmtCreate = gmtCreate;
        }

        public String getCommitUser() {
            return commitUser;
        }

        public void setCommitUser(String commitUser) {
            this.commitUser = commitUser;
        }

        public String getIfDelete() {
            return ifDelete;
        }

        public void setIfDelete(String ifDelete) {
            this.ifDelete = ifDelete;
        }

        public Object getHeadPortrait() {
            return headPortrait;
        }

        public void setHeadPortrait(Object headPortrait) {
            this.headPortrait = headPortrait;
        }

        public List<?> getAttachments() {
            return attachments;
        }

        public void setAttachments(List<?> attachments) {
            this.attachments = attachments;
        }
}
