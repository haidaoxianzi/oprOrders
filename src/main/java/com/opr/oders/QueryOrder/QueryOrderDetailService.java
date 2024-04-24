package com.opr.oders.QueryOrder;

import com.opr.oders.pojo.yw.result.OrderDetailResp;
import com.opr.oders.pojo.yw.result.SubOrderDetaiResult;

/**
 * @Auther: gina
 * @Date: 2024-04-12
 * @Description:
 */
public interface QueryOrderDetailService {
    public OrderDetailResp orderDetail(String orderId);
}
