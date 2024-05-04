package com.opr.oders.pojo.yw.result;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.platform.commons.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: gina
 * @Date: 2024-04-26
 * @Description:
 */
@Slf4j
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubOutOrderMingXiDetail {

    /**
     * 订单发运单明细的行号
     * 作为人工筛选库存入参
     * eg：1
     */
    private int orderLineNo;

    /**
     * eg："00":表示创建订单
     */
    private String lineStatus;

    /**
     * eg：1
     */
    private int qtyOrdered;

    /**
     * 订货数
     * eg：1
     */
    private int qtyOrdered_each;

    /**
     * eg："1"
     */
    private String dedi11;

    /**
     * eg："FEIHE"
     */
    private String organizationId;
    /**
     * eg： "SZDS"
     */
    private String warehouseId;
    /**
     * eg: "SZSOX8240424000130"
     */
    private String orderNo;

    /**
     * eg: "12661"
     */
    private String customerId;
    /**
     * eg:  "XM001"
     */
    private String sku;

    /**
     * eg: "61-XADSA01"
     */
    private String rotationId;
    /**
     * eg:  "61-XADSA01"
     */
    private String softAllocationRule;

    /**
     * eg: "N"
     */
    private String erpCancelFlag;

    /**
     * eg: "Y"
     */
    private String commingleSku;
    /**
     * eg: "Y"
     */
    private String oneStepAllocation;

    /**
     * eg: "61-ZABSANF"
     */
    private String lotId;

    /**
     * eg: "2024-04-24 16:50:12"
     */
    private String orderTime;


    /**
     * eg:  1
     */
    private int O_MAINKEY;


    /**
     * 将 jsonArray  转 对象
     * jsonObj元素跟对象元素部分匹配
     *
     * @param jsonArray
     * @return
     * @throws Exception
     */
    public static List<SubOutOrderMingXiDetail> jsonArray2Bean(String jsonArray) {
        try {
            if (StringUtils.isBlank(jsonArray)) {
                throw new Exception("参数为空");
            }

            JSONArray jsonArr = new JSONArray(jsonArray);
            List<SubOutOrderMingXiDetail> sendOrderMingXiDetailList = new ArrayList<>();
            for (int i = 0; i < jsonArr.length(); i++) {
                JSONObject jsonObj = jsonArr.getJSONObject(i);
                int orderLineNo = jsonObj.getInt("orderLineNo");
                String lineStatus = jsonObj.getString("lineStatus");
                if(!"00".equals(lineStatus)){
                    continue;
                }
                int qtyOrdered = jsonObj.getInt("qtyOrdered");
                int qtyOrdered_each = jsonObj.getInt("qtyOrdered_each");//订货数
                String dedi11 = jsonObj.getString("dedi11");

                String organizationId = jsonObj.getString("organizationId");
                String warehouseId = jsonObj.getString("warehouseId");
                String orderNo = jsonObj.getString("orderNo");
                String customerId = jsonObj.getString("customerId");
                String sku = jsonObj.getString("sku");
                String rotationId = jsonObj.getString("rotationId");

                String softAllocationRule = jsonObj.getString("softAllocationRule");
                String erpCancelFlag = jsonObj.getString("erpCancelFlag");
                if (!"N".equals(erpCancelFlag)) continue;
                String commingleSku = jsonObj.getString("commingleSku");
                String oneStepAllocation = jsonObj.getString("oneStepAllocation");

                String lotId = jsonObj.getString("lotId");
                String orderTime = jsonObj.getString("orderTime");
                int mainKey = jsonObj.getInt("O_MAINKEY");


                SubOutOrderMingXiDetail sendOrderMingXiDetail = new SubOutOrderMingXiDetail(orderLineNo, lineStatus, qtyOrdered, qtyOrdered_each,
                        dedi11, organizationId, warehouseId, orderNo, customerId, sku, rotationId, softAllocationRule, erpCancelFlag,
                        commingleSku, oneStepAllocation, lotId, orderTime, mainKey);

                sendOrderMingXiDetailList.add(sendOrderMingXiDetail);

            }
            return sendOrderMingXiDetailList;
        } catch (Exception e) {
            log.info("获取数据出现异常：" + e.getMessage() + ";" + jsonArray);
        }
        return null;
    }
}
