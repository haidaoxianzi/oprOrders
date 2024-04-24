package com.opr.oders.common.httpclient;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.opr.oders.common.Opr.Constants4WMS;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.SocketConfig;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


@Slf4j
public class HttpClientUtil {


    /**
     * post请求
     * 内容类型为json【Content-type：application/json】
     * */
    public static JSONObject post(String url, String json, String cookie, String token) throws IOException {

        CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setConnectionTimeToLive(2000, TimeUnit.MILLISECONDS)
                .setDefaultSocketConfig(SocketConfig.custom().setSoTimeout(2000).build())
                .build();

        HttpPost httpPost = new HttpPost(url);

        if (StringUtils.hasLength(cookie)) {
            httpPost.setHeader("Cookie", cookie);
        }
        if (StringUtils.hasLength(token)) {
            httpPost.setHeader("X-XSRF-TOKEN", token);
        }
        httpPost.setHeader("Content-type", "application/json");
        CloseableHttpResponse response = null;

        try {
            StringEntity postJson = new StringEntity(json, ContentType.APPLICATION_JSON);

            httpPost.setEntity(postJson);

            response = httpClient.execute(httpPost);

            JSONObject jsonObject = JSON.parseObject(EntityUtils.toString(response.getEntity(), "utf-8"));
            //log.info("HttpClientUtil  httpPost request:{},result:{}", json, jsonObject.toJSONString());
            return jsonObject;

        } catch (Exception e) {
            log.error("HttpClientUtil httpPost error {}", e.getMessage(), e);
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
                httpClient.close();
            } catch (IOException e) {
                log.error("HttpClientUtil httpPost close error", e);
                new Exception("HttpClientUtil httpPost close error222", e);
            }
        }
        return new JSONObject();
    }

    /**
     * get请求
     * 内容类型为json【Content-type：application/json】
     * */
    public static JSONObject get(String url, HttpParams params, String cookie, String token) throws IOException {

        CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setConnectionTimeToLive(2000, TimeUnit.MILLISECONDS)
                .setDefaultSocketConfig(SocketConfig.custom().setSoTimeout(2000).build())
                .build();
        //HttpClient httpClient = HttpClientBuilder.create().build();


        HttpGet httpParamGet = new HttpGet(url);
        httpParamGet.setHeader("Cookie", cookie);
        httpParamGet.setHeader("X-XSRF-TOKEN", token);
        httpParamGet.setHeader("Content-type", "application/json");
        CloseableHttpResponse response = null;

        try {
            httpParamGet.setParams(params);
            response = httpClient.execute(httpParamGet);
            JSONObject jsonObject = JSON.parseObject(EntityUtils.toString(response.getEntity(), "utf-8"));
            log.info("HttpClientUtil  httpGet requestData:{},result:{}", JSON.toJSONString(params), jsonObject.toJSONString());
            return jsonObject;

        } catch (Exception e) {
            log.error("HttpClientUtil httpGet error", e);
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
                httpClient.close();
            } catch (IOException e) {
                log.error("HttpClientUtil httpGet close error", e);
            }
        }
        return new JSONObject();
    }

    /**
     * post请求
     * 内容类型为表单提交【Content-type：application/x-www-form-urlencoded;charset=UTF-8】
     * */
    public static JSONObject post4FormCommit(String url, String param, String cookie, String token) throws IOException {

        CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setConnectionTimeToLive(2000, TimeUnit.MILLISECONDS)
                .setDefaultSocketConfig(SocketConfig.custom().setSoTimeout(2000).build())
                .build();

        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader("Cookie", cookie);
        httpPost.setHeader("Content-type", "application/x-www-form-urlencoded;charset=UTF-8");
        httpPost.setHeader("Connection", "keep-alive");
        httpPost.setHeader("Cookie", Constants4WMS.Cookie);
        httpPost.setHeader("Accept", "text/plain,*/*;q=0.01");
        httpPost.setHeader("Accept-Encoding", "gzip,deflate");
        httpPost.setHeader("Accept-Language", "zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2");
        httpPost.setHeader("Host", "120.133.27.48:18080");
        httpPost.setHeader("Origin", "http://120.133.27.48:18080");
        httpPost.setHeader("Referer", "http://120.133.27.48:18080/logincenter/wms_workplace");
        httpPost.setHeader("User-Agent", "Mozilla/5.0(Macintosh;Intel Mac OS X 10.15;rv:124.0)Gecko/20100101 Firefox/124.0");
        httpPost.setHeader("X-Requested-With", "XMLHttpRequest");

        CloseableHttpResponse response = null;
        try {
            StringEntity postParam = new StringEntity(param, ContentType.APPLICATION_FORM_URLENCODED);

            httpPost.setEntity(postParam);
            response = httpClient.execute(httpPost);

            JSONObject jsonObject = JSON.parseObject(EntityUtils.toString(response.getEntity(), "utf-8"));
            log.info("HttpClientUtil  post4FormCommit request:{},result:{}", param, jsonObject.toJSONString());
            return jsonObject;

        } catch (Exception e) {
            log.error("HttpClientUtil  post4FormCommit error {}", e.getMessage(), e);
            new Exception("HttpClientUtil post4FormCommit close error1", e);
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
                httpClient.close();
            } catch (IOException e) {
                log.error("HttpClientUtil post4FormCommit close error", e);
                new Exception("HttpClientUtil post4FormCommit close error222", e);
            }
        }
        return new JSONObject();
    }
}
