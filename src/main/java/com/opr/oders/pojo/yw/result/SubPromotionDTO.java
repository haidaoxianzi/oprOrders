package com.opr.oders.pojo.yw.result;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @Auther: gina
 * @Date: 2024-04-15
 * @Description:
 */
@Getter
@Setter
public class SubPromotionDTO {
    private List<Object> shopDisplayPromotionOptionDTOList;
    private List<Object> shopPromotionOptionDTOList;
    private List<Object> crossDisplayPromotionDTOList;
    private List<Object> itemPromotionOptionDTOList;
    private List<Object> crossPromotionOptionDTOList;

}
