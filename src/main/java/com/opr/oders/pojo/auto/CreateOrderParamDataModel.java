package com.opr.oders.pojo.auto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @Auther: gina
 * @Date: 2024-04-12
 * @Description：自定义参数化模型 创单接口：参数化数据模型
 */

@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderParamDataModel {

    public CreateOrderParamDataModel(String addressId, String buyerId, String originalOutId, String outId, String outId1, String openId, String mdStoreId
            , String dealerMerchantId, String dealerStoreId, String mdMerchantId, String offLineShopId, String distributionModel, String offLineDealerId, String firstDeveloperName
            , String categoryId, String goodsTag, String itemId, Integer orderLineType, Integer quantity, String skuId, String selectedPaymentMethodCode
            , Double amount,String provinceCode ) {
        this.addressId = addressId;
        this.buyerId = buyerId;
        this.originalOutId = originalOutId;
        this.outId = outId;
        this.outId1 = outId1;
        this.openId = openId;
        this.mdStoreId = mdStoreId;
        this.dealerMerchantId = dealerMerchantId;
        this.dealerStoreId = dealerStoreId;
        this.mdMerchantId = mdMerchantId;
        this.offLineShopId = offLineShopId;
        this.distributionModel = distributionModel;
        this.offLineDealerId = offLineDealerId;
        this.firstDeveloperName = firstDeveloperName;
        this.categoryId = categoryId;
        this.goodsTag = goodsTag;
        this.itemId = itemId;
        this.orderLineType = orderLineType;
        this.quantity = quantity;
        this.skuId = skuId;
        this.selectedPaymentMethodCode = selectedPaymentMethodCode;
        this.amount = amount;
        this.provinceCode=provinceCode;

    }

    private String addressId;
    private String buyerId;
    private String originalOutId;
    private String outId;
    private String outId1;
    private String openId;

    private String mdStoreId;
    private String dealerStoreId;
    private String mdMerchantId;
    private String offLineShopId;
    private String distributionModel;
    private String offLineDealerId;
    private String firstDeveloperName;
    private String categoryId;
    private String goodsTag;
    private String itemId;
    private Integer orderLineType;
    private Integer quantity;
    private String skuId;
    private String selectedPaymentMethodCode;
    private Double amount=0d;
    private String provinceCode;



    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getSelectedPaymentMethodCode() {
        return selectedPaymentMethodCode;
    }

    public void setSelectedPaymentMethodCode(String selectedPaymentMethodCode) {
        this.selectedPaymentMethodCode = selectedPaymentMethodCode;
    }

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getOrderLineType() {
        return orderLineType;
    }

    public void setOrderLineType(Integer orderLineType) {
        this.orderLineType = orderLineType;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getGoodsTag() {
        return goodsTag;
    }

    public void setGoodsTag(String goodsTag) {
        this.goodsTag = goodsTag;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getFirstDeveloperName() {
        return firstDeveloperName;
    }

    public void setFirstDeveloperName(String firstDeveloperName) {
        this.firstDeveloperName = firstDeveloperName;
    }

    public String getOffLineDealerId() {
        return offLineDealerId;
    }

    public void setOffLineDealerId(String offLineDealerId) {
        this.offLineDealerId = offLineDealerId;
    }

    public String getDistributionModel() {
        return distributionModel;
    }

    public void setDistributionModel(String distributionModel) {
        this.distributionModel = distributionModel;
    }

    public String getOffLineShopId() {
        return offLineShopId;
    }

    public void setOffLineShopId(String offLineShopId) {
        this.offLineShopId = offLineShopId;
    }

    public String getMdMerchantId() {
        return mdMerchantId;
    }

    public void setMdMerchantId(String mdMerchantId) {
        this.mdMerchantId = mdMerchantId;
    }

    public String getDealerStoreId() {
        return dealerStoreId;
    }

    public void setDealerStoreId(String dealerStoreId) {
        this.dealerStoreId = dealerStoreId;
    }

    public String getDealerMerchantId() {
        return dealerMerchantId;
    }

    public void setDealerMerchantId(String dealerMerchantId) {
        this.dealerMerchantId = dealerMerchantId;
    }

    private String dealerMerchantId;

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public String getOriginalOutId() {
        return originalOutId;
    }

    public void setOriginalOutId(String originalOutId) {
        this.originalOutId = originalOutId;
    }

    public String getOutId() {
        return outId;
    }

    public void setOutId(String outId) {
        this.outId = outId;
    }

    public String getOutId1() {
        return outId1;
    }

    public void setOutId1(String outId1) {
        this.outId1 = outId1;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getMdStoreId() {
        return mdStoreId;
    }

    public void setMdStoreId(String mdStoreId) {
        this.mdStoreId = mdStoreId;
    }
}
