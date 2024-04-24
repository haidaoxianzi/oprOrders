package com.opr.oders.pojo.yw.request;

import com.alibaba.fastjson.JSONObject;
import com.opr.oders.pojo.auto.CreateOrderParamDataModel;
import com.opr.oders.pojo.yw.result.RenderOrderResp;
import com.opr.oders.pojo.yw.result.SubOrderDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: gina
 * @Date: 2024-04-15
 * @Description:创建订单业务类
 */
@Getter
@Setter
@Slf4j
@NoArgsConstructor
public class CreateOrder {

    private static final Logger log = LoggerFactory.getLogger(CreateOrder.class);
    private SubAddressParamDTO addressParamDTO;
    private SubBuyerParamDTO buyerParamDTO;
    private SubExtraParams extraParams;
    private Boolean needSuccessfulTradeOrder;
    private List<SubOrderParamDTO> orderParamDTOList;
    private SubPromotionParamDTO promotionParamDTO;
    private SubSourceParamDTO sourceParamDTO;

    public CreateOrder(SubAddressParamDTO addressParamDTO, SubBuyerParamDTO buyerParamDTO, SubExtraParams extraParams, Boolean needSuccessfulTradeOrder,
                       List<SubOrderParamDTO> orderParamDTOList, SubPromotionParamDTO promotionParamDTO, SubSourceParamDTO sourceParamDTO) {
        this.addressParamDTO = addressParamDTO;
        this.buyerParamDTO = buyerParamDTO;
        this.extraParams = extraParams;
        this.needSuccessfulTradeOrder = needSuccessfulTradeOrder;
        this.orderParamDTOList = orderParamDTOList;
        this.promotionParamDTO = promotionParamDTO;
        this.sourceParamDTO = sourceParamDTO;

    }

    public static String genCreateOrderParam(RenderOrderResp renderOrderResp) {
      /*  String addressId= {"queryParams":"{\"addressParamDTO\":{\"selectedAddressId\":\"
            String originalOutId= $.result.orderDTOList[0].orderLineDTOList[0].originalOutId
            String outId=$.result.orderDTOList[0].orderLineDTOList[0].outId
            String outId1=$.result.orderDTOList[0].outId*/
        SubOrderDTO orderDTO=renderOrderResp.getResult().getOrderDTOList().get(0);
        String addressId= orderDTO.getOrderDeliveryAddressDTO().getSelectedAddressDTO().getId();
        String originalOutId=orderDTO.getOrderLineDTOList().get(0).getOriginalOutId();
        String outId=orderDTO.getOrderLineDTOList().get(0).getOutId();
        String outId1=orderDTO.getOutId();

            CreateOrderParamDataModel cOrderParamModel = new CreateOrderParamDataModel(addressId, "CRM000000000050251048", originalOutId, outId
                , outId1, "FH11300003327", "2000701522", "100010", "10000011", "229668", "M4588233"
                , "2", "0101010103", "138****1285", "490046254076007712", "ZPXSHZY", "622326341145331589", 0, 1, "622326341153718477",
                "2", 4d, "330000");

        SubAddressParamDTO addressParamDTO = new SubAddressParamDTO(cOrderParamModel.getAddressId());
        SubBuyerParamDTO buyerParamDTO = new SubBuyerParamDTO(cOrderParamModel.getBuyerId());

        List<SubOrderParamDTO> orderParamDTOList = genOrderParamDTOList(cOrderParamModel);


        List<SubSelectedPromotionParamDTO> tmp = new ArrayList();
        SubPromotionParamDTO promotionParamDTO = new SubPromotionParamDTO(tmp, tmp, tmp);

        SubExtraParams extraParams = genExtraParams(cOrderParamModel);
        CreateOrder cOrder = new CreateOrder(addressParamDTO, buyerParamDTO, extraParams, true, orderParamDTOList, promotionParamDTO, new SubSourceParamDTO(cOrderParamModel.getOpenId()));

        //字符串转成json串
        String jsonString = JSONObject.toJSONString(cOrder);

        return jsonString;
    }

