package com.opr.oders.common.Opr;

import com.alibaba.fastjson.JSON;
import com.opr.oders.common.httpclient.RestTemplateConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: gina
 * @Date: 2024-04-17
 * @Description:库存共享端，常量池
 */
@Slf4j
public class Constants4StoreShare {
    /**
     * uat2库存共享端域名
     */
    public static final String UAT2_STORE_HOST = "https://stock.uat2-backend.feihe.com";

    public static final String QUERY_WMS_PHYSICAL_INVENTORY = "/api/erp_wms/queryWmsPhysicalInventory";
    //库存共享端 登陆信息
    public static String STORE_SHARE_TOKEN;
    public static String STORE_SHARE_COOKIE;

    /**
     * 库存共享端登陆post请求
     * 内容类型为json【Content-type：application/json】
     */
    public static void loginStoreShare() throws IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        RestTemplate restTemplate = new RestTemplate(RestTemplateConfiguration.generateHttpRequestFactory());
        String url = "https://stock.uat2-backend.feihe.com/login/doLogin";
        Map<String, String> param1 = new HashMap<>();
        param1.put("username", "mz_wuqiong");
        param1.put("password", "123wq!!!");
        param1.put("sourceUrl", "https://stock.uat2-backend.feihe.com/ui/retailforce_common/std?tab=retailforce_oms_pro.page.home_page_stock");
        // 发送JSON格式的POST请求
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String json = JSON.toJSONString(param1);
        HttpEntity<String> request = new HttpEntity<>(json, headers);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, request, String.class);

        // 获取响应数据
        HttpStatus status = responseEntity.getStatusCode();
        String responseBody = responseEntity.getBody();
        HttpHeaders resHeader = responseEntity.getHeaders();
        List<String> list = resHeader.get("Set-Cookie");
        String token = list.get(1);//1 = "XSRF-TOKEN=f2eb9460-5064-46a9-9ca0-7dd4846a21b5; Path=/; Secure"
        String cookie = list.get(2);//2 = "CZ-SESSION-PORTAL=ZTlmMzgwZWYtMmRjMC00OGFmLThlM2YtNjk4MzE2NjZiOTQw; Domain=uat2-backend.feihe.com; Path=/; Secure; HttpOnly"

        token = token.replace("XSRF-TOKEN=", "");
        token = token.replace("; Path=/", "");
        cookie.replace(" Domain=uat2-backend.feihe.com; Path=/", "");
        cookie = String.format("%s", token, cookie);
        STORE_SHARE_TOKEN = token;
        STORE_SHARE_COOKIE = cookie;
        log.info("token===={}", token);
        log.info("cookie===={}", cookie);
    }
}
