package com.opr.oders.pojo.yw.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Auther: gina
 * @Date: 2024-04-15
 * @Description:
 */

public class SubCurrencyPrice {
    private Double amount = 0d;
    private Double cent = 0d;
    private String currency = "CNY";

    public SubCurrencyPrice(Double amount, Double cent, String currency) {
        this.amount = amount;
        this.cent = cent;
        this.currency = currency;
    }

    public SubCurrencyPrice() {
        this.amount = 0d;
        this.cent = 0d;
        this.currency = "CNY";
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getCent() {
        return cent;
    }

    public void setCent(Double cent) {
        this.cent = cent;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
