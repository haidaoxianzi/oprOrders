package com.opr.oders.common.Opr;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.SocketConfig;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: gina
 * @Date: 2024-04-17
 * @Description:
 */
@Slf4j
public class Constants4WMS {

    public static final String UAT2_WMS_Host = "http://120.133.27.48:18080";

    //uat2的oms对应wms的sit3环境
    public static final String SIT3_WMS_Host = "http://10.10.228.188:18080";

    //wms 登陆信息
    public static String WMS_COOKIE = "";

    /**
     * 库存共享端登陆post请求
     * 内容类型为json【Content-type：application/json】
     */
    public static void loginStoreShare() throws IOException {
        String url = "http://10.10.228.188:18080/logincenter/WmsLoginAction";
        Map<String, String> param1 = new HashMap<>();
        param1.put("username", "mz_wuqiong");
        param1.put("password", "123wq!!!");
        param1.put("sourceUrl", "https://stock.uat2-backend.feihe.com/ui/retailforce_common/std?tab=retailforce_oms_pro.page.home_page_stock");
        String json = JSON.toJSONString(param1);
        CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setConnectionTimeToLive(2000, TimeUnit.MILLISECONDS)
                .setDefaultSocketConfig(SocketConfig.custom().setSoTimeout(2000).build())
                .build();

        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader("Content-type", "application/json");
        CloseableHttpResponse response = null;

        try {
            if (!StringUtils.isEmpty(json)) {
                StringEntity postJson = new StringEntity(json, ContentType.APPLICATION_JSON);
                httpPost.setEntity(postJson);
            }
            response = httpClient.execute(httpPost);
            Header[] loginInfos = response.getHeaders("Set-Cookie");
            String cookie = loginInfos[2].getValue();
            WMS_COOKIE = cookie.replace(" Domain=uat2-backend.feihe.com; Path=/; HttpOnly", "");
            log.info("cookie==={}", WMS_COOKIE);
        } catch (Exception e) {
            log.error("HttpClientUtil httpPost error {}", e.getMessage(), e);
        } finally {
            response.close();
            httpClient.close();
        }
    }
}
