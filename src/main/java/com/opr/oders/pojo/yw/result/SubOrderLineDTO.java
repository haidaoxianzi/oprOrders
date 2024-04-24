package com.opr.oders.pojo.yw.result;


import lombok.Getter;
import lombok.Setter;

/**
 * @Auther: gina
 * @Date: 2024-04-15
 * @Description:
 */

public class SubOrderLineDTO {
    private Object features;
    private Integer quantity;
    private Integer orderLineType;
    private String originalOutId;
    private SubOrderLinePromotionDTO orderLinePromotionDTO;
    private SubExtraParams extraParams;
    private String outId;
    private SubItemDTO itemDTO;
    private SubOrderLinePriceDTO orderLinePriceDTO;
    private String status;

    public Object getFeatures() {
        return features;
    }

    public void setFeatures(Object features) {
        this.features = features;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getOrderLineType() {
        return orderLineType;
    }

    public void setOrderLineType(Integer orderLineType) {
        this.orderLineType = orderLineType;
    }

    public String getOriginalOutId() {
        return originalOutId;
    }

    public void setOriginalOutId(String originalOutId) {
        this.originalOutId = originalOutId;
    }

    public SubOrderLinePromotionDTO getOrderLinePromotionDTO() {
        return orderLinePromotionDTO;
    }

    public void setOrderLinePromotionDTO(SubOrderLinePromotionDTO orderLinePromotionDTO) {
        this.orderLinePromotionDTO = orderLinePromotionDTO;
    }

    public SubExtraParams getExtraParams() {
        return extraParams;
    }

    public void setExtraParams(SubExtraParams extraParams) {
        this.extraParams = extraParams;
    }

    public String getOutId() {
        return outId;
    }

    public void setOutId(String outId) {
        this.outId = outId;
    }

    public SubItemDTO getItemDTO() {
        return itemDTO;
    }

    public void setItemDTO(SubItemDTO itemDTO) {
        this.itemDTO = itemDTO;
    }

    public SubOrderLinePriceDTO getOrderLinePriceDTO() {
        return orderLinePriceDTO;
    }

    public void setOrderLinePriceDTO(SubOrderLinePriceDTO orderLinePriceDTO) {
        this.orderLinePriceDTO = orderLinePriceDTO;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
