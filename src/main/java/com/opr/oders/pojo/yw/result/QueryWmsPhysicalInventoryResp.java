package com.opr.oders.pojo.yw.result;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @Auther: gina
 * @Date: 2024-04-18
 * @Description:
 */
@Slf4j
public class QueryWmsPhysicalInventoryResp extends BaseResp {
    private List<SubWmsPhysicalInventory> result;
    private Integer total;
    private boolean success;

    public List<SubWmsPhysicalInventory> getResult() {
        return result;
    }

    public void setResult(List<SubWmsPhysicalInventory> result) {
        this.result = result;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
