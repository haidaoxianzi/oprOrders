package com.opr.oders.pojo.yw.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * @Auther: gina
 * @Date: 2024-04-15
 * @Description:
 */

@Slf4j
public class SubAddressParamDTO {
    private String selectedAddressId ;

    public SubAddressParamDTO(String selectedAddressId) {
        this.selectedAddressId = selectedAddressId;
    }

    public String getSelectedAddressId() {
        return selectedAddressId;
    }

    public void setSelectedAddressId(String selectedAddressId) {
        this.selectedAddressId = selectedAddressId;
    }
}
