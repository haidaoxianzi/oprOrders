package com.opr.oders.common.Opr;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @Auther: gina
 * @Date: 2024-04-12
 * @Description:
 */
@Slf4j
public class CommonUtil {

    /**
     * 生成指定位数的随机数
     * * 入参：随机输入一个三位数即可到一个随机的三位数，eg: startNum = 246
    * @Param :startNum
    * @return java.lang.Long
    */
    public static Long genRandomNum(Long startNum) {
        int bitNum = Long.bitCount(startNum);
        Long MaxNum = 9L;
        Double minNum = Math.pow(10, bitNum);
        for (int i = 1; i <= bitNum; i++) {
            Double tmp = Math.pow(10, i);//10底数，i指数
            MaxNum += tmp.longValue() * 9;
        }
        return ThreadLocalRandom.current().nextLong(minNum.longValue(), MaxNum);
    }
}
