package com.opr.oders.pojo.yw.result;

import java.util.List;

/**
 * @Auther: gina
 * @Date: 2024-04-17
 * @Description:
 */
public class SubOrderDetaiResult {
    private SubOrderDelivery orderDelivery;
    private boolean showReceiveGoods;
    private List<SubExceptionOrder> exceptionOrderList;
    private List<SubOrderJoin> orderJoinList;
    private boolean showInvoice;
    private List<SubOrderDistribute> orderDistributeList;
    private boolean showRefundDeposit;
    private Integer fulfillmentOrderId;//1012407875766508
    private SubOrderDetailShow orderDetailShow;
    private List<SubOrderLive> orderLiveList;
    private List<SubOrderInvoice> orderInvoiceList;
    private boolean showDeveloper;
    private SubOrderBase orderBase;

    public SubOrderDelivery getOrderDelivery() {
        return orderDelivery;
    }

    public void setOrderDelivery(SubOrderDelivery orderDelivery) {
        this.orderDelivery = orderDelivery;
    }

    public boolean isShowReceiveGoods() {
        return showReceiveGoods;
    }

    public void setShowReceiveGoods(boolean showReceiveGoods) {
        this.showReceiveGoods = showReceiveGoods;
    }

    public List<SubExceptionOrder> getExceptionOrderList() {
        return exceptionOrderList;
    }

    public void setExceptionOrderList(List<SubExceptionOrder> exceptionOrderList) {
        this.exceptionOrderList = exceptionOrderList;
    }

    public List<SubOrderJoin> getOrderJoinList() {
        return orderJoinList;
    }

    public void setOrderJoinList(List<SubOrderJoin> orderJoinList) {
        this.orderJoinList = orderJoinList;
    }

    public boolean isShowInvoice() {
        return showInvoice;
    }

    public void setShowInvoice(boolean showInvoice) {
        this.showInvoice = showInvoice;
    }

    public List<SubOrderDistribute> getOrderDistributeList() {
        return orderDistributeList;
    }

    public void setOrderDistributeList(List<SubOrderDistribute> orderDistributeList) {
        this.orderDistributeList = orderDistributeList;
    }

    public boolean isShowRefundDeposit() {
        return showRefundDeposit;
    }

    public void setShowRefundDeposit(boolean showRefundDeposit) {
        this.showRefundDeposit = showRefundDeposit;
    }

    public Integer getFulfillmentOrderId() {
        return fulfillmentOrderId;
    }

    public void setFulfillmentOrderId(Integer fulfillmentOrderId) {
        this.fulfillmentOrderId = fulfillmentOrderId;
    }

    public SubOrderDetailShow getOrderDetailShow() {
        return orderDetailShow;
    }

    public void setOrderDetailShow(SubOrderDetailShow orderDetailShow) {
        this.orderDetailShow = orderDetailShow;
    }

    public List<SubOrderLive> getOrderLiveList() {
        return orderLiveList;
    }

    public void setOrderLiveList(List<SubOrderLive> orderLiveList) {
        this.orderLiveList = orderLiveList;
    }

    public List<SubOrderInvoice> getOrderInvoiceList() {
        return orderInvoiceList;
    }

    public void setOrderInvoiceList(List<SubOrderInvoice> orderInvoiceList) {
        this.orderInvoiceList = orderInvoiceList;
    }

    public boolean isShowDeveloper() {
        return showDeveloper;
    }

    public void setShowDeveloper(boolean showDeveloper) {
        this.showDeveloper = showDeveloper;
    }

    public SubOrderBase getOrderBase() {
        return orderBase;
    }

    public void setOrderBase(SubOrderBase orderBase) {
        this.orderBase = orderBase;
    }
}
