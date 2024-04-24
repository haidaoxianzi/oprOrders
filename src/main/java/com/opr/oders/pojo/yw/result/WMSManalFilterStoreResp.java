package com.opr.oders.pojo.yw.result;

import java.util.List;

/**
 * @Auther: gina
 * @Date: 2024-04-17
 * @Description:
 */
public class WMSManalFilterStoreResp extends BaseResp {
    List<SubWMSGoodsStoreInfo> list;

    public List<SubWMSGoodsStoreInfo> getList() {
        return list;
    }

    public void setList(List<SubWMSGoodsStoreInfo> list) {
        this.list = list;
    }
}
