package com.opr.oders.ChangJing.demo.impl;

import com.opr.oders.ChangJing.demo.service.SceneExecuteService;
import com.opr.oders.KuCunShare.service.BatchStockService;
import com.opr.oders.QueryOrder.QueryOrderDetailService;
import com.opr.oders.pojo.yw.result.OrderDetailResp;
import com.opr.oders.pojo.yw.result.SubOrderItem;
import com.opr.oders.pojo.yw.result.SubSubOrderBaseFeatures;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: gina
 * @Date: 2024-04-17
 * @Description:
 */
@Slf4j
public class SceneExecuteServiceImpl implements SceneExecuteService {
    private static final Logger log = LogManager.getLogger(SceneExecuteServiceImpl.class);
    @Resource
    private QueryOrderDetailService qOrderDetailService;

    @Resource
    private BatchStockService batchStockService;

    @Override
    public String sendGoods(String orderId) {
        //1、查询oms订单详情，获取仓库和物料编码
        OrderDetailResp orderDetail = qOrderDetailService.orderDetail(orderId);
        if (!orderDetail.isSuccess()) {
            log.info("查询订单信息异常 ：{}", orderId);
            return "订单查询失败";
        }
        //获取仓库【订单商品定仓的仓库】和物料编码
        List<String> warehouseNames = new ArrayList<>();
        List<SubOrderItem> orderItemList = orderDetail.getResult().getOrderDetailShow().getOrderItemList();
        SubSubOrderBaseFeatures orderBase = orderDetail.getResult().getOrderBase().getFeatures();
        String warehouseIds = orderBase.getWarehouseIds();//库存共享端
        for (int i = 0; i <orderItemList.size() ; i++) {
           String skuCode= orderItemList.get(i).getSkuCode();
            //2、到库存共享端查询批号，生产日期，效期，来源工厂，String warehouseIds="1000000191";skuCode="XM001"
            batchStockService.queryWmsPhysicalInventory(warehouseIds, skuCode);

            // 3到wms 发货，出库 输入 订单单号，人工筛选库存，以库存共享端对比，待分配库存 < 可用库存，生产日期，效期，来源工厂跟库存共享完全一致，一般A99 ;点击添加明细，分配，发货。

        }





        return "";
    }
}
