package com.opr.oders.pojo.yw.result;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.platform.commons.util.StringUtils;

import java.io.Serializable;
import java.util.List;

/**
 * @Auther: gina
 * @Date: 2024-04-17
 * @Description:
 */
@Slf4j
public class BaseResp implements Serializable {
    private String msg;
    private Boolean isSuccess;

    public BaseResp() {
    }

    public BaseResp(boolean isSuccess, String msg) {
        this.isSuccess=isSuccess;
        this.msg=msg;
    }

    /**
     * 将jsonObj 数据转换成 bean
     *
     * @param jsonObject
     * @return
     * @throws Exception
     */
    public static <T> T jsonObject2Bean(JSONObject jsonObject, Class<T> clazz) {
        try {
            if (jsonObject == null) {
                throw new Exception("参数为空");
            }
            T dto = JSONObject.toJavaObject(jsonObject, clazz);
            //  T dto =  JSONObject.parseObject(jsonObject.toJSONString(), clazz);
            return dto;
        } catch (Exception e) {
            log.info("获取数据出现异常：" + e.getMessage() + ";" + jsonObject);

        }
        return null;
    }

    /**
     * 将 jsonStr 数据转换成 bean
     *
     * @param jsonStr
     * @return
     * @throws Exception
     */
    public static <T> T jsonStr2Bean(String jsonStr, Class<T> clazz) {
        try {
            if (StringUtils.isBlank(jsonStr)) {
                throw new Exception("参数为空");
            }
            T dto = JSONObject.parseObject(jsonStr, clazz);
            return dto;
        } catch (Exception e) {
            log.info("获取数据出现异常：" + e.getMessage() + ";" + jsonStr);

        }
        return null;
    }


    /**
     * 将 jsonArray  转 对象
     * jsonObj元素跟对象元素完全匹配
     *
     * @param jsonArray
     * @return
     * @throws Exception
     */
    public static <T> List<T> jsonArray2Bean(String jsonArray, Class<T> clazz) {
        try {
            if (StringUtils.isBlank(jsonArray)) {
                throw new Exception("参数为空");
            }
            //String jsonArray = "[{\"name\":\"Alice\",\"age\":20},{\"name\":\"Bob\",\"age\":25}]";
            ObjectMapper objectMapper = new ObjectMapper();
            List<T> dtoList = objectMapper.readValue(jsonArray, new TypeReference<List<T>>() {
            });

            return dtoList;
        } catch (Exception e) {
            log.info("获取数据出现异常：" + e.getMessage() + ";" + jsonArray);

        }
        return null;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Boolean getSuccess() {
        return isSuccess;
    }

    public void setSuccess(Boolean success) {
        isSuccess = success;
    }
}
