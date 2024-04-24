package com.opr.oders.pojo.yw.result;

import java.util.List;

/**
 * @Auther: gina
 * @Date: 2024-04-17
 * @Description:
 */
public class SubOrderDelivery {
    private String districtCode;
    private String city;
    private String cityCode;
    private List<SubDeliveryDetail> deliveryDetailList;
    private String province;
    private String address;
    private String provinceCode;
    private Integer deliveryType;
    private String phone;
    private SubOrderEncryptDeliveryResponse orderEncryptDeliveryResponse;
    private String district;
    private String deliveryTypeDesc;
    private String name;
    private String detailAddress;

    public String getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public List<SubDeliveryDetail> getDeliveryDetailList() {
        return deliveryDetailList;
    }

    public void setDeliveryDetailList(List<SubDeliveryDetail> deliveryDetailList) {
        this.deliveryDetailList = deliveryDetailList;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public Integer getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(Integer deliveryType) {
        this.deliveryType = deliveryType;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public SubOrderEncryptDeliveryResponse getOrderEncryptDeliveryResponse() {
        return orderEncryptDeliveryResponse;
    }

    public void setOrderEncryptDeliveryResponse(SubOrderEncryptDeliveryResponse orderEncryptDeliveryResponse) {
        this.orderEncryptDeliveryResponse = orderEncryptDeliveryResponse;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getDeliveryTypeDesc() {
        return deliveryTypeDesc;
    }

    public void setDeliveryTypeDesc(String deliveryTypeDesc) {
        this.deliveryTypeDesc = deliveryTypeDesc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }
}
