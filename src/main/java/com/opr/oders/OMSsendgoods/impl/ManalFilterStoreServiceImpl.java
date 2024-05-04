package com.opr.oders.OMSsendgoods.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.opr.oders.OMSsendgoods.service.ManalFilterStoreService;
import com.opr.oders.common.Opr.Constants4WMS;
import com.opr.oders.common.Opr.InfosManagement;
import com.opr.oders.common.httpclient.HttpClientUtil;
import com.opr.oders.pojo.yw.result.SubWMSGoodsStoreInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: gina
 * @Date: 2024-04-26
 * @Description:
 */
@Slf4j
@Service
public class ManalFilterStoreServiceImpl implements ManalFilterStoreService {

    @Override
    public List<SubWMSGoodsStoreInfo>  manalFilterStore(String orderNo,String warehouseId,String sku) {

        String manal_filter_store_url = Constants4WMS.SIT3_WMS_Host + InfosManagement.ORDER_MANAL_FILTER_STORE;
        String param2 = "&functionId=A3001&warehouseId=" + warehouseId + "&lotNum=&orderLineNo=1&sku=" + sku +
                "&customerId=12661&lotAtt01=&INV_UOM_QTY=Y&MANUAL_ALLOCATE_DEFAULTQTY=Y&orderNo=" +
                orderNo + "&lotAtt02=&INV_UOM_QTY=Y&MANUAL_ALLOCATE_DEFAULTQTY=Y&orderNo=" + orderNo + "&lotAtt03=&INV_UOM_QTY=Y&MANUAL_ALLOCATE_DEFAULTQTY=Y&orderNo=" +
                orderNo + "&lotAtt04=&INV_UOM_QTY=Y&MANUAL_ALLOCATE_DEFAULTQTY=Y&orderNo=" + orderNo + "&lotAtt05=&INV_UOM_QTY=Y&MANUAL_ALLOCATE_DEFAULTQTY=Y&orderNo=" +
                orderNo + "&lotAtt06=&INV_UOM_QTY=Y&MANUAL_ALLOCATE_DEFAULTQTY=Y&orderNo=" + orderNo + "&lotAtt07=&INV_UOM_QTY=Y&MANUAL_ALLOCATE_DEFAULTQTY=Y&orderNo=" +
                orderNo + "&lotAtt08=&INV_UOM_QTY=Y&MANUAL_ALLOCATE_DEFAULTQTY=Y&orderNo=" + orderNo + "&lotAtt09=&INV_UOM_QTY=Y&MANUAL_ALLOCATE_DEFAULTQTY=Y&orderNo=" +
                orderNo + "&lotAtt10=&INV_UOM_QTY=Y&MANUAL_ALLOCATE_DEFAULTQTY=Y&orderNo=" + orderNo + "&lotAtt11=&INV_UOM_QTY=Y&MANUAL_ALLOCATE_DEFAULTQTY=Y&orderNo=" +
                orderNo + "&lotAtt12=&INV_UOM_QTY=Y&MANUAL_ALLOCATE_DEFAULTQTY=Y&orderNo=" + orderNo + "&lotAtt13=&INV_UOM_QTY=Y&MANUAL_ALLOCATE_DEFAULTQTY=Y&orderNo=" +
                orderNo + "&lotAtt14=&INV_UOM_QTY=Y&MANUAL_ALLOCATE_DEFAULTQTY=Y&orderNo=" + orderNo + "&lotAtt15=&INV_UOM_QTY=Y&MANUAL_ALLOCATE_DEFAULTQTY=Y&orderNo=" +
                orderNo + "&lotAtt16=&INV_UOM_QTY=Y&MANUAL_ALLOCATE_DEFAULTQTY=Y&orderNo=" + orderNo + "&lotAtt17=&INV_UOM_QTY=Y&MANUAL_ALLOCATE_DEFAULTQTY=Y&orderNo=" +
                orderNo + "&lotAtt18=&INV_UOM_QTY=Y&MANUAL_ALLOCATE_DEFAULTQTY=Y&orderNo=" + orderNo + "&lotAtt19=&INV_UOM_QTY=Y&MANUAL_ALLOCATE_DEFAULTQTY=Y&orderNo=" +
                orderNo + "&lotAtt20=&INV_UOM_QTY=Y&MANUAL_ALLOCATE_DEFAULTQTY=Y&orderNo=" + orderNo + "&lotAtt21=&INV_UOM_QTY=Y&MANUAL_ALLOCATE_DEFAULTQTY=Y&orderNo=" +
                orderNo + "&lotAtt22=&INV_UOM_QTY=Y&MANUAL_ALLOCATE_DEFAULTQTY=Y&orderNo=" + orderNo + "&lotAtt23=&INV_UOM_QTY=Y&MANUAL_ALLOCATE_DEFAULTQTY=Y&orderNo=" +
                orderNo + "&lotAtt24=&INV_UOM_QTY=Y&MANUAL_ALLOCATE_DEFAULTQTY=Y&orderNo=" + orderNo + "&queryName=manualAllocationgrid&clsid=a3001_detailRightKey&method=getManualAllocationInfo";
        List<SubWMSGoodsStoreInfo> list = new ArrayList<>();
        try {
            JSONObject jsonObj = HttpClientUtil.post4FormCommit(manal_filter_store_url, param2, Constants4WMS.Cookie, null);
            String bizDataStr = jsonObj.getString("bizData");
            list = SubWMSGoodsStoreInfo.jsonArray2Bean2(bizDataStr);
            if (CollectionUtils.isEmpty(list)) {
                log.error("wms人工筛选库存数据列表元素为空");
                return null;
            }
            log.info("manal jsonObj==={}", jsonObj.toJSONString());
            log.info("manal list==={}", JSON.toJSONString(list));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return list;
    }
}
