package com.opr.oders.OMSsendgoods.service;

import com.opr.oders.pojo.yw.result.SubWMSGoodsStoreInfo;

/**
 * @Auther: gina
 * @Date: 2024-04-17
 * @Description:
 */
public interface DaCangSendGoodsService {
    /*
     * 正向发货查询
     * */
    public void sendGoodsQuery();

    /*
     * 参考库存共享和人工筛选库存，筛选出添加分配明细对象
     * */
    SubWMSGoodsStoreInfo compareBatchInfo(int dingGoodCount, String orderNo, String warehouseId, String sku);
}
