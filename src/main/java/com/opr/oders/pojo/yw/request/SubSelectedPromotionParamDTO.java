package com.opr.oders.pojo.yw.request;

import java.util.List;

/**
 * @Auther: gina
 * @Date: 2024-04-15
 * @Description:
 */
public class SubSelectedPromotionParamDTO {
    /**
     * 选中的优惠id
     */
    private List<String> promotionIdValues;
    /**
     * 作用实体的outId，如商品id，店铺id，平台id。
     */
    private String outId;

    public List<String> getPromotionIdValues() {
        return promotionIdValues;
    }

    public void setPromotionIdValues(List<String> promotionIdValues) {
        this.promotionIdValues = promotionIdValues;
    }

    public String getOutId() {
        return outId;
    }

    public void setOutId(String outId) {
        this.outId = outId;
    }
}