    private static SubExtraParams genExtraParams(CreateOrderParamDataModel cOrderParamModel) {
        List<SubYpPromotionInfo> ypPromotionInfo = new ArrayList<>();
        SubYpPromotionInfo ypPromotion = new SubYpPromotionInfo("CUSTOM_ALLOWANCE");
        ypPromotionInfo.add(ypPromotion);


        return new SubExtraParams(cOrderParamModel.getBuyerId(), new SubGuideBuryingPoint(), cOrderParamModel.getAmount().intValue() + "", cOrderParamModel.getProvinceCode()
                , ypPromotionInfo, new SubChannelPromotionInfo(cOrderParamModel.getGoodsTag()));
    }

    private static List<SubOrderParamDTO> genOrderParamDTOList(CreateOrderParamDataModel cOrderParamModel) {
        List<SubOrderParamDTO> orderParamDTOList = new ArrayList<>();


        List<SubOrderLineParamDTO> orderLineParamDTOList = new ArrayList<>();

        List<SubYpPromotionInfo> ypPromotionInfo = new ArrayList<>();
        SubYpPromotionInfo ypPromotion = new SubYpPromotionInfo("CUSTOM_ALLOWANCE");
        ypPromotionInfo.add(ypPromotion);

        SubExtraParams extraParams = new SubExtraParams(cOrderParamModel.getMdStoreId(), cOrderParamModel.getDealerMerchantId()
                , cOrderParamModel.getDealerStoreId(), cOrderParamModel.getMdMerchantId()
                , cOrderParamModel.getBuyerId(), cOrderParamModel.getOffLineShopId(), cOrderParamModel.getDistributionModel(), cOrderParamModel.getOffLineDealerId(), ypPromotionInfo
                , cOrderParamModel.getFirstDeveloperName(), cOrderParamModel.getCategoryId(), new SubChannelPromotionInfo(cOrderParamModel.getGoodsTag()));
       /* "freeShippingActivityId": "",
                "startPath": "1",
                "channelPromotionInfo": "{\"goodsTag\":\"ZPXSHZY\"}",
                "itemShippingFee": "0",
                "ypPromotionInfo": "[{\"type\":\"CUSTOM_ALLOWANCE\"}]",
                "categoryId": "492163037332969314",
                "shareUser":*/

        SubTotalItemDiscountFee totalItemDiscountFee = new SubTotalItemDiscountFee();
        SubTotalItemDiscountFee totalShareCrossShopDiscountFee = new SubTotalItemDiscountFee();
        SubTotalItemDiscountFee totalShareShopDiscountFee = new SubTotalItemDiscountFee();


        SubUnitPrice subUnitPrice = new SubUnitPrice();
        List<SubAssetPrices> assetPrices = new ArrayList<>();
        SubAssetPrices assetPrice = new SubAssetPrices(cOrderParamModel.getAmount());
        assetPrices.add(assetPrice);
        subUnitPrice.setAssetPrices(assetPrices);
        subUnitPrice.setCurrencyPrice(new SubCurrencyPrice());
        SubOrderLinePriceParamDTO orderLinePriceParamDTO = new SubOrderLinePriceParamDTO(totalItemDiscountFee, totalShareCrossShopDiscountFee, totalShareShopDiscountFee, subUnitPrice);
        SubOrderLineParamDTO orderLineParamDTO = new SubOrderLineParamDTO(extraParams, cOrderParamModel.getItemId(), orderLinePriceParamDTO, cOrderParamModel.getOrderLineType(),
                cOrderParamModel.getOriginalOutId(), cOrderParamModel.getOutId(), cOrderParamModel.getQuantity(), cOrderParamModel.getSkuId());

        orderLineParamDTOList.add(orderLineParamDTO);

        SubOrderParamDTO orderParamDTO = new SubOrderParamDTO(new SubDeliveryParamDTO(), new SubInvoiceParamDTO(),
                orderLineParamDTOList, cOrderParamModel.getOutId1(), new SubPaymentParamDTO(cOrderParamModel.getSelectedPaymentMethodCode()), new SubPriceParamDTO());

        orderParamDTOList.add(orderParamDTO);


        return orderParamDTOList;

    }
}
