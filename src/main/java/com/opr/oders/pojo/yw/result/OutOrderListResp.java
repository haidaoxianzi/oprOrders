package com.opr.oders.pojo.yw.result;

import lombok.Getter;
import lombok.Setter;

/**
 * @Auther: gina
 * @Date: 2024-04-26
 * @Description:查询出库 订单列表的数据
 */
@Getter
@Setter
public class OutOrderListResp {
    private boolean oK;
    private String bizData;
    //eg:"1"
    private String errMsg;
}
