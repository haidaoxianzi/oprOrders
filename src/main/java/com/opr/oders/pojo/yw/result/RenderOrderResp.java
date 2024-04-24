package com.opr.oders.pojo.yw.result;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Auther: gina
 * @Date: 2024-04-12
 * @Description:创单渲染接口返回结果 数据结构
 */

@Slf4j
@ToString
public class RenderOrderResp extends BaseResp {
    private static final Logger log = LoggerFactory.getLogger(RenderOrderResp.class);
    private SubRenderOrderResult result;
    private Boolean success;

    public SubRenderOrderResult getResult() {
        return result;
    }

    public void setResult(SubRenderOrderResult result) {
        this.result = result;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
