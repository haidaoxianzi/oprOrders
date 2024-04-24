package com.opr.oders.GenOrderYouXuan.LianYing;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.opr.oders.GenOrderYouXuan.serivce.PointPayOrderService;
import com.opr.oders.common.Opr.Constants4OMS;
import com.opr.oders.common.Opr.InfosManagement;
import com.opr.oders.common.httpclient.HttpClientUtil;
import com.opr.oders.pojo.yw.request.CreateOrder;
import com.opr.oders.pojo.yw.request.RenderOrder;
import com.opr.oders.pojo.yw.result.RenderOrderResp;
import lombok.extern.slf4j.XSlf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

/**
 * @Auther: gina
 * @Date: 2024-04-12
 * @Description:优选联营 -积分订单签出、发货
 */

@XSlf4j
public class PointOrdersSignOutServiceImpl   {
    private static final Logger log = LoggerFactory.getLogger(PointOrdersSignOutServiceImpl.class);

}
