package com.opr.oders.GenOrderYouXuan.LianYing;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.opr.oders.OMSsendgoods.service.DaCangSendGoodsService;
import com.opr.oders.QueryOrder.QueryOrderDetailService;
import com.opr.oders.common.Opr.Constants4OMS;
import com.opr.oders.common.Opr.Constants4WMS;
import com.opr.oders.common.Opr.InfosManagement;
import com.opr.oders.common.httpclient.HttpClientUtil;
import com.opr.oders.pojo.yw.result.*;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.DateUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * @Auther: gina
 * @Date: 2024-04-24
 * @Description:
 */
@Slf4j
@SpringBootTest
public class WMSSendGoodsTest {
    @Resource
    QueryOrderDetailService queryOrderDetailService;

    QueryWmsPhysicalInventoryResp genQueryWmsPhysicalInventoryResp() {
        QueryWmsPhysicalInventoryResp qWmsPhysicalInventoryResp = new QueryWmsPhysicalInventoryResp();
        List<SubWmsPhysicalInventory> result = new ArrayList<>();
        SubWmsPhysicalInventory store1 = new SubWmsPhysicalInventory("4099986", " BF001", "2021-05-10", "2099-05-10", "source_facotry", "10005");
        SubWmsPhysicalInventory store2 = new SubWmsPhysicalInventory("69947", "O20240201", " 2024-02-01", "2026-01-31", "source_facotry", "12661");
        result.add(store1);
        result.add(store2);

        qWmsPhysicalInventoryResp.setResult(result);
        qWmsPhysicalInventoryResp.setSuccess(true);
        qWmsPhysicalInventoryResp.setTotal(2);
        return qWmsPhysicalInventoryResp;
    }


    @Test
    void wmsSendGoodsTest() {

        String orderId = "9300000959120101048";


        //查询订单详情，看是哪个仓发货，然后到wms查
        OrderDetailResp orderDetail = queryOrderDetailService.orderDetail("9300000943795606279");
//        orderDetailShow.orderItemList.warehouseName "苏州线上仓"
        List<SubOrderItem> orderItemList = orderDetail.getResult().getOrderDetailShow().getOrderItemList();
        if (CollectionUtils.isEmpty(orderItemList)) {
            log.error("发货数据有问题：orderItemList is null");
            return;
        }
        SubOrderItem orderItem = new SubOrderItem();
        for (int i = 0; i < orderItemList.size(); i++) {
            orderItem = orderItemList.get(i);
            String warehouseName = orderItem.getWarehouseName();
            if (warehouseName.equals("苏州线上仓")) {
                //todo 调试 【苏州线上仓做条件】查库存共享端
                //mock 查库存共享端结果集：检查批号，生产，效期，来源工厂 wms跟库存共享比对，剩余库存比对 要高于需要待分配的库存
                QueryWmsPhysicalInventoryResp qStoreShare = genQueryWmsPhysicalInventoryResp();

                //查wms 订单详情 todo  suzhouDS.sendGoodsQuery();
            }
        }

    }

