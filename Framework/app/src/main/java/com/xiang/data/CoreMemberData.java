package com.xiang.data;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/7/12.
 */
public class CoreMemberData implements Serializable{
        private int id;
        private boolean isCreator;
        private String userName;
        private Object headPortrait;
        private int isHandle;
        private int type;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public boolean isIsCreator() {
            return isCreator;
        }

        public void setIsCreator(boolean isCreator) {
            this.isCreator = isCreator;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public Object getHeadPortrait() {
            return headPortrait;
        }

        public void setHeadPortrait(Object headPortrait) {
            this.headPortrait = headPortrait;
        }

        public int getIsHandle() {
            return isHandle;
        }

        public void setIsHandle(int isHandle) {
            this.isHandle = isHandle;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

}
