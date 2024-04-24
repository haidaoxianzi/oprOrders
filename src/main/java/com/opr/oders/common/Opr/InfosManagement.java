package com.opr.oders.common.Opr;

/**
 * @Auther: gina
 * @Date: 2024-04-12
 * @Description:接口集管理
 */
public class InfosManagement {
    //创单step1/2--渲染订单接口
    public static final String RENDER_ORDER ="/buy/dubbo/renderOrder";
    //创单step2/2--创建订单接口
    public static final String CREATE_ORDER ="/buy/dubbo/createOrder";

    //oms订单详情接口
    public static final String orderDetail_OMS = "/api/retailforce_oms/trade_query_order_detail";
}
