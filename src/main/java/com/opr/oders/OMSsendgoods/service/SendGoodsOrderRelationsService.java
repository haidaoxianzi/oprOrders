package com.opr.oders.OMSsendgoods.service;

import com.opr.oders.pojo.yw.result.SubOrderSendGoods;
import com.opr.oders.pojo.yw.result.SubOutOrderMingXiDetail;
import com.opr.oders.pojo.yw.result.SubWMSGoodsStoreInfo;

import java.util.List;

/**
 * @Auther: gina
 * @Date: 2024-04-26
 * @Description:
 */
public interface SendGoodsOrderRelationsService {
    /**
     * step1:出库列表查询
     */
    List<SubOrderSendGoods> getSendGoodsOrderList(String orderId, String warehouseId, String todayFormate);

    /**
     * step2:出库订单明细列表
     */
    List<SubOutOrderMingXiDetail> getSendGoodsOrderMingXiDetailList(String orderNo, String warehouseId);

    /**
     * step3:按订单行分配【添加分配明细操作】
     */
    boolean addDistributionDetail(SubWMSGoodsStoreInfo wmsGoodsStoreInfo, String warehouseId, String orderNo, int orderLineNo, String customerId, String sku, int dingGoodCount);

    /**
     * step4:发货->按订单行
     */
    boolean sendGoodsByOrderLine(String warehouseId, String orderNo, int orderLineNo);
}
