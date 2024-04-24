package com.opr.oders.pojo.yw.result;

import lombok.Getter;
import lombok.Setter;

/**
 * @Auther: gina
 * @Date: 2024-04-15
 * @Description:
 */

public class SubItemDTO {
    private SubItemDTOFeatures features;
    private String itemId;
    private String mainPictUrl;
    private String merchantId;
    private SubSelectedSkuDTO selectedSkuDTO;
    private String storeId;
    private String title;
    private String leafCategoryId;
    private Integer sellableQuantity;
    private String channelCode;

    public SubItemDTOFeatures getFeatures() {
        return features;
    }

    public void setFeatures(SubItemDTOFeatures features) {
        this.features = features;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getMainPictUrl() {
        return mainPictUrl;
    }

    public void setMainPictUrl(String mainPictUrl) {
        this.mainPictUrl = mainPictUrl;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public SubSelectedSkuDTO getSelectedSkuDTO() {
        return selectedSkuDTO;
    }

    public void setSelectedSkuDTO(SubSelectedSkuDTO selectedSkuDTO) {
        this.selectedSkuDTO = selectedSkuDTO;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLeafCategoryId() {
        return leafCategoryId;
    }

    public void setLeafCategoryId(String leafCategoryId) {
        this.leafCategoryId = leafCategoryId;
    }

    public Integer getSellableQuantity() {
        return sellableQuantity;
    }

    public void setSellableQuantity(Integer sellableQuantity) {
        this.sellableQuantity = sellableQuantity;
    }

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
    }
}
