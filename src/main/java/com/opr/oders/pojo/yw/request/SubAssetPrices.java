package com.opr.oders.pojo.yw.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Auther: gina
 * @Date: 2024-04-15
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubAssetPrices {
    private Double amount;
    private String assetName="积分";
    private String assetType="INTEGRAL";

    public SubAssetPrices(Double amount) {
        this.amount = amount;
    }
}

