package com.opr.oders.pojo.yw.result;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @Auther: gina
 * @Date: 2024-04-15
 * @Description:
 */

public class SubOrderLinePromotionDTO {
  private  List unionOrderOutIds;

  public List getUnionOrderOutIds() {
    return unionOrderOutIds;
  }

  public void setUnionOrderOutIds(List unionOrderOutIds) {
    this.unionOrderOutIds = unionOrderOutIds;
  }
}
