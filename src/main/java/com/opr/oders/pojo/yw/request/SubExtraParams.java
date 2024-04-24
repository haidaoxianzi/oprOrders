package com.opr.oders.pojo.yw.request;

import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @Auther: gina
 * @Date: 2024-04-12
 * @Description:
 */
@Getter
@Setter
public class SubExtraParams {

    private String crmId;
    private String periodBuyBtn;
    private String loginUserRole;
    private String cashOnDelivery;
    private String purchaseSalesId;
    private String guide_burying_point;//SubGuideBuryingPoint
    private String usePointAmount;
    private String provinceCode;

    //    "MD_622326341153718477": "null", MD_skiud
    private String MD_;
    private String xmyx_order_source;
    private String ypPromotionInfo;//List<SubYpPromotionInfo>
    private String channelPromotionInfo;
    private String interceptorFlag;
    private String payChannel;
    private String freeShippingActivityId ;
    private String firstDeveloperIdentity ;
    private String storeCommissionRatio  ;
    private String firstDeveloperGuideProperty  ;
    private String mdStoreId;
    private String firstDeveloperType ;
    private String dealerMerchantId;
    private String firstRatio  ;
    private String developerMdStoreId;
    private String isBindingUser ;
    private String distributeRatio  ;
    private String dealerStoreId;
    private String distributionCommissionRatio ;
    private String mdMerchantId;
    private String firstDeveloperEmployeeNo  ;
    private String firstDeveloper;
    private String developerDealerMerchantId;
    private String secondRatio ;
    private String offLineShopId;
    private String distributionModel;
    private String offLineDealerId;
    private String developerDealerStoreId;
    private String itemShippingFee ;
    private String startPath  ;
    private String orderlineTags ;
    private String isShareProfit ;
    private String developerMdMerchantId;
    private String firstDeveloperName;
    private String categoryId;
    private String shareUser ;
    private String storeBizPermit ;
    private String upperStoreId ;


    public SubExtraParams() {
    }

    //todo 默认值应该写在构造里，不应直接给属性赋值
    public SubExtraParams(String crmId, String periodBuyBtn, String loginUserRole, String cashOnDelivery) {
        this.crmId = crmId;
        this.periodBuyBtn = periodBuyBtn;
        this.loginUserRole = loginUserRole;
        this.cashOnDelivery = cashOnDelivery;
    }


    public SubExtraParams(String crmId,
                          SubGuideBuryingPoint guide_burying_point, String usePointAmount, String provinceCode,
                          List<SubYpPromotionInfo> ypPromotionInfo, SubChannelPromotionInfo channelPromotionInfo) {
        this.crmId = crmId;
        this.guide_burying_point = JSON.toJSONString(guide_burying_point);
        this.usePointAmount = usePointAmount;
        this.provinceCode = provinceCode;
        this.MD_ = null;
        this.ypPromotionInfo = JSON.toJSONString(ypPromotionInfo);
        this.channelPromotionInfo = JSON.toJSONString(channelPromotionInfo);
        this.purchaseSalesId = "0";
        this.periodBuyBtn = "0";
        this.cashOnDelivery = "0";
        this.interceptorFlag = "1";
        this.payChannel = "WECARD_APPLETPAY";
        this.xmyx_order_source = "1";
        this.loginUserRole = "0";

    }


    public SubExtraParams(String mdStoreId, String dealerMerchantId,
                          String dealerStoreId, String mdMerchantId, String firstDeveloper,
                          String offLineShopId, String distributionModel, String offLineDealerId,
                          List<SubYpPromotionInfo> ypPromotionInfo,
                          String firstDeveloperName, String categoryId, SubChannelPromotionInfo channelPromotionInfo) {

        this.mdStoreId = mdStoreId;
        this.dealerMerchantId = dealerMerchantId;
        this.developerMdStoreId = mdStoreId;
        this.dealerStoreId = dealerStoreId;
        this.mdMerchantId = mdMerchantId;
        this.firstDeveloper = firstDeveloper;
        this.developerDealerMerchantId = dealerMerchantId;
        this.offLineShopId = offLineShopId;
        this.distributionModel = distributionModel;
        this.offLineDealerId = offLineDealerId;
        this.developerDealerStoreId = dealerStoreId;
        this.ypPromotionInfo = JSON.toJSONString(ypPromotionInfo);

        this.developerMdMerchantId = mdMerchantId;
        this.firstDeveloperName = firstDeveloperName;
        this.categoryId = categoryId;
        this.channelPromotionInfo = JSON.toJSONString(channelPromotionInfo);

        // 从这开始给默认值
        this.freeShippingActivityId = "";
        this.firstDeveloperIdentity = "2";
        this.storeCommissionRatio = "0.00";
        this.firstDeveloperGuideProperty = "13";
        this.firstDeveloperType = "3";
        this.firstRatio = "100";
        this.isBindingUser = "0";
        this.distributeRatio = "0.00";
        this.distributionCommissionRatio = "0.00";
        this.firstDeveloperEmployeeNo = "178377";
        this.secondRatio = "0";
        this.itemShippingFee = "0";
        this.startPath = "1";
        this.orderlineTags = "1";
        this.isShareProfit = "1";
        this.shareUser = "";

    }


}
