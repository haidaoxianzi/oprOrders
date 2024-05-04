package com.opr.oders.OMSsendgoods.impl;

import com.opr.oders.OMSsendgoods.service.DaCangSendGoodsService;
import com.opr.oders.OMSsendgoods.service.ManalFilterStoreService;
import com.opr.oders.OMSsendgoods.service.SendGoodsOrderRelationsService;
import com.opr.oders.pojo.yw.result.*;
import com.opr.oders.pojo.yw.rsenum.SourceFacotryEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Auther: gina
 * @Date: 2024-04-17
 * @Description:苏州电商仓 todo 123wq 来一笔订单先确认是哪个大仓，通过抽象模式+适配器模式 实现
 */
@Service
@Slf4j
public class SuzhouDSImpl implements DaCangSendGoodsService {

    @Resource
    private ManalFilterStoreService manalFilterStoreService;

    @Resource
    private SendGoodsOrderRelationsService sendGoodsOrderRelationsService;

    //库存共享端数据mock  todo 后续调接口
    QueryWmsPhysicalInventoryResp genQueryWmsPhysicalInventoryResp() {
        QueryWmsPhysicalInventoryResp qWmsPhysicalInventoryResp = new QueryWmsPhysicalInventoryResp();
        List<SubWmsPhysicalInventory> result = new ArrayList<>();
        SubWmsPhysicalInventory store1 = new SubWmsPhysicalInventory("222", "O20240221", "2024-02-02", "2026-02-01", "source_facotry", "10005");
        SubWmsPhysicalInventory store2 = new SubWmsPhysicalInventory("112", "O20240202", "2024-02-02", "2025-02-01", "source_facotry", "10005");
        SubWmsPhysicalInventory store3 = new SubWmsPhysicalInventory("103", "BF001", "2024-03-26", "2025-03-25", "source_facotry", "10005");
        SubWmsPhysicalInventory store4 = new SubWmsPhysicalInventory("123000", "e1711372791", "2024-01-01", "2025-12-21", "source_facotry", "10013");
        SubWmsPhysicalInventory store5 = new SubWmsPhysicalInventory("4099986", "BF001", "2021-05-10", "2099-05-10", "source_facotry", "10005");
        SubWmsPhysicalInventory store6 = new SubWmsPhysicalInventory("69937", "O20240201", "2024-02-01", "2026-01-31", "source_facotry", "12661");
        SubWmsPhysicalInventory store7 = new SubWmsPhysicalInventory("77435", "O20240202", "2024-02-02", "2026-02-01", "source_facotry", "10005");

        result.add(store1);
        result.add(store2);
        result.add(store3);
        result.add(store4);
        result.add(store5);
        result.add(store6);
        result.add(store7);

        //按照可使用数据降序,过滤掉BF开头的批号
        result = result.stream().filter(o -> !o.getBatchNumber().startsWith("BF")).sorted(Comparator.comparing(SubWmsPhysicalInventory::getAvailableQuantity).reversed()).collect(Collectors.toList());

        //按照可使用数据降序
        // result = result.stream().sorted(Comparator.comparing(SubWmsPhysicalInventory::getAvailableQuantity).reversed()).collect(Collectors.toList());

        qWmsPhysicalInventoryResp.setResult(result);
        qWmsPhysicalInventoryResp.setSuccess(true);
        qWmsPhysicalInventoryResp.setTotal(result.size());

        return qWmsPhysicalInventoryResp;
    }

    /*
     * 正向发货---出库列表查询
     * */
    public void sendGoodsQuery() {
        //1、出库列表查询 已分配订单：， ，9300000959120101048,9300000959160849979
        //业务号
        String orderId = "";
        String warehouseId = "SZDS";
        String todayFormate = "2024-04-01";
        List<SubOrderSendGoods> sendGoodsOrderList = sendGoodsOrderRelationsService.getSendGoodsOrderList(orderId, warehouseId, todayFormate);
        //String orderNo = "SZSOX8240424000130";
        if (CollectionUtils.isEmpty(sendGoodsOrderList)) {
            log.info("sendGoodsOrderList is null ");
            return;
        }
        for (SubOrderSendGoods subOrderSendGoods : sendGoodsOrderList) {
            //2、出库订单明细列表 todo 查明细列表，比如多个物料的情况，需要遍历查人工筛选库存
            List<SubOutOrderMingXiDetail> wmsOutOrderMingXiDetailList = sendGoodsOrderRelationsService.getSendGoodsOrderMingXiDetailList(subOrderSendGoods.getOrderNo(), warehouseId);
            if (CollectionUtils.isEmpty(wmsOutOrderMingXiDetailList)) {
                log.info("wms出库订单明细列表为null ");
                return;
            }
            for (int i = 0; i < wmsOutOrderMingXiDetailList.size(); i++) {
                SubOutOrderMingXiDetail outOrderMingXiDetail = wmsOutOrderMingXiDetailList.get(i);
                //订货数
                int dingGoodCount = outOrderMingXiDetail.getQtyOrdered_each();
                String orderNo = outOrderMingXiDetail.getOrderNo();
                String sku = outOrderMingXiDetail.getSku();
                String warehouseId1 = outOrderMingXiDetail.getWarehouseId();
                int orderLineNo = outOrderMingXiDetail.getOrderLineNo();
                String customerId = outOrderMingXiDetail.getCustomerId();
                //对比库存共享和wms人工筛选库存批次信息，选中一个并编辑待分配，得到的对象是 添加分配明细对象的入参数

                SubWMSGoodsStoreInfo wmsGoodsStoreInfo = compareBatchInfo(dingGoodCount, orderNo, warehouseId1, sku);
                //按订单行分配
                boolean isDistributionDone = sendGoodsOrderRelationsService.addDistributionDetail(wmsGoodsStoreInfo, warehouseId, orderNo, orderLineNo, customerId, sku, dingGoodCount);
                log.info("orderNo:{},orderLineNo:{},订单是否分配完成？{} ,", orderNo, orderLineNo, isDistributionDone);
                //发货->按订单行
                if (isDistributionDone) {
                    boolean sendGoodsByOrderLineIsDone = sendGoodsOrderRelationsService.sendGoodsByOrderLine(warehouseId, orderNo, orderLineNo);
                    log.info("orderNo:{},orderLineNo:{},此订单行是否发货完成？{} ,", orderNo, orderLineNo, sendGoodsByOrderLineIsDone);
                }
            }
        }

    }

