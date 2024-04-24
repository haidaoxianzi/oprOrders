package com.opr.oders.pojo.yw.request;

import java.util.List;

/**
 * @Auther: gina
 * @Date: 2024-04-15
 * @Description:
 */
public class SubPromotionParamDTO {
    private List<SubSelectedPromotionParamDTO> crossPromotionParamDTOList;
    private List<SubSelectedPromotionParamDTO> itemPromotionParamDTOList;
    private List<SubSelectedPromotionParamDTO> shopPromotionParamDTOList;

    public SubPromotionParamDTO(List<SubSelectedPromotionParamDTO> crossPromotionParamDTOList, List<SubSelectedPromotionParamDTO> itemPromotionParamDTOList, List<SubSelectedPromotionParamDTO> shopPromotionParamDTOList) {
        this.crossPromotionParamDTOList = crossPromotionParamDTOList;
        this.itemPromotionParamDTOList = itemPromotionParamDTOList;
        this.shopPromotionParamDTOList = shopPromotionParamDTOList;
    }

    public List<SubSelectedPromotionParamDTO> getCrossPromotionParamDTOList() {
        return crossPromotionParamDTOList;
    }

    public void setCrossPromotionParamDTOList(List<SubSelectedPromotionParamDTO> crossPromotionParamDTOList) {
        this.crossPromotionParamDTOList = crossPromotionParamDTOList;
    }

    public List<SubSelectedPromotionParamDTO> getItemPromotionParamDTOList() {
        return itemPromotionParamDTOList;
    }

    public void setItemPromotionParamDTOList(List<SubSelectedPromotionParamDTO> itemPromotionParamDTOList) {
        this.itemPromotionParamDTOList = itemPromotionParamDTOList;
    }

    public List<SubSelectedPromotionParamDTO> getShopPromotionParamDTOList() {
        return shopPromotionParamDTOList;
    }

    public void setShopPromotionParamDTOList(List<SubSelectedPromotionParamDTO> shopPromotionParamDTOList) {
        this.shopPromotionParamDTOList = shopPromotionParamDTOList;
    }

}
