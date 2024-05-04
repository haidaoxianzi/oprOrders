package com.opr.oders.pojo.yw.result;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * @Auther: gina
 * @Date: 2024-04-26
 * @Description:出库订单明细列表结果集【出库操作->发运订单->出库订单明细列表结果集】
 */
@Slf4j
@Getter
@Setter
public class OutOrderMingXiListResp {
    private String bizData;
    /**
     * bizData条数
     * eg:1
     */
    private String errMsg;
    private Boolean oK;


}
