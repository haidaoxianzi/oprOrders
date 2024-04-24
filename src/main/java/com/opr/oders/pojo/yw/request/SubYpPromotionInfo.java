package com.opr.oders.pojo.yw.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Auther: gina
 * @Date: 2024-04-15
 * @Description:
 */
@ToString
public class SubYpPromotionInfo {
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public SubYpPromotionInfo(String type) {
        this.type = type;
    }

}
