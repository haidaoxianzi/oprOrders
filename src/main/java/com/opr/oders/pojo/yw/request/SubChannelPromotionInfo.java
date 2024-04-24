package com.opr.oders.pojo.yw.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Auther: gina
 * @Date: 2024-04-15
 * @Description:
 */
@ToString
@Setter
@Getter
public class SubChannelPromotionInfo {
    private String goodsTag;

    public SubChannelPromotionInfo(String goodsTag) {
        this.goodsTag = goodsTag;
    }


}
