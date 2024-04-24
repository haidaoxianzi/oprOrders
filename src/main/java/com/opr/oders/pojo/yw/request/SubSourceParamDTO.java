package com.opr.oders.pojo.yw.request;

import lombok.Getter;
import lombok.Setter;

/**
 * @Auther: gina
 * @Date: 2024-04-12
 * @Description:
 */

public class SubSourceParamDTO {

    private String openId;
    private String orderFrom = "ITEM_DETAIL";
    private String platformType = "APPLET";

    public SubSourceParamDTO(String openId) {
        this.openId = openId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getOrderFrom() {
        return orderFrom;
    }

    public void setOrderFrom(String orderFrom) {
        this.orderFrom = orderFrom;
    }

    public String getPlatformType() {
        return platformType;
    }

    public void setPlatformType(String platformType) {
        this.platformType = platformType;
    }
}
