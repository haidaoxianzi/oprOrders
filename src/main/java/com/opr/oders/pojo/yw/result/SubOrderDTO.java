package com.opr.oders.pojo.yw.result;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @Auther: gina
 * @Date: 2024-04-15
 * @Description:
 */

public class SubOrderDTO {
    private SubFulfillmentDTO fulfillmentDTO;
    private SubOrderPriceDTO orderPriceDTO;
    private SubStoreDTO storeDTO;
    private SubOrderDeliveryAddressDTO orderDeliveryAddressDTO;
    private List<SubOrderLineDTO> orderLineDTOList;
    private String orderStatus;
    private String outId;
    private String splitTraceInfo;
    private SubPaymentDTO paymentDTO;
    private boolean supportInvoice;
    private SubMerchantDTO merchantDTO;

    public SubFulfillmentDTO getFulfillmentDTO() {
        return fulfillmentDTO;
    }

    public void setFulfillmentDTO(SubFulfillmentDTO fulfillmentDTO) {
        this.fulfillmentDTO = fulfillmentDTO;
    }

    public SubOrderPriceDTO getOrderPriceDTO() {
        return orderPriceDTO;
    }

    public void setOrderPriceDTO(SubOrderPriceDTO orderPriceDTO) {
        this.orderPriceDTO = orderPriceDTO;
    }

    public SubStoreDTO getStoreDTO() {
        return storeDTO;
    }

    public void setStoreDTO(SubStoreDTO storeDTO) {
        this.storeDTO = storeDTO;
    }

    public SubOrderDeliveryAddressDTO getOrderDeliveryAddressDTO() {
        return orderDeliveryAddressDTO;
    }

    public void setOrderDeliveryAddressDTO(SubOrderDeliveryAddressDTO orderDeliveryAddressDTO) {
        this.orderDeliveryAddressDTO = orderDeliveryAddressDTO;
    }

    public List<SubOrderLineDTO> getOrderLineDTOList() {
        return orderLineDTOList;
    }

    public void setOrderLineDTOList(List<SubOrderLineDTO> orderLineDTOList) {
        this.orderLineDTOList = orderLineDTOList;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOutId() {
        return outId;
    }

    public void setOutId(String outId) {
        this.outId = outId;
    }

    public String getSplitTraceInfo() {
        return splitTraceInfo;
    }

    public void setSplitTraceInfo(String splitTraceInfo) {
        this.splitTraceInfo = splitTraceInfo;
    }

    public SubPaymentDTO getPaymentDTO() {
        return paymentDTO;
    }

    public void setPaymentDTO(SubPaymentDTO paymentDTO) {
        this.paymentDTO = paymentDTO;
    }

    public boolean isSupportInvoice() {
        return supportInvoice;
    }

    public void setSupportInvoice(boolean supportInvoice) {
        this.supportInvoice = supportInvoice;
    }

    public SubMerchantDTO getMerchantDTO() {
        return merchantDTO;
    }

    public void setMerchantDTO(SubMerchantDTO merchantDTO) {
        this.merchantDTO = merchantDTO;
    }
}
