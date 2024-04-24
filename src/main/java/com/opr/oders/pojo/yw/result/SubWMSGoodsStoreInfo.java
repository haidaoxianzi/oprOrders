package com.opr.oders.pojo.yw.result;

import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.platform.commons.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: gina
 * @Date: 2024-04-17
 * @Description:WMS商品库存信息
 */
@Slf4j
public class SubWMSGoodsStoreInfo {
    private static final Logger log = LogManager.getLogger(SubWMSGoodsStoreInfo.class);
    private Integer fmQty;
    private Integer qtyAvailed;
    private Integer qtySelect;

    public SubWMSGoodsStoreInfo() {
    }

    public SubWMSGoodsStoreInfo(Integer fmQty, Integer qtyAvailed, Integer qtySelect) {
        this.fmQty = fmQty;
        this.qtyAvailed = qtyAvailed;
        this.qtySelect = qtySelect;
    }

    public Integer getFmQty() {
        return fmQty;
    }

    public void setFmQty(Integer fmQty) {
        this.fmQty = fmQty;
    }

    public Integer getQtyAvailed() {
        return qtyAvailed;
    }

    public void setQtyAvailed(Integer qtyAvailed) {
        this.qtyAvailed = qtyAvailed;
    }

    public Integer getQtySelect() {
        return qtySelect;
    }

    public void setQtySelect(Integer qtySelect) {
        this.qtySelect = qtySelect;
    }

    /**
     * 将 jsonArray  转 对象
     * jsonObj元素跟对象元素部分匹配
     *
     * @param jsonArray
     * @return
     * @throws Exception
     */
    public static List<SubWMSGoodsStoreInfo> jsonArray2Bean2(String jsonArray) {
        try {
            if (StringUtils.isBlank(jsonArray)) {
                throw new Exception("参数为空");
            }

            // String jsonArray = "[{\"name\":\"Alice\",\"age\":20},{\"name\":\"Bob\",\"age\":25}]";
            JSONArray jsonArr = new JSONArray(jsonArray);
            List<SubWMSGoodsStoreInfo> tList = new ArrayList<>();
            for (int i = 0; i < jsonArr.length(); i++) {
                JSONObject jsonObj = jsonArr.getJSONObject(i);
                int fmQty = jsonObj.getInt("fmQty");
                int qtyAvailed = jsonObj.getInt("qtyAvailed");
                int qtySelect = jsonObj.getInt("qtySelect");
                SubWMSGoodsStoreInfo t = new SubWMSGoodsStoreInfo(fmQty, qtyAvailed, qtySelect);
                tList.add(t);
            }
            return tList;
        } catch (Exception e) {
            log.info("获取数据出现异常：" + e.getMessage() + ";" + jsonArray);
        }

        return null;
    }
}
