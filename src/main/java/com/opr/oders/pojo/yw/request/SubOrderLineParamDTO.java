package com.opr.oders.pojo.yw.request;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Auther: gina
 * @Date: 2024-04-15
 * @Description:
 */
@Data
public class SubOrderLineParamDTO {
    private SubExtraParams extraParams;
    private String itemId;
    private Boolean normOrderLine = true;
    private SubOrderLinePriceParamDTO orderLinePriceParamDTO;
    private Integer orderLineType;
    private String originalOutId;
    private String outId;
    private Integer quantity;
    private String skuId;

    public SubOrderLineParamDTO(SubExtraParams extraParams, String itemId,  SubOrderLinePriceParamDTO orderLinePriceParamDTO, Integer orderLineType, String originalOutId, String outId, Integer quantity, String skuId) {
        this.extraParams = extraParams;
        this.itemId = itemId;
        this.orderLinePriceParamDTO = orderLinePriceParamDTO;
        this.orderLineType = orderLineType;
        this.originalOutId = originalOutId;
        this.outId = outId;
        this.quantity = quantity;
        this.skuId = skuId;
    }
}
