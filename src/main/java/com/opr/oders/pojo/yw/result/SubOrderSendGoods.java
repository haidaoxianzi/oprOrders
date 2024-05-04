package com.opr.oders.pojo.yw.result;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.platform.commons.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: gina
 * @Date: 2024-04-26
 * @Description:发运订单列表数据，单条订单数据结构
 */
@Slf4j
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SubOrderSendGoods {

    private String orderNo;

    /**
     * 将 jsonArray  转 对象
     * jsonObj元素跟对象元素部分匹配
     *
     * @param jsonArray
     * @return
     * @throws Exception
     */
    public static List<SubOrderSendGoods> jsonArray2Bean(String jsonArray) {
        try {
            if (StringUtils.isBlank(jsonArray)) {
                throw new Exception("参数为空");
            }
            JSONArray jsonArr = new JSONArray(jsonArray);
            List<SubOrderSendGoods> orderSendGoodsList = new ArrayList<>();
            for (int i = 0; i < jsonArr.length(); i++) {
                JSONObject jsonObj = jsonArr.getJSONObject(i);
                String orderNo = jsonObj.getString("orderNo");

                SubOrderSendGoods orderSendGoods = new SubOrderSendGoods(orderNo);
                orderSendGoodsList.add(orderSendGoods);
            }
            return orderSendGoodsList;
        } catch (Exception e) {
            log.info("获取数据出现异常：" + e.getMessage() + ";" + jsonArray);
        }
        return null;
    }
}
