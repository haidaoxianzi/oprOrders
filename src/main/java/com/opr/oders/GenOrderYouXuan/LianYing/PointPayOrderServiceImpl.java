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
 * @Description:优选联营 -积分支付订单
 */

@Service
@XSlf4j
public class PointPayOrderServiceImpl implements PointPayOrderService {
    private static final Logger log = LoggerFactory.getLogger(PointPayOrderServiceImpl.class);

    /**
     * httpclient 已通
     * 创建订单 step1/2:结算页面渲染订单
     */
    public JSONObject renderOrder() {
        try {
            String url = Constants4OMS.FH01_Host + InfosManagement.RENDER_ORDER;
            String requestParam = RenderOrder.genRenderOrderParam();
            JSONObject resp = HttpClientUtil.post(url, requestParam, null, null);
            log.info("renderGenOrder res={},req={}", JSON.toJSONString(resp), requestParam);
            return resp;
        } catch (
                IOException e) {
            log.error("renderGenOrder error", e);
        }
        return null;
    }

    /**
     * 创建订单 step2/2:结算页面创建订单
     */
    public JSONObject createOrder(RenderOrderResp renderOrderResp) {
        try {


            String requestParam = CreateOrder.genCreateOrderParam(renderOrderResp);
            String url = Constants4OMS.FH01_Host + InfosManagement.CREATE_ORDER;
            JSONObject resp = HttpClientUtil.post(url, requestParam, null, null);
            log.info("createGenOrder res={},req={}", JSON.toJSONString(resp), requestParam);
            return resp;
        } catch (
                IOException e) {
            log.error("renderGenOrder error", e);
        }
        return null;
    }

    /**
     * todo
     */
    public JSONObject renderOrder1() {
        RestTemplate restTemplate = new RestTemplate();
        // 渲染订单接口
        String url = Constants4OMS.FH01_Host + InfosManagement.RENDER_ORDER;
        //请求报文
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json;charset=UTF-8");

        String requestParam = RenderOrder.genRenderOrderParam();

        //将接口参数转化json格式,并赋值给params
        MultiValueMap<String, Object> postParameters = new LinkedMultiValueMap();
        postParameters.add("params", requestParam);

        HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<>(postParameters, headers);
        JSONObject response = restTemplate.postForObject(url, request, JSONObject.class);  //发送请求
        System.out.println(response);  //打印响应结果
        return response;

       /* Assert.assertEquals(response.getJSONArray("returnValue").size(), 3);
        Assert.assertEquals(response.getJSONArray("returnValue").getJSONObject(0).get("name"), "童话绘本");
        Assert.assertEquals(response.getJSONArray("returnValue").getJSONObject(1).get("name"), "传统美德故事");
        Assert.assertEquals(response.getJSONArray("returnValue").getJSONObject(2).get("name"), "少年中国梦");*/

    }

    //fh01.retailforce.uat2.feihe.com/buy/dubbo/createOrder


}
