package com.opr.oders.pojo.yw.request;

import lombok.Data;

/**
 * @Auther: gina
 * @Date: 2024-04-15
 * @Description:
 */
public class SubTotalItemDiscountFee {
    private SubCurrencyPrice currencyPrice=new SubCurrencyPrice();


    public SubCurrencyPrice getCurrencyPrice() {
        return currencyPrice;
    }

    public void setCurrencyPrice(SubCurrencyPrice currencyPrice) {
        this.currencyPrice = currencyPrice;
    }
}
