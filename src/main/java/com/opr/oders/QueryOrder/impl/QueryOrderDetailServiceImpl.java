package com.opr.oders.QueryOrder.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.opr.oders.QueryOrder.QueryOrderDetailService;
import com.opr.oders.common.Opr.Constants4OMS;
import com.opr.oders.common.Opr.InfosManagement;
import com.opr.oders.common.httpclient.HttpClientUtil;
import com.opr.oders.pojo.yw.result.BaseResp;
import com.opr.oders.pojo.yw.result.OrderDetailResp;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: gina
 * @Date: 2024-04-12
 * @Description:
 */
@Service
@Slf4j
public class QueryOrderDetailServiceImpl implements QueryOrderDetailService {

    private static final Logger log = LogManager.getLogger(QueryOrderDetailServiceImpl.class);

    @Override
    public OrderDetailResp orderDetail(String orderId) {
        if (StringUtils.isEmpty(orderId)) {
            return  (OrderDetailResp)new BaseResp(false,"订单号不能为空");
        }
        //StringUtils.trimArrayElements(strArray)
        String url = Constants4OMS.UAT2_OMS_Host + InfosManagement.orderDetail_OMS;
        // 转换成http的请求参数
        Map<String, String> param1 = new HashMap<>();
        param1.put("tradeOrderId", "9300000958133721081");

        String postParam = JSON.toJSONString(param1);
        try {
            JSONObject jsonObject = HttpClientUtil.post(url, postParam, Constants4OMS.Cookie, Constants4OMS.OMS_TOKEN);
            log.info("jsonObject===={}", jsonObject.toJSONString());
            /*转化为订单详情对象信息返回*/
            OrderDetailResp orderDetail = OrderDetailResp.jsonObject2Bean(jsonObject, OrderDetailResp.class);
            return orderDetail;
        } catch (IOException e) {
            log.error(" orderDetail error", e);
        }
        return null;
    }
}
