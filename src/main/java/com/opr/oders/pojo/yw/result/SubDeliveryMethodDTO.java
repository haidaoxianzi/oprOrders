package com.opr.oders.pojo.yw.result;

import lombok.Getter;
import lombok.Setter;

/**
 * @Auther: gina
 * @Date: 2024-04-15
 * @Description:
 */

public class SubDeliveryMethodDTO {
    private SubShippingFee shippingFee;
    private Integer deliveryType;
    private String deliveryName;
    private boolean selected;

    public SubShippingFee getShippingFee() {
        return shippingFee;
    }

    public void setShippingFee(SubShippingFee shippingFee) {
        this.shippingFee = shippingFee;
    }

    public Integer getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(Integer deliveryType) {
        this.deliveryType = deliveryType;
    }

    public String getDeliveryName() {
        return deliveryName;
    }

    public void setDeliveryName(String deliveryName) {
        this.deliveryName = deliveryName;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
