package com.opr.oders.pojo.yw.request;

import lombok.Getter;
import lombok.Setter;

/**
 * @Auther: gina
 * @Date: 2024-04-12
 * @Description:
 */

public class SubBuyerParamDTO {
    private String buyerId;

    public SubBuyerParamDTO(String buyerId) {
        this.buyerId = buyerId;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }
}
