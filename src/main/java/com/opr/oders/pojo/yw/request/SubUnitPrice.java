package com.opr.oders.pojo.yw.request;

import java.util.List;

/**
 * @Auther: gina
 * @Date: 2024-04-15
 * @Description:
 */
public class SubUnitPrice {
    private List<SubAssetPrices> assetPrices;
    private SubCurrencyPrice currencyPrice;

    public List<SubAssetPrices> getAssetPrices() {
        return assetPrices;
    }

    public void setAssetPrices(List<SubAssetPrices> assetPrices) {
        this.assetPrices = assetPrices;
    }

    public SubCurrencyPrice getCurrencyPrice() {
        return currencyPrice;
    }

    public void setCurrencyPrice(SubCurrencyPrice currencyPrice) {
        this.currencyPrice = currencyPrice;
    }
}
