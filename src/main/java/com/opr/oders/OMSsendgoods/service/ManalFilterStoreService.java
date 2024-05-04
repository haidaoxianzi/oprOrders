package com.opr.oders.OMSsendgoods.service;

import com.opr.oders.pojo.yw.result.SubWMSGoodsStoreInfo;

import java.util.List;

/**
 * @Auther: gina
 * @Date: 2024-04-26
 * @Description:人工筛选库存
 */
public interface ManalFilterStoreService {
    /**
     * wms人工筛选库存
     */
    public List<SubWMSGoodsStoreInfo> manalFilterStore(String orderNo, String warehouseId, String sku);

}
