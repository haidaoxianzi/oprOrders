package com.opr.oders.pojo.yw.request;

import lombok.Data;

/**
 * @Auther: gina
 * @Date: 2024-04-15
 * @Description:
 */
@Data
public class SubOrderLinePriceParamDTO {
    private SubTotalItemDiscountFee totalItemDiscountFee;
    private SubTotalItemDiscountFee totalShareCrossShopDiscountFee;
    private SubTotalItemDiscountFee totalShareShopDiscountFee;
    private SubUnitPrice unitPrice;

    public SubOrderLinePriceParamDTO(SubTotalItemDiscountFee totalItemDiscountFee, SubTotalItemDiscountFee totalShareCrossShopDiscountFee, SubTotalItemDiscountFee totalShareShopDiscountFee, SubUnitPrice unitPrice) {
        this.totalItemDiscountFee = totalItemDiscountFee;
        this.totalShareCrossShopDiscountFee = totalShareCrossShopDiscountFee;
        this.totalShareShopDiscountFee = totalShareShopDiscountFee;
        this.unitPrice = unitPrice;
    }
}
