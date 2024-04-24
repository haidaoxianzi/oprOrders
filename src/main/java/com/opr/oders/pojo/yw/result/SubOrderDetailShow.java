package com.opr.oders.pojo.yw.result;

import java.util.List;

/**
 * @Auther: gina
 * @Date: 2024-04-17
 * @Description:
 */
public class SubOrderDetailShow {
    // "2024/03/18 09:24:01"
    private String finishTime;
    //"￥1.00"
    private String orderTotalAfterPrice;
    private Integer itemQuantity;
    private List<SubOrderItem> orderItemList;
    //    "￥1.00"
    private String orderTotalPrice;
    //    "￥0.00"
    private String freight;
    //    "-￥0.00"
    private String discountPrice;
    //    "2000603864"
    private String storeId;
    //    "2024/03/18 09:24:01"
    private String createTime;
    //    "-0积分"
    private String discountIntegral;
    private SubOrderBuyer orderBuyer;
    private String storeName;

    public String getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime;
    }

    public String getOrderTotalAfterPrice() {
        return orderTotalAfterPrice;
    }

    public void setOrderTotalAfterPrice(String orderTotalAfterPrice) {
        this.orderTotalAfterPrice = orderTotalAfterPrice;
    }

    public Integer getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(Integer itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public List<SubOrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<SubOrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    public String getOrderTotalPrice() {
        return orderTotalPrice;
    }

    public void setOrderTotalPrice(String orderTotalPrice) {
        this.orderTotalPrice = orderTotalPrice;
    }

    public String getFreight() {
        return freight;
    }

    public void setFreight(String freight) {
        this.freight = freight;
    }

    public String getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(String discountPrice) {
        this.discountPrice = discountPrice;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getDiscountIntegral() {
        return discountIntegral;
    }

    public void setDiscountIntegral(String discountIntegral) {
        this.discountIntegral = discountIntegral;
    }

    public SubOrderBuyer getOrderBuyer() {
        return orderBuyer;
    }

    public void setOrderBuyer(SubOrderBuyer orderBuyer) {
        this.orderBuyer = orderBuyer;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }
}
