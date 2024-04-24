package com.opr.oders.GenOrderYouXuan.serivce;

import com.alibaba.fastjson.JSONObject;
import com.opr.oders.pojo.yw.result.RenderOrderResp;

/**
 * @Auther: gina
 * @Date: 2024-04-12
 * @Description:
 */
public interface PointPayOrderService {

   /** 创单-step1 渲染订单
   * @Param : []
   * @return com.alibaba.fastjson.JSONObject
   */
    JSONObject renderOrder();
    /** 创单-step2 创单
     * @Param : []
     * @return com.alibaba.fastjson.JSONObject
     */
    JSONObject createOrder(RenderOrderResp renderOrderResp);

}
