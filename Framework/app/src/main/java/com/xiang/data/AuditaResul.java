package com.xiang.data;

import java.util.List;

/**
 * Created by Administrator on 2016/7/15.
 */
public class AuditaResul {
    private List<AcceptanceItemListResul> acceptanceItemList;
    private int status;
    private String resultMessage;
    private String nodeName;

    public List<AcceptanceItemListResul> getAcceptanceItemList() {
        return acceptanceItemList;
    }

    public void setAcceptanceItemList(List<AcceptanceItemListResul> acceptanceItemList) {
        this.acceptanceItemList = acceptanceItemList;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
