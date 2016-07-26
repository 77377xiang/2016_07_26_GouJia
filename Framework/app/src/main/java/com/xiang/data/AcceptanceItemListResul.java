package com.xiang.data;

/**
 * Created by Administrator on 2016/7/15.
 */
public class AcceptanceItemListResul {
    private int acceptanceItemId;
    private String imagePath;
    private int status;
    private String name;
    private String exampleImagePath;

    public int getAcceptanceItemId() {
        return acceptanceItemId;
    }

    public void setAcceptanceItemId(int acceptanceItemId) {
        this.acceptanceItemId = acceptanceItemId;
    }

    public String getExampleImagePath() {
        return exampleImagePath;
    }

    public void setExampleImagePath(String exampleImagePath) {
        this.exampleImagePath = exampleImagePath;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
