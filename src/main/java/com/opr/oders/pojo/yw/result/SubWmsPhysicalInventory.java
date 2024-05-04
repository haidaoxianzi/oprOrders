package com.opr.oders.pojo.yw.result;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Auther: gina
 * @Date: 2024-04-18
 * @Description:
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubWmsPhysicalInventory {
    public SubWmsPhysicalInventory(String availableQuantity, String batchNumber, String produceTimeDate, String deadlineTimeDate,
                                   String code,String value) {
//       可用库存
        this.availableQuantity = availableQuantity;
//        批号
        this.batchNumber = batchNumber;
        //生产日期 "2021-05-10"
        this.produceTimeDate = produceTimeDate;
        //生产效期 "2099-05-10"
        this.deadlineTimeDate = deadlineTimeDate;
        SubBatchExtProperty batchExtProperty = new SubBatchExtProperty();
        batchExtProperty.setCode(code);
        batchExtProperty.setValue(value);

        this.batchExtProperty = batchExtProperty;

    }

    //"2026-02-01 00:00:00"
    private String deadlineTime;
    //"2026-02-01"
    private String deadlineTimeDate;
    //"234915483672339348"
    private String goodsId;
    //"2024-02-02 00:00:00"
    private String produceTime;
    //"77,565"
    private String totalQuantityStr;
    //"77565"
    private String totalQuantityStr1;
    //"0"
    private String withholdingQuantity;
    //"2024031900000000000012"
    private String batchId;
    //"苏州线上仓_合格"
    private String warehouseName;
    //"77565"
    private String totalQuantity;
    //"O20240202"
    private String batchNumber;
    //"77565"
    private String availableQuantity;
    //"启用"
    private String batchEnable;
    //"77565"
    private String availableQuantity1;
    //"77565"
    private String totalQuantity1;
    //"77565"
    private String availableQuantityStr1;
    //"77,565"
    private String availableQuantityStr;
    //"0"
    private String withholdingQuantity1;
    //"0"
    private String withholdingQuantityStr1;
    //""
    private String goodsSpec;
    private SubBatchExtProperty batchExtProperty;
    //"1000000191"
    private String warehouseId;
    //"2024-02-02"
    private String produceTimeDate;
    //6013
    private Integer inventoryId;
    //"星妈测试物料XM001"
    private String goodsTitle;
    private SubValidTime validTime;
    //"0"
    private String withholdingQuantityStr;
    //"XM001"
    private String skuCode;
    //"放行"
    private String status;


}
