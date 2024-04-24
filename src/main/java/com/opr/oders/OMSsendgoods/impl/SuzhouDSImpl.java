package com.opr.oders.OMSsendgoods.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.opr.oders.OMSsendgoods.service.DaCangSendGoodsService;
import com.opr.oders.common.Opr.Constants4WMS;
import com.opr.oders.common.httpclient.HttpClientUtil;
import com.opr.oders.pojo.yw.result.SubWMSGoodsStoreInfo;
import lombok.extern.slf4j.XSlf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * @Auther: gina
 * @Date: 2024-04-17
 * @Description:苏州电商仓 todo 123wq 来一笔订单先确认是哪个大仓，通过抽象模式+适配器模式 实现
 */
@Service
@XSlf4j
public class SuzhouDSImpl implements DaCangSendGoodsService {
    private static final Logger log = LogManager.getLogger(SuzhouDSImpl.class);

    //com.opr.oders.GenOrderYouXuan.LianYing.HttpClientUtilCalledTest.orderDetail()
    /*
     * 正向发货---出库列表查询
     * */
    public void sendGoodsQuery() {
        //1、出库列表查询
        /* param换其他订单对比，进行参数化*/
        String url = Constants4WMS.UAT2_WMS_Host + Constants4WMS.FA_YUN_ORDER_QUERY;
        //业务号
        String yeNumber = "9300000943795606279";
        String param = "&&priority=&priority_new_value=false&consigneeId=&route=&route_new_value=false&t1.soReference3=&t1.soReference3_new_value=false&waveNo=&waveFlag=&waveFlag_new_value=false&pickingPrintFlag=&pickingPrintFlag_new_value=false&erpCancelFlag_new_value=false&ediSendFlag=&ediSendFlag_new_value=false&showOtherSku=Y&dccOrder=N&expectedShipmentTime1FmexpectedShipmentTime1To=&expectedShipmentTime1Fm=&expectedShipmentTime1To=&lastShipmentTimeFmlastShipmentTimeTo=&lastShipmentTimeFm=&lastShipmentTimeTo=&udfQryExp=&udfQryExp_new_value=true&orderNo=&soStatus=&soStatus_new_value=false&orderType=&orderType_new_value=false&h1.Channel_Code=&soReference1=&soReference2Test=" + yeNumber + "&h1.soReference4=&h1.deliveryNo=&h1.consigneeEmail=&h1.consigneeTel1=&carrierId=&h1.waveNo=&h1.hedi19=&h1.hedi19_new_value=false&h1.vehicleType=&h1.vehicleType_new_value=true&sku=&orderTimeFmorderTimeTo=2024-02-17+00%3A00%3A00+++-+++2024-04-17+23%3A59%3A59&orderTimeFm=2024-02-17+00%3A00%3A00&orderTimeTo=2024-04-17+23%3A59%3A59&h1.releaseStatus=&h1.releaseStatus_new_value=false&erpCancelFlag=&h1.ediErrorCode=&h1.ediErrorCode_new_value=true&customerId=10005&warehouseId=SZDS&WND_CUS_MLT=Y&functionId=A3001&fid=A3001&&queryName=HeaderGrid&clsid=a3001_header&method=getHeadersList";
        try {
            JSONObject jsonObj = HttpClientUtil.post4FormCommit(url, param, Constants4WMS.Cookie, null);
            log.info("sendGoods jsonObj==={}", jsonObj.toJSONString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //2、人工筛选库存
        String manal_filter_store_url = Constants4WMS.UAT2_WMS_Host + Constants4WMS.ORDER_MANAL_FILTER_STORE;
        String param2 = "&functionId=A3001&warehouseId=SZDS&lotNum=&orderLineNo=1&sku=XM001&customerId=10005&lotAtt01=&INV_UOM_QTY=Y&MANUAL_ALLOCATE_DEFAULTQTY=Y&orderNo=SZSOX240318000001&lotAtt02=&INV_UOM_QTY=Y&MANUAL_ALLOCATE_DEFAULTQTY=Y&orderNo=SZSOX240318000001&lotAtt03=&INV_UOM_QTY=Y&MANUAL_ALLOCATE_DEFAULTQTY=Y&orderNo=SZSOX240318000001&lotAtt04=&INV_UOM_QTY=Y&MANUAL_ALLOCATE_DEFAULTQTY=Y&orderNo=SZSOX240318000001&lotAtt05=&INV_UOM_QTY=Y&MANUAL_ALLOCATE_DEFAULTQTY=Y&orderNo=SZSOX240318000001&lotAtt06=&INV_UOM_QTY=Y&MANUAL_ALLOCATE_DEFAULTQTY=Y&orderNo=SZSOX240318000001&lotAtt07=&INV_UOM_QTY=Y&MANUAL_ALLOCATE_DEFAULTQTY=Y&orderNo=SZSOX240318000001&lotAtt08=02&INV_UOM_QTY=Y&MANUAL_ALLOCATE_DEFAULTQTY=Y&orderNo=SZSOX240318000001&lotAtt09=&INV_UOM_QTY=Y&MANUAL_ALLOCATE_DEFAULTQTY=Y&orderNo=SZSOX240318000001&lotAtt10=&INV_UOM_QTY=Y&MANUAL_ALLOCATE_DEFAULTQTY=Y&orderNo=SZSOX240318000001&lotAtt11=&INV_UOM_QTY=Y&MANUAL_ALLOCATE_DEFAULTQTY=Y&orderNo=SZSOX240318000001&lotAtt12=&INV_UOM_QTY=Y&MANUAL_ALLOCATE_DEFAULTQTY=Y&orderNo=SZSOX240318000001&lotAtt13=&INV_UOM_QTY=Y&MANUAL_ALLOCATE_DEFAULTQTY=Y&orderNo=SZSOX240318000001&lotAtt14=&INV_UOM_QTY=Y&MANUAL_ALLOCATE_DEFAULTQTY=Y&orderNo=SZSOX240318000001&lotAtt15=&INV_UOM_QTY=Y&MANUAL_ALLOCATE_DEFAULTQTY=Y&orderNo=SZSOX240318000001&lotAtt16=&INV_UOM_QTY=Y&MANUAL_ALLOCATE_DEFAULTQTY=Y&orderNo=SZSOX240318000001&lotAtt17=&INV_UOM_QTY=Y&MANUAL_ALLOCATE_DEFAULTQTY=Y&orderNo=SZSOX240318000001&lotAtt18=&INV_UOM_QTY=Y&MANUAL_ALLOCATE_DEFAULTQTY=Y&orderNo=SZSOX240318000001&lotAtt19=&INV_UOM_QTY=Y&MANUAL_ALLOCATE_DEFAULTQTY=Y&orderNo=SZSOX240318000001&lotAtt20=&INV_UOM_QTY=Y&MANUAL_ALLOCATE_DEFAULTQTY=Y&orderNo=SZSOX240318000001&lotAtt21=&INV_UOM_QTY=Y&MANUAL_ALLOCATE_DEFAULTQTY=Y&orderNo=SZSOX240318000001&lotAtt22=&INV_UOM_QTY=Y&MANUAL_ALLOCATE_DEFAULTQTY=Y&orderNo=SZSOX240318000001&lotAtt23=&INV_UOM_QTY=Y&MANUAL_ALLOCATE_DEFAULTQTY=Y&orderNo=SZSOX240318000001&lotAtt24=&INV_UOM_QTY=Y&MANUAL_ALLOCATE_DEFAULTQTY=Y&orderNo=SZSOX240318000001&queryName=manualAllocationgrid&clsid=a3001_detailRightKey&method=getManualAllocationInfo";
        try {
            JSONObject jsonObj = HttpClientUtil.post4FormCommit(manal_filter_store_url, param2, Constants4WMS.Cookie, null);
            String bizDataStr = jsonObj.getString("bizData");
            List<SubWMSGoodsStoreInfo> list = SubWMSGoodsStoreInfo.jsonArray2Bean2(bizDataStr);

            log.info("manal jsonObj==={}", jsonObj.toJSONString());
            log.info("manal list==={}", JSON.toJSONString(list));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * 逆向发货
     */
    public void sendGoodsReverse() {

    }
}
