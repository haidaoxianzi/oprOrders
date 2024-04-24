package com.opr.oders.pojo.yw.result;

import lombok.Getter;
import lombok.Setter;

/**
 * @Auther: gina
 * @Date: 2024-04-15
 * @Description:
 */
@Getter
@Setter
public class SubSelectedSkuDTO {

    private Integer unitPrice;
    private SubSelectedSkuDTOFeatures features;
    private String skuProperties;
    private String pictureUrl;

    private String skuId;
}
