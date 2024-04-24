package com.opr;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
//import com.iflytek.Common.*;
//import static com.iflytek.Common.Const.*;
/**
 * @Auther: gina
 * @Date: 2024-04-12
 * @Description:java + testNG测试框架搭建–HTTP层接口应用
 */

//@AEnv(dataDiffEnv = false)
//阅读书库类型查询
public class ReadBookTypeListTest  {//extends AbstractHttpTests

    //private LoginGetToken loginGetToken = new LoginGetToken();
  /*  public String LoginToken=null;
    @BeforeClass
    public void init() {
        LoginToken = loginGetToken.LoginGetTokenTest(domesticAPP_appId_Online, "domestic_student");
    }*/

    @Test()
    /*获取书本接口测试用例*/
    public  void getReadBookTypeList() {
        RestTemplate restTemplate = new RestTemplate();
        // 请求网址
        String url ="https://xxxxxx/xx/xxx/readBook/getReadBookTypeList";
        //请求报文
        HttpHeaders headers = new HttpHeaders();
        headers.add("S-Auth-AppId","qqzw_domestic_app_services_prod");
        headers.add("S-Auth-GroupId","62043c66e14c4b8b9a42c6c19c40fadd");
        headers.add("S-Auth-Signature","JlK2CAhnpqB2oiXn13nKbWWR+SStkQ8O+8MdGI/3Au4=");
        headers.add("S-Auth-Nonce","e94b4afb-e410-47b8-9e96-6a5a621fcea0");
        headers.add("S-Auth-Timestamp","1610593431860");
        headers.add("S-Auth-Version","1");
        headers.add("S-SDK-Version","1.0.6");
        headers.add("S-Auth-Stage","RELEASE");
        headers.add("Content-Type","application/x-www-form-urlencoded;charset=UTF-8");
        headers.add("Connection","Keep-Alive");
       // headers.add("User-Agent","ShieldAndroidSDK");
        //请求参数
        Map map = new HashMap(); //dubbo层接口参数类型，参照接口测试文档  {"key1":value1,"key2":value2}
        map.put("token", null);//LoginToken
//        map.put("clientType", "android");
        map.put("appCode", "domestic_student");
        map.put("role", "0");

        //将接口参数转化json格式,并赋值给params
        MultiValueMap<String, Object> postParameters = new LinkedMultiValueMap();
        postParameters.add("params", JSON.toJSONString(map));

        HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<>(postParameters, headers);
        JSONObject response = restTemplate.postForObject(url, request, JSONObject.class);  //发送请求
        System.out.println(response);  //打印响应结果
        //断言比较响应结果的正确性
        Assert.assertEquals(response.getString("message"), "成功");
        Assert.assertEquals(response.getJSONArray("returnValue").size(), 3);
        Assert.assertEquals(response.getJSONArray("returnValue").getJSONObject(0).get("name"), "童话绘本");
        Assert.assertEquals(response.getJSONArray("returnValue").getJSONObject(1).get("name"), "传统美德故事");
        Assert.assertEquals(response.getJSONArray("returnValue").getJSONObject(2).get("name"), "少年中国梦");

    }

}

