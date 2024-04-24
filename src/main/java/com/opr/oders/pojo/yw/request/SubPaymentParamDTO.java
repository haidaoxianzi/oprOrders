package com.opr.oders.pojo.yw.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Auther: gina
 * @Date: 2024-04-15
 * @Description:
 */

public class SubPaymentParamDTO {
    private String selectedPaymentMethodCode;

    public SubPaymentParamDTO(String selectedPaymentMethodCode) {
        this.selectedPaymentMethodCode = selectedPaymentMethodCode;
    }

    public String getSelectedPaymentMethodCode() {
        return selectedPaymentMethodCode;
    }

    public void setSelectedPaymentMethodCode(String selectedPaymentMethodCode) {
        this.selectedPaymentMethodCode = selectedPaymentMethodCode;
    }
}
