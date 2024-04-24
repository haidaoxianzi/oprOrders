package com.opr.oders.KuCunShare.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.opr.oders.common.Opr.Constants4StoreShare;
import com.opr.oders.pojo.yw.request.StoreShareEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//import com.iflytek.Common.*;
//import static com.iflytek.Common.Const.*;

/**
 * @Auther: gina
 * @Date: 2024-04-12
 * @Description:java + testNG测试框架搭建–HTTP层接口应用
 */

@SpringBootTest
@Slf4j
public class ATest {

    private static final Logger log = LogManager.getLogger(ATest.class);

    @Test()
    /*获取书本接口测试用例*/
    public void getReadBookTypeList() {
        System.setProperty("javax.net.ssl.trustStore", "/Library/Java/JavaVirtualMachines/jdk1.8.0_361.jdk/Contents/Home/jre/lib/security/cacerts");
        System.setProperty("javax.net.ssl.trustStorePassword", "123wq!!!");


        RestTemplate restTemplate = new RestTemplate();
        // 请求网址
        String url = "https://stock.uat2-backend.feihe.com/api/erp_wms/queryWmsPhysicalInventory";

        //请求参数
        Map<String, Object> paramMap = new HashMap<>();
        List _fields = new ArrayList();
        paramMap.put("_fields", _fields);
        paramMap.put("start", 0);
        paramMap.put("limit", 20);
        paramMap.put("haveTotalQuantity", "true");
        List<String> warehouseIdList = new ArrayList<>();
        warehouseIdList.add(StoreShareEnum.getStoreShareWarehouseId("419"));//枚举做适配 1000000191
        paramMap.put("warehouseIdList", warehouseIdList);
        paramMap.put("skuCodeStr", "XM001");
        paramMap.put("batchEnable", "1");
        paramMap.put("status", "1");
        String paramJSonStr = JSON.toJSONString(paramMap);
        log.info("paramStr={}", paramJSonStr);

        //请求报文
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cookie", Constants4StoreShare.Cookie);
        headers.add("X-XSRF-TOKEN", Constants4StoreShare.OMS_TOKEN);
        headers.add("Content-type", "application/json");

//        headers.add("Content-Type","application/x-www-form-urlencoded;charset=UTF-8");

        //将接口参数转化json格式,并赋值给params
        MultiValueMap<String, Object> postParameters = new LinkedMultiValueMap();
        postParameters.add("params", paramJSonStr);

        HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<>(postParameters, headers);
        JSONObject response = restTemplate.postForObject(url, request, JSONObject.class);  //发送请求
        log.info("response===={}", JSON.toJSONString(response)); //打印响应结果
        //断言比较响应结果的正确性
      /*  Assert.assertEquals(response.getString("message"), "成功");
        Assert.assertEquals(response.getJSONArray("returnValue").size(), 3);
        Assert.assertEquals(response.getJSONArray("returnValue").getJSONObject(0).get("name"), "童话绘本");
        Assert.assertEquals(response.getJSONArray("returnValue").getJSONObject(1).get("name"), "传统美德故事");
        Assert.assertEquals(response.getJSONArray("returnValue").getJSONObject(2).get("name"), "少年中国梦");
  */
    }

}

