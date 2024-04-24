package com.opr.oders.pojo.yw.request;

import lombok.*;

import java.util.List;

/**
 * @Auther: gina
 * @Date: 2024-04-15
 * @Description:
 */

public class SubOrderParamDTO {
    private SubDeliveryParamDTO deliveryParamDTO;
    private SubInvoiceParamDTO invoiceParamDTO;
    private List<SubOrderLineParamDTO> orderLineParamDTOList;
    private String outId;
    private SubPaymentParamDTO paymentParamDTO;
    private SubPriceParamDTO priceParamDTO;

    public SubOrderParamDTO(SubDeliveryParamDTO deliveryParamDTO, SubInvoiceParamDTO invoiceParamDTO, List<SubOrderLineParamDTO> orderLineParamDTOList, String outId, SubPaymentParamDTO paymentParamDTO, SubPriceParamDTO priceParamDTO) {
        this.deliveryParamDTO = deliveryParamDTO;
        this.invoiceParamDTO = invoiceParamDTO;
        this.orderLineParamDTOList = orderLineParamDTOList;
        this.outId = outId;
        this.paymentParamDTO = paymentParamDTO;
        this.priceParamDTO = priceParamDTO;
    }

    public SubDeliveryParamDTO getDeliveryParamDTO() {
        return deliveryParamDTO;
    }

    public void setDeliveryParamDTO(SubDeliveryParamDTO deliveryParamDTO) {
        this.deliveryParamDTO = deliveryParamDTO;
    }

    public SubInvoiceParamDTO getInvoiceParamDTO() {
        return invoiceParamDTO;
    }

    public void setInvoiceParamDTO(SubInvoiceParamDTO invoiceParamDTO) {
        this.invoiceParamDTO = invoiceParamDTO;
    }

    public List<SubOrderLineParamDTO> getOrderLineParamDTOList() {
        return orderLineParamDTOList;
    }

    public void setOrderLineParamDTOList(List<SubOrderLineParamDTO> orderLineParamDTOList) {
        this.orderLineParamDTOList = orderLineParamDTOList;
    }

    public String getOutId() {
        return outId;
    }

    public void setOutId(String outId) {
        this.outId = outId;
    }

    public SubPaymentParamDTO getPaymentParamDTO() {
        return paymentParamDTO;
    }

    public void setPaymentParamDTO(SubPaymentParamDTO paymentParamDTO) {
        this.paymentParamDTO = paymentParamDTO;
    }

    public SubPriceParamDTO getPriceParamDTO() {
        return priceParamDTO;
    }

    public void setPriceParamDTO(SubPriceParamDTO priceParamDTO) {
        this.priceParamDTO = priceParamDTO;
    }
}
