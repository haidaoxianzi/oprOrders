package com.opr.oders.KuCunShare.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.opr.oders.KuCunShare.service.BatchStockService;
import com.opr.oders.common.Opr.Constants4OMS;
import com.opr.oders.common.Opr.Constants4StoreShare;
import com.opr.oders.common.Opr.Constants4WMS;
import com.opr.oders.common.httpclient.HttpClientUtil;
import com.opr.oders.pojo.yw.request.StoreShareEnum;
import com.opr.oders.pojo.yw.result.QueryWmsPhysicalInventoryResp;
import com.opr.oders.pojo.yw.result.SubWMSGoodsStoreInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: gina
 * @Date: 2024-04-17
 * @Description:售后大仓入库需要查批次库存信息
 */
@Service
@Slf4j
public class BatchStockServiceImpl implements BatchStockService {
    private static final Logger log = LogManager.getLogger(BatchStockServiceImpl.class);

    /**
     * 入库操作，批次库存查询
     */
    @Override
    public void queryWmsPhysicalInventory(String warehouseIds, String skuCodeStr) {
//        String url = Constants4StoreShare.UAT2_STORE_HOST + Constants4StoreShare.QUERY_WMS_PHYSICAL_INVENTORY;
        String url = "https://stock.uat2-backend.feihe.com/api/erp_wms/queryWmsPhysicalInventory";
        /*  {"_fields":[],"start":0,"limit":20,"haveTotalQuantity":"true","warehouseIdList":["1000000191"],"skuCodeStr":"XM001","batchEnable":"1","status":"1"}*/

        Map<String, Object> paramMap = new HashMap<>();
        List _fields = new ArrayList();
        paramMap.put("_fields", _fields);
        paramMap.put("start", 0);
        paramMap.put("limit", 20);
        paramMap.put("haveTotalQuantity", "true");
        List<String> warehouseIdList = new ArrayList<>();
        warehouseIdList.add(StoreShareEnum.getStoreShareWarehouseId(warehouseIds));//枚举做适配 1000000191
        paramMap.put("warehouseIdList", warehouseIdList);
        paramMap.put("skuCodeStr", skuCodeStr);
        paramMap.put("batchEnable", "1");
        paramMap.put("status", "1");
        String paramJSonStr = JSON.toJSONString(paramMap);
        log.info("queryWmsPhysicalInventory paramJSonStr={}", paramJSonStr);

        try {
            JSONObject jsonObj = HttpClientUtil.post(url, paramJSonStr, Constants4StoreShare.Cookie, Constants4StoreShare.OMS_TOKEN);

            // String bizDataStr = jsonObj.getString("bizData");
            QueryWmsPhysicalInventoryResp wmsPhysicalInventoryResp = QueryWmsPhysicalInventoryResp.jsonObject2Bean(jsonObj, QueryWmsPhysicalInventoryResp.class);
            log.info("QueryWmsPhysicalInventoryResp jsonObj==={}",jsonObj.toJSONString());
            log.info("wmsPhysicalInventoryResp==={}", JSON.toJSONString(wmsPhysicalInventoryResp));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