    //对选中的批号进行  ； 2.2 改需要数量==订货数

    /**
     * 出库->发运订单->明细列表里，单条处理对比批号信息
     * 【对比库存共享和wms人工筛选库存批次信息，选中一个并编辑待分配，得到的对象是 添加分配明细对象的入参数】
     */
    public SubWMSGoodsStoreInfo compareBatchInfo(int dingGoodCount, String orderNo, String warehouseId, String sku) {
        log.info("compareBatchInfo param:{},{},{},{}", dingGoodCount, orderNo, warehouseId, sku);
        //3、人工筛选库存
        List<SubWMSGoodsStoreInfo> wmsGoodsStoreInfoList = manalFilterStoreService.manalFilterStore(orderNo, warehouseId, sku);
        if (CollectionUtils.isEmpty(wmsGoodsStoreInfoList)) {
            return null;
        }
        //4 查看库存共享端 【批号，生产日期，效期，来源工厂】
        //todo 调试 【苏州线上仓做条件】查库存共享端
        //mock 查库存共享端结果集：检查批号，生产，效期，来源工厂 wms跟库存共享比对，剩余库存比对 要高于需要待分配的库存,todo已经按照可使用数量降序排序
        QueryWmsPhysicalInventoryResp qStoreShare = genQueryWmsPhysicalInventoryResp();
        if (null == qStoreShare.getTotal()) {
            log.error("库存共享端暂无可用批号");
            return null;
        }
        List<SubWmsPhysicalInventory> storeShareList = qStoreShare.getResult();


        // 3、双循环逻辑：参照库存共享端和wms交叉的批号信息，按可用库存降序，选中一条【可用库存高于需要待分配数量的】人工筛选库存记录，来添加分配明细
        // 3.1、外层循环遍历库存共享批号列表
        for (int i = 0; i < qStoreShare.getTotal(); i++) {
            SubWmsPhysicalInventory storeShareDetail = storeShareList.get(i);
            //可用库存
            Integer availableQuantity = Integer.valueOf(storeShareDetail.getAvailableQuantity());
            //批号
            String batchNumber = storeShareDetail.getBatchNumber();
            //生产日期 "2021-05-10"
            String produceTimeDate = storeShareDetail.getProduceTimeDate();
            //生产效期 "2099-05-10"
            String deadlineTimeDate = storeShareDetail.getDeadlineTimeDate();
            if (null == storeShareDetail.getBatchExtProperty() || StringUtils.isEmpty(storeShareDetail.getBatchExtProperty().getCode())
                    || !storeShareDetail.getBatchExtProperty().getCode().equals("source_facotry") || StringUtils.isEmpty(storeShareDetail.getBatchExtProperty().getValue()))
                continue;
            // eg：1005
            String sourceFacotry = storeShareDetail.getBatchExtProperty().getValue();

            //3.2内层循环遍历wms人工筛选库存列表
            for (int j = 0; j < wmsGoodsStoreInfoList.size(); j++) {
                SubWMSGoodsStoreInfo wmsStoreInfo = wmsGoodsStoreInfoList.get(j);

                //库存数量
                //private Integer fmQty;
                //可用数量
                //private Integer qtyAvailed;
                //需求数量
                //private Integer qtySelect;


                if (wmsStoreInfo.getLotAtt01().equals(produceTimeDate) && wmsStoreInfo.getLotAtt02().equals(deadlineTimeDate) &&
                        wmsStoreInfo.getLotAtt05().equals(batchNumber) && wmsStoreInfo.getLotAtt10().equals(SourceFacotryEnum.getCodeStrByCode(sourceFacotry))) {
                    //需要数量小于当前wms可用数量，同时也小于 库存共享的可用数量
                    if (availableQuantity >= dingGoodCount && wmsStoreInfo.getQtyAvailed() >= dingGoodCount) {
                        //需求数量
                        wmsStoreInfo.setQtySelect(dingGoodCount);
                        //得到一条人工筛选库存,且修改需求数量，赋值为待分配数量
                        return wmsStoreInfo;
                    }
                }
            }
        }
        return null;
    }


    /**
     * 逆向发货
     */
    public void sendGoodsReverse() {

    }
}
