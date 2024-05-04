package com.opr.oders.GenOrderYouXuan.LianYing;

import com.alibaba.fastjson.JSONObject;
import com.opr.oders.QueryOrder.QueryOrderDetailService;
import com.opr.oders.common.Opr.Constants4OMS;
import com.opr.oders.common.Opr.InfosManagement;
import com.opr.oders.common.httpclient.HttpClientUtil;
import com.opr.oders.OMSsendgoods.service.DaCangSendGoodsService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.IOException;


@Slf4j
@SpringBootTest
public class HttpClientUtilCalledTest {

    @Resource
    QueryOrderDetailService queryOrderDetailService;
    /**
     * 获取订单详情接口，http post
     */
    @Test
    public void orderDetail() {
        queryOrderDetailService.orderDetail("9300000943795606279");
    }

   /* public IntellectCartResult bindCart(IntellectCartRequest request) {
        IntellectCartResult result = new IntellectCartResult();
        // 转换成http的请求参数
        IntellectCartParams params = IntellectCartConvert.convertIntellectCartParams.apply(request);
        String json = JSON.toJSONString(params);
        try {
            JSONObject jsonObject = CartHttpClientUtil.post(intellectCartUrl, json, request.getDeviceId(),
                    AppActivityConstants.INTELLECT_CART_VERSION_TYPE, AppActivityConstants.INTELLECT_CART_TOKEN);
            result = IntellectCartConvert.convertIntellectCartResult.apply(jsonObject);
        } catch (IOException e) {
            log.error("IntellectCartService bindCart error",e);
        }
        return result;
    }*/

    /**
     * http Get
     */
    @Test
    public void getTest() {
        String url = Constants4OMS.UAT2_OMS_Host + InfosManagement.orderDetail_OMS;
        try {
            JSONObject jsonObject = HttpClientUtil.get(url, null, Constants4OMS.Cookie, Constants4OMS.OMS_TOKEN);
            log.info("jsonObject===={}", jsonObject.toJSONString());
        } catch (IOException e) {
            log.error("getTest  error", e);
        }
    }

}
