package com.opr.oders.pojo.yw.result;

import lombok.Getter;
import lombok.Setter;

/**
 * @Auther: gina
 * @Date: 2024-04-15
 * @Description:
 */

public class SubOrderDeliveryAddressDTO {
    private String addressAddUrl;
    private String getStoreInfoUrl;
    private String addressModifyUrl;
    private Object features;
    private String outRangeNextUrl;
    private String storeLbsUrl;
    private SubSelectedAddressDTO selectedAddressDTO;

    public String getAddressAddUrl() {
        return addressAddUrl;
    }

    public void setAddressAddUrl(String addressAddUrl) {
        this.addressAddUrl = addressAddUrl;
    }

    public String getGetStoreInfoUrl() {
        return getStoreInfoUrl;
    }

    public void setGetStoreInfoUrl(String getStoreInfoUrl) {
        this.getStoreInfoUrl = getStoreInfoUrl;
    }

    public String getAddressModifyUrl() {
        return addressModifyUrl;
    }

    public void setAddressModifyUrl(String addressModifyUrl) {
        this.addressModifyUrl = addressModifyUrl;
    }

    public Object getFeatures() {
        return features;
    }

    public void setFeatures(Object features) {
        this.features = features;
    }

    public String getOutRangeNextUrl() {
        return outRangeNextUrl;
    }

    public void setOutRangeNextUrl(String outRangeNextUrl) {
        this.outRangeNextUrl = outRangeNextUrl;
    }

    public String getStoreLbsUrl() {
        return storeLbsUrl;
    }

    public void setStoreLbsUrl(String storeLbsUrl) {
        this.storeLbsUrl = storeLbsUrl;
    }

    public SubSelectedAddressDTO getSelectedAddressDTO() {
        return selectedAddressDTO;
    }

    public void setSelectedAddressDTO(SubSelectedAddressDTO selectedAddressDTO) {
        this.selectedAddressDTO = selectedAddressDTO;
    }
}
