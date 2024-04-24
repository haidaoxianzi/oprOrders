package com.opr.oders.pojo.yw.request;

import lombok.Data;

/**
 * @Auther: gina
 * @Date: 2024-04-15
 * @Description:
 */

public class SubDeliveryParamDTO {
    private String selectedDeliveryType="1";

    public String getSelectedDeliveryType() {
        return selectedDeliveryType;
    }

    public void setSelectedDeliveryType(String selectedDeliveryType) {
        this.selectedDeliveryType = selectedDeliveryType;
    }
}
