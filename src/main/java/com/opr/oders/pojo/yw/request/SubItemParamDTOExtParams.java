package com.opr.oders.pojo.yw.request;

import lombok.Getter;
import lombok.Setter;

/**
 * @Auther: gina
 * @Date: 2024-04-12
 * @Description:
 */
@Getter
@Setter
public class SubItemParamDTOExtParams {
    /* "freeShippingActivityId": "",
             "upperStoreId": "2000701522",
             "itemShippingFee": "0",
             "shareUser": ""*/
    private String freeShippingActivityId="";
    private String upperStoreId="2000701522";
    private String itemShippingFee="0";
    private String shareUser="";
}
