package com.opr.oders.KuCunShare.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.opr.oders.KuCunShare.service.BatchStockService;
import com.opr.oders.common.Opr.Constants4StoreShare;
import com.opr.oders.common.httpclient.HttpClientUtil;
import com.opr.oders.pojo.yw.request.StoreShareEnum;
import com.opr.oders.pojo.yw.result.QueryWmsPhysicalInventoryResp;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.SocketConfig;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.net.ssl.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: gina
 * @Date: 2024-04-17
 * @Description:
 */
@SpringBootTest
@Slf4j
class BatchStockServiceImplTest {

    @Resource
    private BatchStockService batchStockService;

    @Test
    void queryWmsPhysicalInventory() {
        // String warehouseIds = "1000000191";
        String skuCodeStr = "XM001";
        batchStockService.queryWmsPhysicalInventory(StoreShareEnum.SUZHOU_ONLINE_STORE.getOmsWarehouseIds(), skuCodeStr);
    }

    /**
     * 查询批次库存接口单元测试
     */
    @Test
    void queryBatchStore() {

        //String url = Constants4StoreShare.UAT2_STORE_HOST + Constants4StoreShare.QUERY_WMS_PHYSICAL_INVENTORY;
        String url = "https://stock.uat2-backend.feihe.com/api/erp_wms/queryWmsPhysicalInventory";
        /*  {"_fields":[],"start":0,"limit":20,"haveTotalQuantity":"true","warehouseIdList":["1000000191"],"skuCodeStr":"XM001","batchEnable":"1","status":"1"}*/

        Map<String, Object> paramMap = new HashMap<>();
        List _fields = new ArrayList();
        paramMap.put("_fields", _fields);
        paramMap.put("start", 0);
        paramMap.put("limit", 20);
        paramMap.put("haveTotalQuantity", "true");
        List<String> warehouseIdList = new ArrayList<>();
        warehouseIdList.add(StoreShareEnum.getStoreShareWarehouseId("1000000191"));//枚举做适配 1000000191
        paramMap.put("warehouseIdList", warehouseIdList);
        paramMap.put("skuCodeStr", "XM001");
        paramMap.put("batchEnable", "1");
        paramMap.put("status", "1");
        String paramJSonStr = JSON.toJSONString(paramMap);
        log.info("queryWmsPhysicalInventory paramJSonStr={}", paramJSonStr);

        try {
            JSONObject jsonObj = HttpClientUtil.post(url, paramJSonStr, Constants4StoreShare.STORE_SHARE_COOKIE, Constants4StoreShare.STORE_SHARE_TOKEN);

            // String bizDataStr = jsonObj.getString("bizData");
            QueryWmsPhysicalInventoryResp wmsPhysicalInventoryResp = QueryWmsPhysicalInventoryResp.jsonObject2Bean(jsonObj, QueryWmsPhysicalInventoryResp.class);
            log.info("QueryWmsPhysicalInventoryResp jsonObj==={}", jsonObj.toJSONString());
            log.info("wmsPhysicalInventoryResp==={}", JSON.toJSONString(wmsPhysicalInventoryResp));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

   //@BeforeEach
   void test0()  {
        System.out.println("X509TrustManager=======start");

        try {
            TrustManager[] trustAllCerts = new TrustManager[]{
                    new X509TrustManager() {
                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                            return null;
                        }

                        public void checkClientTrusted(X509Certificate[] certs, String authType) {
                        }

                        public void checkServerTrusted(X509Certificate[] certs, String authType) {
                        }
                    }
            };
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

        } catch (Exception e) {
           log.error("报错了",e);
        }finally {
            System.out.println("X509TrustManager=======end");
        }
   }

   //@BeforeEach
    void test11(){
       System.out.println("X509TrustManager=======start");

       try {
           TrustManager[] trustAllCerts = new TrustManager[]{
                   new X509TrustManager() {
                       public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                           return null;
                       }

                       public void checkClientTrusted(X509Certificate[] certs, String authType) {
                       }

                       public void checkServerTrusted(X509Certificate[] certs, String authType) {
                       }
                   }
           };
           SSLContext sc = SSLContext.getInstance("TLS");
           sc.init(null, trustAllCerts, new java.security.SecureRandom());
           HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

       } catch (Exception e) {
           log.error("报错了",e);
       }finally {
           System.out.println("X509TrustManager=======end");
       }
        log.error("test11....start");

        try {
            TrustManagerFactory tmf = TrustManagerFactory
                    .getInstance(TrustManagerFactory.getDefaultAlgorithm());

            KeyStore ks  = KeyStore.getInstance("BCFKS");
            ks.load(new FileInputStream("/Library/Java/JavaVirtualMachines/jdk1.8.0_361.jdk/Contents/Home/jre/lib/security/cacerts"), "123wq!!!".toCharArray());
            tmf.init(ks);

            // Get hold of the trust manager
            X509TrustManager x509Tm = null;
            for (TrustManager tm : tmf.getTrustManagers()) {
                if (tm instanceof X509TrustManager) {
                    x509Tm = (X509TrustManager) tm;
                    break;
                }
            }
        } catch (Exception e) {
            log.error("error....",e);
        }finally {
            log.error("test11....end");
        }
    }
    /**
     * 证书问题调试
     */
    @Test
    void testPost() {

        // 代码放到这里 可以使用相对路径
/*        System.setProperty("javax.net.ssl.trustStore", "/Library/Java/JavaVirtualMachines/jdk1.8.0_361.jdk/Contents/Home/jre/lib/security/cacerts");
        System.setProperty("javax.net.ssl.trustStorePassword", "123wq!!!");*/
        String url = "https://stock.uat2-backend.feihe.com/api/erp_wms/queryWmsPhysicalInventory";

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


        CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setConnectionTimeToLive(2000, TimeUnit.MILLISECONDS)
                .setDefaultSocketConfig(SocketConfig.custom().setSoTimeout(2000).build())
                .build();


        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader("Cookie", Constants4StoreShare.STORE_SHARE_COOKIE);
        httpPost.setHeader("X-XSRF-TOKEN", Constants4StoreShare.STORE_SHARE_TOKEN);
        httpPost.setHeader("Content-type", "application/json");
        CloseableHttpResponse response = null;

        try {
            StringEntity postJson = new StringEntity(paramJSonStr, ContentType.APPLICATION_JSON);

            httpPost.setEntity(postJson);
            response = httpClient.execute(httpPost);

            //  JSONObject jsonObject = JSON.parseObject(EntityUtils.toString(response.getEntity(), "utf-8"));
            log.info("response==={}", response);

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
    }

}