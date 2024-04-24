package com.opr.oders.ChangJing.demo.service;

/**
 * @Auther: gina
 * @Date: 2024-04-17
 * @Description:场景执行
 */
public interface SceneExecuteService {
    /**
     * 发货场景 ：
     *
     * 2、逆向：换货出库step2，补寄出库
     *
    * */


    /**
     * 发货场景1:正向订单发货
     * */
    public String sendGoods(String orderId);
}
