package com.opr.oders.pojo.yw.result;

import com.opr.oders.pojo.yw.request.SubCurrencyPrice;
import com.opr.oders.pojo.yw.request.SubUnitPrice;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @Auther: gina
 * @Date: 2024-04-15
 * @Description:
 */

public class SubOrderPriceDTO {
    private SubUnitPrice totalShopDiscountFee;
    private SubUnitPrice totalCrossShopDiscountFee;
    private SubCurrencyPrice totalAssetDiscountFee;
    private SubUnitPrice totalItemDiscountFee;
    private SubUnitPrice totalProductFee;
    private SubCurrencyPrice totalShippingFee;
    private SubUnitPrice totalActualFee;
    private List<Object> stagePriceDTOList;

    public SubUnitPrice getTotalShopDiscountFee() {
        return totalShopDiscountFee;
    }

    public void setTotalShopDiscountFee(SubUnitPrice totalShopDiscountFee) {
        this.totalShopDiscountFee = totalShopDiscountFee;
    }

    public SubUnitPrice getTotalCrossShopDiscountFee() {
        return totalCrossShopDiscountFee;
    }

    public void setTotalCrossShopDiscountFee(SubUnitPrice totalCrossShopDiscountFee) {
        this.totalCrossShopDiscountFee = totalCrossShopDiscountFee;
    }

    public SubCurrencyPrice getTotalAssetDiscountFee() {
        return totalAssetDiscountFee;
    }

    public void setTotalAssetDiscountFee(SubCurrencyPrice totalAssetDiscountFee) {
        this.totalAssetDiscountFee = totalAssetDiscountFee;
    }

    public SubUnitPrice getTotalItemDiscountFee() {
        return totalItemDiscountFee;
    }

    public void setTotalItemDiscountFee(SubUnitPrice totalItemDiscountFee) {
        this.totalItemDiscountFee = totalItemDiscountFee;
    }

    public SubUnitPrice getTotalProductFee() {
        return totalProductFee;
    }

    public void setTotalProductFee(SubUnitPrice totalProductFee) {
        this.totalProductFee = totalProductFee;
    }

    public SubCurrencyPrice getTotalShippingFee() {
        return totalShippingFee;
    }

    public void setTotalShippingFee(SubCurrencyPrice totalShippingFee) {
        this.totalShippingFee = totalShippingFee;
    }

    public SubUnitPrice getTotalActualFee() {
        return totalActualFee;
    }

    public void setTotalActualFee(SubUnitPrice totalActualFee) {
        this.totalActualFee = totalActualFee;
    }

    public List<Object> getStagePriceDTOList() {
        return stagePriceDTOList;
    }

    public void setStagePriceDTOList(List<Object> stagePriceDTOList) {
        this.stagePriceDTOList = stagePriceDTOList;
    }
}
