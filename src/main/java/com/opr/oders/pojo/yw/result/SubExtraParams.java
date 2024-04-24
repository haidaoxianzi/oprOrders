package com.opr.oders.pojo.yw.result;

import lombok.Getter;
import lombok.Setter;

/**
 * @Auther: gina
 * @Date: 2024-04-15
 * @Description:
 */

public class SubExtraParams {

    private String freeShippingActivityId;
    private String upperStoreId;
    private String storeBizPermit;
    private String itemShippingFee;
    private String shareUser;

    public String getFreeShippingActivityId() {
        return freeShippingActivityId;
    }

    public void setFreeShippingActivityId(String freeShippingActivityId) {
        this.freeShippingActivityId = freeShippingActivityId;
    }

    public String getUpperStoreId() {
        return upperStoreId;
    }

    public void setUpperStoreId(String upperStoreId) {
        this.upperStoreId = upperStoreId;
    }

    public String getStoreBizPermit() {
        return storeBizPermit;
    }

    public void setStoreBizPermit(String storeBizPermit) {
        this.storeBizPermit = storeBizPermit;
    }

    public String getItemShippingFee() {
        return itemShippingFee;
    }

    public void setItemShippingFee(String itemShippingFee) {
        this.itemShippingFee = itemShippingFee;
    }

    public String getShareUser() {
        return shareUser;
    }

    public void setShareUser(String shareUser) {
        this.shareUser = shareUser;
    }
}
