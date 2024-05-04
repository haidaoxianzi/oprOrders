package com.opr.oders.pojo.yw.rsenum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @Auther: gina
 * @Date: 2024-04-25
 * @Description:SourceFacotry
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum SourceFacotryEnum {
    SF_LONG_JIANG("10013","龙江","LONGJIANG", "飞鹤 (龙江)乳品有限公司飞鹤"),
    SF_ZHEN_LAI("10014","镇赉", "","飞鹤(镇赉)乳品有限公司飞鹤"),
    SF_BAI_QUAN("10015","拜泉", "SHG","飞鹤(拜泉)乳品有限公司"),
    SF_TAI_LAI("10016","泰来","", "飞鹤 (泰来)乳品有限公司飞鹤"),
    SF_JI_LIN("10017","吉林", "","飞鹤 (吉林)乳品有限公司飞鹤"),
    SF_KE_DONG("10018","克东","", "克东分公司"),
    SF_YE_NAI("10019","液奶", "","克东液态奶"),

    SF_HA_ER_BIN("11389","哈尔滨","HARBIN", "飞鹤 (哈尔滨)乳品有限公司"),//中央仓(含OEM) [哈尔滨电商仓-合格]
    SF_MI_FEN("12481","米粉", "","克东米粉厂"),
    SF_QI_QI_HA_ER("15241","齐齐哈尔","", "飞鹤(齐齐哈尔)乳品有限公司"),
    SF_SHAN_XI("15281","陕西","", "飞鹤 (陕西)乳品有限公司"),
    SF_GAN_NAN("10021","甘南","", "飞鹤 (甘南)乳品有限公司"),
    SF_RU_YE_COMPANY("10005","乳业","RUYE", "黑龙江飞鹤乳业有限公司"),
    SF_SELL_COMPANY("12661","销售公司","", "黑龙江飞鹤乳业销售有限公司"),
    SF_ZHU_HAI_HENG_QIN("10008","珠海横琴","", "珠海横琴星妈电子商务有限公司"),
    SF_MEI_WEI_SHI("10027","美维仕", "","美维仕 (北京)健康管理有限公司");

    private String code;
    private String sourceFactory;
    private String codeStr;
    private String desc;


    /* *
     * 根据code得到codeStr
     * @param code
     * @return
     */
    public static String getCodeStrByCode(String code) {
        for (SourceFacotryEnum codeEnum : SourceFacotryEnum.values()) {
            if (codeEnum.getCode() == code) {
                return codeEnum.getCodeStr();
            }
        }

        return "";
    }

}