    /**
     * step1
     * wms出库订单查询
     * 已通，拿下一个接口想要的入参【双击得到的数据，哪个接口加载的】
     * <p>
     * 可以作废了，有调用
     */
    @Test
    void wmsOutOrderQuery() {
        String orderId = "9300000959120101048";
        if (StringUtils.isEmpty(orderId)) {
            return;//"订单号不能为空";
        }
        //todayFormate=2024-04-24
        String todayFormate = DateUtil.newIsoDateFormat().format(new Date());
        String url = Constants4WMS.SIT3_WMS_Host + InfosManagement.SEND_GOODS_ORDER_OMS + "&&priority=&priority_new_value=false&consigneeId=&route=&route_new_value=false&t1.soReference3=&t1.soReference3_new_value=false&waveNo=&waveFlag=&waveFlag_new_value=false&pickingPrintFlag=&pickingPrintFlag_new_value=false&erpCancelFlag_new_value=false&ediSendFlag=&ediSendFlag_new_value=false&showOtherSku=Y&dccOrder=N&expectedShipmentTime1FmexpectedShipmentTime1To=&expectedShipmentTime1Fm=&expectedShipmentTime1To=&lastShipmentTimeFmlastShipmentTimeTo=&lastShipmentTimeFm=&lastShipmentTimeTo=&udfQryExp=&udfQryExp_new_value=true&orderNo=&soStatus=&soStatus_new_value=false&orderType=&orderType_new_value=false&h1.Channel_Code=&soReference1=&soReference2Test=" +
                orderId + "&h1.soReference4=&h1.deliveryNo=&h1.consigneeEmail=&h1.consigneeTel1=&carrierId=&h1.waveNo=&h1.hedi19=&h1.hedi19_new_value=false&h1.vehicleType=&h1.vehicleType_new_value=true&sku=" +
                "&orderTimeFmorderTimeTo=" + todayFormate + "+00%3A00%3A00+++-+++" + todayFormate + "+23%3A59%3A59&orderTimeFm=" + todayFormate + "+00%3A00%3A00&orderTimeTo=" + todayFormate + "+23%3A59%3A59" +
                "&h1.releaseStatus=&h1.releaseStatus_new_value=false&erpCancelFlag=&h1.ediErrorCode=&h1.ediErrorCode_new_value=true&customerId=" +
                //仓库 SZDS == 苏州商务仓 ，以后可能会成为变量
                "&warehouseId=SZDS&WND_CUS_MLT=Y&functionId=A3001&fid=A3001&&queryName=HeaderGrid&clsid=a3001_header&method=getHeadersList";

        try {
            JSONObject jsonObject = HttpClientUtil.post4FormCommit(url, null, Constants4WMS.WMS_COOKIE, null);
            log.info("jsonObject===={}/n", jsonObject.toJSONString());

        } catch (IOException e) {
            log.error(" orderDetail error", e);
        }

    }


    @Resource
    private DaCangSendGoodsService suzhouDS;

    /*苏州电商仓发货test
     * 表单提交test
     * */
    @Test
    void testSuZhouDSSendGoods() {
        suzhouDS.sendGoodsQuery();
    }

    /*苏州电商仓发货test
     * 表单提交test
     * */
    @Test
    void compareBatchInfo() {

        SubWMSGoodsStoreInfo subWMSGoodsStoreInfo = suzhouDS.compareBatchInfo(1, "SZSOX8240426000025", "SZDS", "XM001");
        log.info("subWMSGoodsStoreInfo={}", JSON.toJSONString(subWMSGoodsStoreInfo));
    }

    @Test
    void test() {
        String checkItems = "[{\"customerId\":\"" + 12661 + "\",\"sku\":\"" + "XM001" + "\",\"lotNum\":\""
                + "HG80023799" + "\",\"locationId\":\"" + "A99" + "\",\"traceId\":\"*\",\"qtySelect\":\"" +
                1 + "\"}]";
        String param = "clsid=a3001_detailRightKey&method=process&srvMethod=addAllocationDetails&waveNo=&packId=1%2F1%2F1" +
                "&warehouseId=" + "SZDS" + "&orderNo=" + "SZSOX8240425000161" + "&orderLineNo=" + 1 + "&checkItems=" + JSON.toJSONString(checkItems);
/*
        log.info("all={}", JSON.toJSONString(param));
        log.info("all222={}", param);*/

        String str = JSON.toJSONString(checkItems);
        log.info("all222={}", str.getBytes(StandardCharsets.US_ASCII).toString());

    }
@Test
    void test2(){
    String checkItems = "[{\"customerId\":\"" + 12661 + "\",\"sku\":\"" + "XM001" + "\",\"lotNum\":\""
            + "HG80023799" + "\",\"locationId\":\"" + "A99" + "\",\"traceId\":\"*\",\"qtySelect\":\"" +
            1 + "\"}]";


    String str = JSON.toJSONString(checkItems);
        for (int i = 0; i < str.length(); i++) {
            int asciiCode = (int) str.charAt(i);
            System.out.println("Character: " + str.charAt(i) + " ASCII: " + asciiCode);
        }
    }

}
