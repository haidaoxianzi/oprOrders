package com.opr.oders.pojo.yw.result;

/**
 * @Auther: gina
 * @Date: 2024-04-17
 * @Description:
 */
public class SubOrderInvoice {
    //"1.00"
    private String totalPrice;
    //"NO_APPLY"
    private String status;

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
