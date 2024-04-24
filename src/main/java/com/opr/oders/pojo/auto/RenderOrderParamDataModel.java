package com.opr.oders.pojo.auto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Auther: gina
 * @Date: 2024-04-12
 * @Description：自定义参数化模型
 * 创单渲染接口：参数化数据模型
 */
/*@Getter
@Setter
@AllArgsConstructor*/
public class RenderOrderParamDataModel {
    private String buyerId;
    private String itemId;
    private String outerId;
    private String skuId;
    private String openId;

    public RenderOrderParamDataModel(String buyerId, String itemId, String outerId, String skuId, String openId) {
        this.buyerId = buyerId;
        this.itemId = itemId;
        this.outerId = outerId;
        this.skuId = skuId;
        this.openId = openId;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

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

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }
}
