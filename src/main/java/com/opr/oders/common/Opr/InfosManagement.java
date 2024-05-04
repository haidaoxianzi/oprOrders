package com.opr.oders.common.Opr;

/**
 * @Auther: gina
 * @Date: 2024-04-12
 * @Description:接口集管理
 */
public class InfosManagement {

    //创单step1/2--渲染订单接口
    public static final String RENDER_ORDER = "/buy/dubbo/renderOrder";

    //创单step2/2--创建订单接口
    public static final String CREATE_ORDER = "/buy/dubbo/createOrder";

    //oms订单详情接口
    public static final String orderDetail_OMS = "/api/retailforce_oms/trade_query_order_detail";

    /**
     * wms出库查订单详情
     */
    public static final String SEND_GOODS_ORDER_OMS = "/A30OubBizWeb/getJsonAction?clsId=a3001_header&method=getHeadersList";

    /**
     * wms 分配-按订单行【操作：编辑人工筛选库存后，点击 添加分配明细】
     */
    public static final String ADD_DISTRIBUTION_MING_XI = "/A30OubBizWeb/getJsonAction";

    /**
     * wms 发货-按订单行
     */
    public static final String SEND_GOODS_BY_ORDER_LINE = "/A30OubBizWeb/getJsonAction?clsId=a3001_detailRightKey&method=shipment_OrderLinesProcess";

    /**
     * wms出库订单查详情列表
     * 订单明细列表可能会有多行信息，比如组合物料拼订单
     */
    public static final String OUT_ORDER_DETAILS_LIST_OMS = "/A30OubBizWeb/getJsonAction?clsId=a3001_detail&method=getDetailsList";

    /**
     * wms-人工筛选库存
     */
    public static final String ORDER_MANAL_FILTER_STORE = "/A30OubBizWeb/getJsonAction?clsId=a3001_detailRightKey&method=getManualAllocationInfo";

}
