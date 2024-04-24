package com.opr.oders.pojo.yw.request;

import com.alibaba.fastjson.JSONObject;
import com.opr.oders.pojo.auto.RenderOrderParamDataModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: gina
 * @Date: 2024-04-12
 * @Description:创单渲染接口：param模型
 */
/*@Getter
@Setter*/
@Slf4j
public class RenderOrder {
    private static final Logger log = LoggerFactory.getLogger(RenderOrder.class);
    private SubBuyerParamDTO buyerParamDTO;
    private SubExtraParams extraParams;
    private List<SubItemParamDTO> itemParamDTOList;
    private SubSourceParamDTO sourceParamDTO;

    public SubBuyerParamDTO getBuyerParamDTO() {
        return buyerParamDTO;
    }

    public void setBuyerParamDTO(SubBuyerParamDTO buyerParamDTO) {
        this.buyerParamDTO = buyerParamDTO;
    }

    public SubExtraParams getExtraParams() {
        return extraParams;
    }

    public void setExtraParams(SubExtraParams extraParams) {
        this.extraParams = extraParams;
    }

    public List<SubItemParamDTO> getItemParamDTOList() {
        return itemParamDTOList;
    }

    public void setItemParamDTOList(List<SubItemParamDTO> itemParamDTOList) {
        this.itemParamDTOList = itemParamDTOList;
    }

    public SubSourceParamDTO getSourceParamDTO() {
        return sourceParamDTO;
    }

    public void setSourceParamDTO(SubSourceParamDTO sourceParamDTO) {
        this.sourceParamDTO = sourceParamDTO;
    }

    public static String genRenderOrderParam() {

        //todo 参数化模型数据填充，一般从文档里获取
        RenderOrderParamDataModel paramModelData = new RenderOrderParamDataModel("CRM000000000050251048", "622326341145331589", "3878890707607", "622326341153718477", "FH11300003327");

        RenderOrder renderOrder = new RenderOrder();
        renderOrder.setBuyerParamDTO(new SubBuyerParamDTO(paramModelData.getBuyerId()));
        renderOrder.setExtraParams(new SubExtraParams(paramModelData.getBuyerId(),"0","0","0"));


        List<SubItemParamDTO> itemParamDTOList = new ArrayList<>();
        SubItemParamDTO subItemParamDTO = new SubItemParamDTO();
        subItemParamDTO.setItemId(paramModelData.getItemId());
        subItemParamDTO.setOuterId(paramModelData.getOuterId());
        subItemParamDTO.setSkuId(paramModelData.getSkuId());
        subItemParamDTO.setExtraParams(new SubItemParamDTOExtParams());
        itemParamDTOList.add(subItemParamDTO);
        renderOrder.setItemParamDTOList(itemParamDTOList);

        renderOrder.setSourceParamDTO(new SubSourceParamDTO(paramModelData.getOpenId()));
        //字符串转成json串
        String jsonString = JSONObject.toJSONString(renderOrder);
        log.info("genRequestParam param:{}", jsonString);

        return jsonString;
    }
}
