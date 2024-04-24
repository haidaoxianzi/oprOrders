package com.opr.oders.pojo.yw.request;

import lombok.Getter;
import lombok.Setter;

/**
 * @Auther: gina
 * @Date: 2024-04-12
 * @Description:
 */
/*@Setter
@Getter*/
public class SubItemParamDTO {
   /*
            "itemId": "622326341145331589",
            "outerId": "3878890707607",
            "quantity": 1,
            "skuId": "622326341153718477"*/
   private String itemId;
   private String outerId;
   private int quantity=1;
   private String skuId;
   private SubItemParamDTOExtParams extraParams;

   public String getItemId() {
      return itemId;
   }

   public void setItemId(String itemId) {
      this.itemId = itemId;
   }

   public String getOuterId() {
      return outerId;
   }

   public void setOuterId(String outerId) {
      this.outerId = outerId;
   }

   public int getQuantity() {
      return quantity;
   }

   public void setQuantity(int quantity) {
      this.quantity = quantity;
   }

   public String getSkuId() {
      return skuId;
   }

   public void setSkuId(String skuId) {
      this.skuId = skuId;
   }

   public SubItemParamDTOExtParams getExtraParams() {
      return extraParams;
   }

   public void setExtraParams(SubItemParamDTOExtParams extraParams) {
      this.extraParams = extraParams;
   }
}
