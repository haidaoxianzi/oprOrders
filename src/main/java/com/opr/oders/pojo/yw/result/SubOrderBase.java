package com.opr.oders.pojo.yw.result;

import java.util.List;

/**
 * @Auther: gina
 * @Date: 2024-04-17
 * @Description:
 */
public class SubOrderBase {
    private boolean sendGoodsFirst;
    private String crossSaleStatus;

    //"com.feihe.youxuan"
    private String bizCode;
    //    "9300000943795606279"
    private String tradeOrderId;
    private List<SubOrderStatus> orderStatusList;
    //    "TO_SEND"
    private String payStatusCode;
    //"正常订单"
    private String crossSaleStatusName;
    private boolean showRefundDeposit;
    private boolean delayGoods;
    private SubSubOrderBaseFeatures features;
    private String merchantId;
    private boolean enableReverse;

    private List<SubOrderIapJoin> orderIapJoinList;
    //"201"
    private String channelCode;
    //    ["普通订单","导入订单"]
    private String[] orderTagList;
    //"星鲜优选渠道"
    private String orderSource;
    //"待发货"
    private String payStatusDesc;
    //"1.0"
    private String weight;
    //"32879762645345522546"
    private String externalOrderId;
    //["0","260"]
    private String[] orderTags;
    private boolean isSecondTermOrder;
    //    "kg"
    private String weightUnit;

    public boolean isSendGoodsFirst() {
        return sendGoodsFirst;
    }

    public void setSendGoodsFirst(boolean sendGoodsFirst) {
        this.sendGoodsFirst = sendGoodsFirst;
    }

    public String getCrossSaleStatus() {
        return crossSaleStatus;
    }

    public void setCrossSaleStatus(String crossSaleStatus) {
        this.crossSaleStatus = crossSaleStatus;
    }

    public String getBizCode() {
        return bizCode;
    }

    public void setBizCode(String bizCode) {
        this.bizCode = bizCode;
    }

    public String getTradeOrderId() {
        return tradeOrderId;
    }

    public void setTradeOrderId(String tradeOrderId) {
        this.tradeOrderId = tradeOrderId;
    }

    public List<SubOrderStatus> getOrderStatusList() {
        return orderStatusList;
    }

    public void setOrderStatusList(List<SubOrderStatus> orderStatusList) {
        this.orderStatusList = orderStatusList;
    }

    public String getPayStatusCode() {
        return payStatusCode;
    }

    public void setPayStatusCode(String payStatusCode) {
        this.payStatusCode = payStatusCode;
    }

    public String getCrossSaleStatusName() {
        return crossSaleStatusName;
    }

    public void setCrossSaleStatusName(String crossSaleStatusName) {
        this.crossSaleStatusName = crossSaleStatusName;
    }

    public boolean isShowRefundDeposit() {
        return showRefundDeposit;
    }

    public void setShowRefundDeposit(boolean showRefundDeposit) {
        this.showRefundDeposit = showRefundDeposit;
    }

    public boolean isDelayGoods() {
        return delayGoods;
    }

    public void setDelayGoods(boolean delayGoods) {
        this.delayGoods = delayGoods;
    }

    public SubSubOrderBaseFeatures getFeatures() {
        return features;
    }

    public void setFeatures(SubSubOrderBaseFeatures features) {
        this.features = features;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public boolean isEnableReverse() {
        return enableReverse;
    }

    public void setEnableReverse(boolean enableReverse) {
        this.enableReverse = enableReverse;
    }

    public List<SubOrderIapJoin> getOrderIapJoinList() {
        return orderIapJoinList;
    }

    public void setOrderIapJoinList(List<SubOrderIapJoin> orderIapJoinList) {
        this.orderIapJoinList = orderIapJoinList;
    }

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
    }

    public String[] getOrderTagList() {
        return orderTagList;
    }

    public void setOrderTagList(String[] orderTagList) {
        this.orderTagList = orderTagList;
    }

    public String getOrderSource() {
        return orderSource;
    }

    public void setOrderSource(String orderSource) {
        this.orderSource = orderSource;
    }

    public String getPayStatusDesc() {
        return payStatusDesc;
    }

    public void setPayStatusDesc(String payStatusDesc) {
        this.payStatusDesc = payStatusDesc;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getExternalOrderId() {
        return externalOrderId;
    }

    public void setExternalOrderId(String externalOrderId) {
        this.externalOrderId = externalOrderId;
    }

    public String[] getOrderTags() {
        return orderTags;
    }

    public void setOrderTags(String[] orderTags) {
        this.orderTags = orderTags;
    }

    public boolean isSecondTermOrder() {
        return isSecondTermOrder;
    }

    public void setSecondTermOrder(boolean secondTermOrder) {
        isSecondTermOrder = secondTermOrder;
    }

    public String getWeightUnit() {
        return weightUnit;
    }

    public void setWeightUnit(String weightUnit) {
        this.weightUnit = weightUnit;
    }
}
