package com.opr.oders.pojo.yw.request;

import org.springframework.util.StringUtils;

/**
 * @Auther: gina
 * @Date: 2024-04-17
 * @Description:库存共享枚举类
 */
public enum StoreShareEnum {
    SUZHOU_ONLINE_STORE("1000000191", "419", "苏州电商仓");
    private String storeShareWarehouseId;
    private String OmsWarehouseIds;
    private String OmsWarehouseName;

    StoreShareEnum(String storeShareWarehouseId, String omsWarehouseIds, String omsWarehouseName) {
        this.storeShareWarehouseId = storeShareWarehouseId;
        OmsWarehouseIds = omsWarehouseIds;
        OmsWarehouseName = omsWarehouseName;
    }

    /**
     *
     * @param storeShareWarehouseId
     * @return
     */
    public static String getStoreShareWarehouseId(String storeShareWarehouseId) {
        if (StringUtils.isEmpty(storeShareWarehouseId)) {
            return null;
        }
        for (StoreShareEnum btnTypeEnum : StoreShareEnum.values()) {
            if (  btnTypeEnum.getOmsWarehouseIds().equals(storeShareWarehouseId)) {
                return btnTypeEnum.getStoreShareWarehouseId();
            }
        }
        return null;
    }

    public String getStoreShareWarehouseId() {
        return storeShareWarehouseId;
    }

    public void setStoreShareWarehouseId(String storeShareWarehouseId) {
        this.storeShareWarehouseId = storeShareWarehouseId;
    }

    public String getOmsWarehouseIds() {
        return OmsWarehouseIds;
    }

    public void setOmsWarehouseIds(String omsWarehouseIds) {
        OmsWarehouseIds = omsWarehouseIds;
    }

    public String getOmsWarehouseName() {
        return OmsWarehouseName;
    }

    public void setOmsWarehouseName(String omsWarehouseName) {
        OmsWarehouseName = omsWarehouseName;
    }
}
