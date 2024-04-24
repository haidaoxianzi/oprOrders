package com.opr.oders.pojo.yw.result;

import java.util.List;

/**
 * @Auther: gina
 * @Date: 2024-04-17
 * @Description:
 */
public class SubOrderItem {
    private boolean showAfterSale;
    private String deliveryStatusDesc;
    private List<SubDiscounts> discountsList;
    //"苏州电商仓"
    private String warehouseName;
    private String itemName;
    private String subOrderId;
    //    "0"
    private String integral;
    private boolean isGiftGoods;
    //    "TO_SEND"
    private String subOrderStatus;
    private boolean launchAfterSale;
    private String skuId;
    //   "https://fh01-uat-bucket.oss-cn-beijing.aliyuncs.com/xxyx-fn_bp_bs/item-img/6d9ad990-f6a4-2c0d-37a0855b8e718186.jpg",
    private String itemImgUrl;
    private String skuTitle;
    private Integer quantity;
    //"￥1.00"
    private String discountsAfterBargainPrice;
    //    "￥1.00"
    private String costPrice;
    private String weight;
    //    "TO_SEND"
    private String deliveryStatusCode;

    //"￥1.00"
    private String discountsAfterPrice;
    //    "1"
    private String goodsType;
    //"￥1.00"
    private String discountsBeforePrice;
    private boolean isCombGoods;
    //"XM001"
    private String skuCode;
    //   "kg"
    private String weightUnit;

    public boolean isShowAfterSale() {
        return showAfterSale;
    }

    public void setShowAfterSale(boolean showAfterSale) {
        this.showAfterSale = showAfterSale;
    }

    public String getDeliveryStatusDesc() {
        return deliveryStatusDesc;
    }

    public void setDeliveryStatusDesc(String deliveryStatusDesc) {
        this.deliveryStatusDesc = deliveryStatusDesc;
    }

    public List<SubDiscounts> getDiscountsList() {
        return discountsList;
    }

    public void setDiscountsList(List<SubDiscounts> discountsList) {
        this.discountsList = discountsList;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getSubOrderId() {
        return subOrderId;
    }

    public void setSubOrderId(String subOrderId) {
        this.subOrderId = subOrderId;
    }

    public String getIntegral() {
        return integral;
    }

    public void setIntegral(String integral) {
        this.integral = integral;
    }

    public boolean isGiftGoods() {
        return isGiftGoods;
    }

    public void setGiftGoods(boolean giftGoods) {
        isGiftGoods = giftGoods;
    }

    public String getSubOrderStatus() {
        return subOrderStatus;
    }

    public void setSubOrderStatus(String subOrderStatus) {
        this.subOrderStatus = subOrderStatus;
    }

    public boolean isLaunchAfterSale() {
        return launchAfterSale;
    }

    public void setLaunchAfterSale(boolean launchAfterSale) {
        this.launchAfterSale = launchAfterSale;
    }

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public String getItemImgUrl() {
        return itemImgUrl;
    }

    public void setItemImgUrl(String itemImgUrl) {
        this.itemImgUrl = itemImgUrl;
    }

    public String getSkuTitle() {
        return skuTitle;
    }

    public void setSkuTitle(String skuTitle) {
        this.skuTitle = skuTitle;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getDiscountsAfterBargainPrice() {
        return discountsAfterBargainPrice;
    }

    public void setDiscountsAfterBargainPrice(String discountsAfterBargainPrice) {
        this.discountsAfterBargainPrice = discountsAfterBargainPrice;
    }

    public String getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(String costPrice) {
        this.costPrice = costPrice;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getDeliveryStatusCode() {
        return deliveryStatusCode;
    }

    public void setDeliveryStatusCode(String deliveryStatusCode) {
        this.deliveryStatusCode = deliveryStatusCode;
    }

    public String getDiscountsAfterPrice() {
        return discountsAfterPrice;
    }

    public void setDiscountsAfterPrice(String discountsAfterPrice) {
        this.discountsAfterPrice = discountsAfterPrice;
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }

    public String getDiscountsBeforePrice() {
        return discountsBeforePrice;
    }

    public void setDiscountsBeforePrice(String discountsBeforePrice) {
        this.discountsBeforePrice = discountsBeforePrice;
    }

    public boolean isCombGoods() {
        return isCombGoods;
    }

    public void setCombGoods(boolean combGoods) {
        isCombGoods = combGoods;
    }

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    public String getWeightUnit() {
        return weightUnit;
    }

    public void setWeightUnit(String weightUnit) {
        this.weightUnit = weightUnit;
    }
}
