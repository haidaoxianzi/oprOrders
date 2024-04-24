package com.opr.oders.pojo.yw.result;

/**
 * @Auther: gina
 * @Date: 2024-04-17
 * @Description:
 */
public class SubOrderStatus {

    //   "2024-03-18 09:24:01"
    private String modifiedTime;
    private boolean isCurrentStatus;

    //"买家下单"
    private String desc;

    public String getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(String modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public boolean isCurrentStatus() {
        return isCurrentStatus;
    }

    public void setCurrentStatus(boolean currentStatus) {
        isCurrentStatus = currentStatus;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
