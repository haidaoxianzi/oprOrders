package com.opr.oders.GenOrderYouXuan.LianYing;

import com.alibaba.fastjson.JSONObject;
import com.opr.oders.GenOrderYouXuan.serivce.PointPayOrderService;
import com.opr.oders.common.Opr.CommonUtil;
import com.opr.oders.common.Opr.Constants4OMS;
import com.opr.oders.common.Opr.InfosManagement;
import com.opr.oders.pojo.yw.request.RenderOrder;
import com.opr.oders.pojo.yw.result.RenderOrderResp;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.testng.Assert;

import javax.annotation.Resource;

/**
 * @Auther: gina
 * @Date: 2024-04-12
 * @Description:
 */
@SpringBootTest
@Slf4j
class PointPayOrderServiceImplTest {

    private static final Logger log = LoggerFactory.getLogger(PointPayOrderServiceImplTest.class);
    @Resource
    private PointPayOrderService pointPayOrderService;


    @Test
    void renderOrder() {
        JSONObject response = pointPayOrderService.renderOrder();
        //断言比较响应结果的正确性
        Assert.assertEquals(response.getString("success"), "true");
        RenderOrderResp a = RenderOrderResp.jsonObject2Bean(response,RenderOrderResp.class);
        log.info("a===={}", JSONObject.toJSONString(a));

    }

  /*  @Test
    void createOrder() {
        JSONObject response = pointPayOrderService.createOrder();
        //断言比较响应结果的正确性
        Assert.assertEquals(response.getString("success"), "true");

    }*/

    /**
     * 联营单品创单【积分支付】
     * step1: 创单渲染接口
     * step2: 生成订单
     */
    //todo 轮询注解，批量下单
    @Test
    void testGenOrder() {
        JSONObject renderOrderRes = pointPayOrderService.renderOrder();
        Assert.assertEquals(renderOrderRes.getString("success"), "true", "订单渲染成功");
        RenderOrderResp renderOrderResp = RenderOrderResp.jsonObject2Bean(renderOrderRes,RenderOrderResp.class);
        log.info("renderOrderRespJson===={}", JSONObject.toJSONString(renderOrderResp));
        JSONObject cOrderResJsonObject = pointPayOrderService.createOrder( renderOrderResp);
        //断言比较响应结果的正确性
        Assert.assertEquals(cOrderResJsonObject.getString("success"), "true", "继渲染后，创单成功");
    }
    // todo 123wq 拿着签出入参看 需要的数据，创单接口返回是否有

    /**
     * todo restTemplate 形式
     */
    @Test
    public void renderOrder2() {
        // 转换成http的请求参数
     /*   Map<String, String> param1 = new HashMap<>();
        param1.put("tradeOrderId", "9300000958133721081");

        String postParam = JSON.toJSONString(param1);
        try {
            JSONObject jsonObject = HttpClientUtil.post(url, postParam,Constants.Cookie,Constants.OMS_TOKEN);
            log.info("jsonObject===={}",jsonObject.toJSONString());
            *//*转化为订单详情对象信息返回*//*
        } catch (IOException e) {
            log.error(" orderDetail error",e);
        }*/

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

    }


    /*
     * 测试生成随机数
     * */
    @Test
    void testRandom() {
        System.out.println(CommonUtil.genRandomNum(100000L));
    }


}