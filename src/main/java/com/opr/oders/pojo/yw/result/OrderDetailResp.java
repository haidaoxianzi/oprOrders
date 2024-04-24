package com.opr.oders.pojo.yw.result;

/**
 * @Auther: gina
 * @Date: 2024-04-17
 * @Description:订单详情对象信息
 */
public class OrderDetailResp extends BaseResp {
    private SubOrderDetaiResult result;
    private boolean success;

    public SubOrderDetaiResult getResult() {
        return result;
    }

    public void setResult(SubOrderDetaiResult result) {
        this.result = result;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
