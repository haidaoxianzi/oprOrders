package com.opr.oders.pojo.yw.result;

import com.opr.oders.pojo.yw.request.SubExtraParams;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @Auther: gina
 * @Date: 2024-04-15
 * @Description:
 */

public class SubRenderOrderResult {
    private SubPromotionDTO promotionDTO;
    private SubLinkageDTO linkageDTO;
    private SubBuyerDTO buyerDTO;
    private SubExtraParams extraParams;
    private List<SubOrderDTO> orderDTOList;

    public SubPromotionDTO getPromotionDTO() {
        return promotionDTO;
    }

    public void setPromotionDTO(SubPromotionDTO promotionDTO) {
        this.promotionDTO = promotionDTO;
    }

    public SubLinkageDTO getLinkageDTO() {
        return linkageDTO;
    }

    public void setLinkageDTO(SubLinkageDTO linkageDTO) {
        this.linkageDTO = linkageDTO;
    }

    public SubBuyerDTO getBuyerDTO() {
        return buyerDTO;
    }

    public void setBuyerDTO(SubBuyerDTO buyerDTO) {
        this.buyerDTO = buyerDTO;
    }

    public SubExtraParams getExtraParams() {
        return extraParams;
    }

    public void setExtraParams(SubExtraParams extraParams) {
        this.extraParams = extraParams;
    }

    public List<SubOrderDTO> getOrderDTOList() {
        return orderDTOList;
    }

    public void setOrderDTOList(List<SubOrderDTO> orderDTOList) {
        this.orderDTOList = orderDTOList;
    }
}
