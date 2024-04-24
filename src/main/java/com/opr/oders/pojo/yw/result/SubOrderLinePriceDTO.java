package com.opr.oders.pojo.yw.result;

import com.opr.oders.pojo.yw.request.SubCurrencyPrice;
import com.opr.oders.pojo.yw.request.SubUnitPrice;
import lombok.Getter;
import lombok.Setter;

/**
 * @Auther: gina
 * @Date: 2024-04-15
 * @Description:
 */

public class SubOrderLinePriceDTO {
    private SubUnitPrice unitPrice;
    private SubUnitPrice totalItemDiscountFee;
    private Integer quantity;
    private SubUnitPrice promotionUnitPrice;
    private SubUnitPrice totalShareCrossShopDiscountFee;
    private SubCurrencyPrice totalSharedAssetDiscountFee;
    private SubUnitPrice totalShareShopDiscountFee;

    public SubUnitPrice getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(SubUnitPrice unitPrice) {
        this.unitPrice = unitPrice;
    }

    public SubUnitPrice getTotalItemDiscountFee() {
        return totalItemDiscountFee;
    }

    public void setTotalItemDiscountFee(SubUnitPrice totalItemDiscountFee) {
        this.totalItemDiscountFee = totalItemDiscountFee;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public SubUnitPrice getPromotionUnitPrice() {
        return promotionUnitPrice;
    }

    public void setPromotionUnitPrice(SubUnitPrice promotionUnitPrice) {
        this.promotionUnitPrice = promotionUnitPrice;
    }

    public SubUnitPrice getTotalShareCrossShopDiscountFee() {
        return totalShareCrossShopDiscountFee;
    }

    public void setTotalShareCrossShopDiscountFee(SubUnitPrice totalShareCrossShopDiscountFee) {
        this.totalShareCrossShopDiscountFee = totalShareCrossShopDiscountFee;
    }

    public SubCurrencyPrice getTotalSharedAssetDiscountFee() {
        return totalSharedAssetDiscountFee;
    }

    public void setTotalSharedAssetDiscountFee(SubCurrencyPrice totalSharedAssetDiscountFee) {
        this.totalSharedAssetDiscountFee = totalSharedAssetDiscountFee;
    }

    public SubUnitPrice getTotalShareShopDiscountFee() {
        return totalShareShopDiscountFee;
    }

    public void setTotalShareShopDiscountFee(SubUnitPrice totalShareShopDiscountFee) {
        this.totalShareShopDiscountFee = totalShareShopDiscountFee;
    }
}
