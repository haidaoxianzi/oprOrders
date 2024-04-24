package com.opr.oders.pojo.yw.result;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @Auther: gina
 * @Date: 2024-04-15
 * @Description:
 */

public class SubPaymentDTO {
    List<SubPaymentMethodDTO> paymentMethodDTOList;

    public List<SubPaymentMethodDTO> getPaymentMethodDTOList() {
        return paymentMethodDTOList;
    }

    public void setPaymentMethodDTOList(List<SubPaymentMethodDTO> paymentMethodDTOList) {
        this.paymentMethodDTOList = paymentMethodDTOList;
    }
}
