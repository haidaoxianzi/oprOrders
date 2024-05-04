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
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Auther: gina
 * @Date: 2024-04-17
 * @Description:WMS商品库存信息
 */
@Getter
@Setter
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
public class SubWMSGoodsStoreInfo {
    /**
     * 库存数量
     */
    private Integer fmQty;
    /**
     * 可用数量 todo 按可用数量倒序排
     */
    private Integer qtyAvailed;
    /**
     * 需求数量
     */
    private Integer qtySelect;

    /**
     * 质检状态 01 待检 ，02 放行，03 禁用，todo 对象列表按只过滤状态为02的字段
     */
    private String lotAtt08;
    /**
     * 生产日期
     */
    private String lotAtt01;
    /**
     * 失效日期
     */
    private String lotAtt02;

    /**
     * 批号，todo 得到的对象列表按批号滤空
     */
    private String lotAtt05;

    /**
     * 来源工厂 LONGJIANG：来源工厂 ； HARBIN：中央仓(含OEM) [哈尔滨电商仓-合格]; RUYE:乳业 ；SHG：拜泉 todo 按此滤空
     */
    private String lotAtt10;

    /**
     * 库位
     */
    private String locationId;


    private String lotNum;


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
            List<SubWMSGoodsStoreInfo> wmsGoodsStoreInfos = new ArrayList<>();
            for (int i = 0; i < jsonArr.length(); i++) {
                JSONObject jsonObj = jsonArr.getJSONObject(i);
                int fmQty = jsonObj.getInt("fmQty");
                int qtyAvailed = jsonObj.getInt("qtyAvailed");
                int qtySelect = jsonObj.getInt("qtySelect");

                //质检状态 01 待检 ，02 放行，03 禁用，todo 对象列表按只过滤状态为02的字段
                String lotAtt08 = jsonObj.getString("lotAtt08");
                if (StringUtils.isNotBlank(lotAtt08) && lotAtt08.equals("02")) {
                    //生产日期
                    String lotAtt01 = jsonObj.getString("lotAtt01");
                    //失效日期
                    String lotAtt02 = jsonObj.getString("lotAtt02");
                    //批号，todo 得到的对象列表按批号滤空
                    String lotAtt05 = jsonObj.getString("lotAtt05");
                    //库位
                    String locationId = jsonObj.getString("locationId");
                    if (StringUtils.isBlank(lotAtt05)) {
                        continue;
                    }
                    //来源工厂 LONGJIANG：来源工厂 ； HARBIN：中央仓(含OEM) [哈尔滨电商仓-合格]; RUYE:乳业 ；SHG：拜泉 todo 按此滤空
                    String lotAtt10 = jsonObj.getString("lotAtt10");
                    if (StringUtils.isBlank(lotAtt10)) {
                        continue;
                    }
                    String lotNum = jsonObj.getString("lotNum");
                    SubWMSGoodsStoreInfo t = new SubWMSGoodsStoreInfo(fmQty, qtyAvailed, qtySelect, lotAtt08, lotAtt01, lotAtt02, lotAtt05, lotAtt10, locationId, lotNum);
                    wmsGoodsStoreInfos.add(t);
                }
            }
            //按可用数量倒序排
            return wmsGoodsStoreInfos.stream().sorted(Comparator.comparing(SubWMSGoodsStoreInfo::getQtyAvailed).reversed()).collect(Collectors.toList());
        } catch (Exception e) {
            log.info("获取数据出现异常：" + e.getMessage() + ";" + jsonArray);
        }

        return null;
    }
}
