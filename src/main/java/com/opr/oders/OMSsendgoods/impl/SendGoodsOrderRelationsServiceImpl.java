package com.opr.oders.OMSsendgoods.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.opr.oders.OMSsendgoods.service.SendGoodsOrderRelationsService;
import com.opr.oders.common.Opr.Constants4WMS;
import com.opr.oders.common.Opr.InfosManagement;
import com.opr.oders.common.httpclient.HttpClientUtil;
import com.opr.oders.pojo.yw.result.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.utils.DateUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.*;

/**
 * @Auther: gina
 * @Date: 2024-04-26
 * @Description:出库订单相关操作
 */
@Service
@Slf4j
public class SendGoodsOrderRelationsServiceImpl implements SendGoodsOrderRelationsService {
    @Override
    public List<SubOrderSendGoods> getSendGoodsOrderList(String orderId, String warehouseId, String todayFormate) {
        /* param换其他订单对比，进行参数化*/
        String url = Constants4WMS.SIT3_WMS_Host + InfosManagement.SEND_GOODS_ORDER_OMS;
        if (StringUtils.isEmpty(todayFormate)) {
            todayFormate = DateUtils.formatDate(new Date(), "yyyy-MM-dd");//todayFormate=2024-04-24
        }
        String toFormate = DateUtils.formatDate(new Date(), "yyyy-MM-dd");
        String param = "&&priority=&priority_new_value=false&consigneeId=&route=&route_new_value=false&t1.soReference3=&t1.soReference3_new_value=false&waveNo=&waveFlag=&waveFlag_new_value=false&pickingPrintFlag=&" +
                "pickingPrintFlag_new_value=false&erpCancelFlag_new_value=false&ediSendFlag=&ediSendFlag_new_value=false&showOtherSku=Y&dccOrder=N&expectedShipmentTime1FmexpectedShipmentTime1To=&expectedShipmentTime1Fm=&" +
                "expectedShipmentTime1To=&lastShipmentTimeFmlastShipmentTimeTo=&lastShipmentTimeFm=&lastShipmentTimeTo=&udfQryExp=&udfQryExp_new_value=true&orderNo=&soStatus=&soStatus_new_value=false&orderType=&orderType_new_value=false" +
                "&h1.Channel_Code=&soReference1=&soReference2Test=" +
                orderId + "&h1.soReference4=&h1.deliveryNo=&h1.consigneeEmail=&h1.consigneeTel1=&carrierId=&h1.waveNo=&h1.hedi19=&h1.hedi19_new_value=false&h1.vehicleType=&h1.vehicleType_new_value=true&sku=" +
                "&orderTimeFmorderTimeTo=" + todayFormate + "+00%3A00%3A00+++-+++" + toFormate + "+23%3A59%3A59&orderTimeFm=" + todayFormate + "+00%3A00%3A00&orderTimeTo=" + toFormate + "+23%3A59%3A59" +
                "&h1.releaseStatus=&h1.releaseStatus_new_value=false&erpCancelFlag=&h1.ediErrorCode=&h1.ediErrorCode_new_value=true&customerId=" +
                //仓库 SZDS == 苏州商务仓 ，以后可能会成为变量
                "&warehouseId=" + warehouseId + "&WND_CUS_MLT=Y&functionId=A3001&fid=A3001&&queryName=HeaderGrid&clsid=a3001_header&method=getHeadersList";
        try {
            JSONObject jsonObj = HttpClientUtil.post4FormCommit(url, param, Constants4WMS.WMS_COOKIE, null);
            OutOrderListResp outOrderListResp = JSON.toJavaObject(jsonObj, OutOrderListResp.class);
            if (outOrderListResp.isOK() && !StringUtils.isEmpty(outOrderListResp.getBizData())) {
                List<SubOrderSendGoods> orderSendGoods = SubOrderSendGoods.jsonArray2Bean(outOrderListResp.getBizData());
                return orderSendGoods;
            }
            log.info("sendGoods jsonObj==={}", jsonObj.toJSONString());

            return null;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<SubOutOrderMingXiDetail> getSendGoodsOrderMingXiDetailList(String orderNo, String warehouseId) {
        String getDetailsListUrl = Constants4WMS.SIT3_WMS_Host + InfosManagement.OUT_ORDER_DETAILS_LIST_OMS;


        String detailsListParam = "&&warehouseId=" + warehouseId + "&orderNo=" + orderNo +
                "&functionId=A3001&queryName=DetailGrid&clsid=a3001_detail&method=getDetailsList&sku=&showOtherSku=Y";


        List<SubOutOrderMingXiDetail> outOrderMingXiDetailList = new ArrayList<>();
        try {
            JSONObject jsonObj = HttpClientUtil.post4FormCommit(getDetailsListUrl, detailsListParam, Constants4WMS.WMS_COOKIE, null);
            OutOrderMingXiListResp outOrderMingXiListResp = JSON.toJavaObject(jsonObj, OutOrderMingXiListResp.class);

            if (outOrderMingXiListResp.getOK() && !StringUtils.isEmpty(outOrderMingXiListResp.getBizData())) {
                //String bizDataStr = jsonObj.getString("bizData");
                outOrderMingXiDetailList = SubOutOrderMingXiDetail.jsonArray2Bean(outOrderMingXiListResp.getBizData());
                if (CollectionUtils.isEmpty(outOrderMingXiDetailList)) {
                    log.error("wms人工筛选库存数据列表元素为空");
                    return null;
                }
            }
            log.info("manal jsonObj==={}", jsonObj.toJSONString());
            log.info("manal wms人工筛选库存列表==={}", JSON.toJSONString(outOrderMingXiDetailList));
            return outOrderMingXiDetailList;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public boolean addDistributionDetail(SubWMSGoodsStoreInfo wmsGoodsStoreInfo, String warehouseId, String orderNo, int orderLineNo, String customerId, String sku, int dingGoodCount) {
        if (null != wmsGoodsStoreInfo) {
            String param = "clsid=a3001_detailRightKey&method=process&srvMethod=addAllocationDetails&checkItems=%5B%7B%22customerId%22%3A%22" +
                    customerId + "%22%2C%22sku%22%3A%22" +
                    sku + "%22%2C%22lotNum%22%3A%22" +
                    wmsGoodsStoreInfo.getLotNum() + "%22%2C%22locationId%22%3A%22" +
                    //库位
                    wmsGoodsStoreInfo.getLocationId() + "%22%2C%22traceId%22%3A%22*%22%2C%22qtySelect%22%3A%221%22%7D%5D&waveNo=&packId=1%2F1%2F1&" +
                    "warehouseId=" + warehouseId + "&orderNo=" + orderNo +
                    "&orderLineNo=" + orderLineNo;
            String addDistributionDetailUrl = Constants4WMS.SIT3_WMS_Host + InfosManagement.ADD_DISTRIBUTION_MING_XI;


            try {
                //调用接口【点击分配明细】，解析返回值
                JSONObject jsonObj = HttpClientUtil.post4FormCommit(addDistributionDetailUrl, param, Constants4WMS.WMS_COOKIE, null);
                AddDistributionDetailResp addDistributionDetailResp = JSON.toJavaObject(jsonObj, AddDistributionDetailResp.class);
                return addDistributionDetailResp.isOK();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return false;
    }

    @Override
    public boolean sendGoodsByOrderLine(String warehouseId, String orderNo, int orderLineNo) {
       /* String param1 = "clsid=a3001_detailRightKey&method=process&srvMethod=addAllocationDetails&checkItems=%5B%7B%22customerId%22%3A%22" +
                customerId + "%22%2C%22sku%22%3A%22" +
                sku + "%22%2C%22lotNum%22%3A%22" +
                wmsGoodsStoreInfo.getLotNum() + "%22%2C%22locationId%22%3A%22" +
                //库位
                wmsGoodsStoreInfo.getLocationId() + "%22%2C%22traceId%22%3A%22*%22%2C%22qtySelect%22%3A%221%22%7D%5D&waveNo=&packId=1%2F1%2F1&" +
                "warehouseId=" + warehouseId + "&orderNo=" + orderNo +
                "&orderLineNo=" + orderLineNo;
*/
        String param = "clsid=a3001_detailRightKey&method=shipment_OrderLinesProcess&rowData_json=%5B%7B%22organizationId%22%3A%22FEIHE%22%2C%22" +
                "warehouseId%22%3A%22" + warehouseId + "%22%2C%22orderNo" +
                orderNo + "%22%2C%22orderLineNo%22%3A" +
                orderLineNo + "%2C%22" +
                //todo 123wq
                "id%22%3A%22" + "1714817430087" +
                "%22%7D%5D&para_json=%7BerrorMsgPromptFields%3A'orderNo%2CorderLineNo'%7D&currentTable_json=%7BtableName%3A'DOC_ORDER_DETAILS'%7D";

        String addDistributionDetailUrl = Constants4WMS.SIT3_WMS_Host + InfosManagement.SEND_GOODS_BY_ORDER_LINE;

        try {
            //调用接口【点击分配明细】，解析返回值
            JSONObject jsonObj = HttpClientUtil.post4FormCommit(addDistributionDetailUrl, param, Constants4WMS.WMS_COOKIE, null);
            AddDistributionDetailResp addDistributionDetailResp = JSON.toJavaObject(jsonObj, AddDistributionDetailResp.class);
            return addDistributionDetailResp.isOK();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
