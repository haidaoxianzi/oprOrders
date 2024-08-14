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
 * @Date: 2024-04-12
 * @Description:常量池
 */
@Slf4j
public class Constants4OMS {
    public static final String FH01_Host = "http://fh01.retailforce.uat2.feihe.com";
    public static final String FH01_UAT2_Host = "http://fh01.uat2.feihe.com";

    public static final String UAT2_OMS_Host = "https://uat2-backend.feihe.com";

    public static String OMS_TOKEN;
    public static String Cookie;

    /**
     * oms 登陆post请求
     * 内容类型为json【Content-type：application/json】
     */
    public static void loginOMS() throws IOException {
        String url = "https://uat2-backend.feihe.com/login/doLogin";
        Map<String, String> param1 = new HashMap<>();
        param1.put("username", "mz_wuqiong");
        param1.put("password", "123wq!!!");
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
            String token = loginInfos[1].getValue();
            String cookie = loginInfos[2].getValue();
            token = token.replace("XSRF-TOKEN=", "");

            OMS_TOKEN = token.replace("; Path=/", "");
            Cookie = cookie.replace(" Domain=uat2-backend.feihe.com; Path=/; HttpOnly", "XSRF-TOKEN=" + token);
            log.info("token==={},cookie==={}", token, cookie);
        } catch (Exception e) {
            log.error("HttpClientUtil httpPost error {}", e.getMessage(), e);
        } finally {
            response.close();
            httpClient.close();
        }
    }

}
