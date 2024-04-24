package com.opr.oders.pojo.yw.result;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @Auther: gina
 * @Date: 2024-04-15
 * @Description:
 */

public class SubFulfillmentDTO {
    private List<SubDeliveryMethodDTO> deliveryMethodDTOList;

    public List<SubDeliveryMethodDTO> getDeliveryMethodDTOList() {
        return deliveryMethodDTOList;
    }

    public void setDeliveryMethodDTOList(List<SubDeliveryMethodDTO> deliveryMethodDTOList) {
        this.deliveryMethodDTOList = deliveryMethodDTOList;
    }
}
