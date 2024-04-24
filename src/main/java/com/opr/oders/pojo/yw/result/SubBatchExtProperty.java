package com.opr.oders.pojo.yw.result;

/**
 * @Auther: gina
 * @Date: 2024-04-18
 * @Description:
 */
public class SubBatchExtProperty {

    //"batchExtProperty_1"
    private String extCode;
    //"source_facotry"
    private String code;
    //"source_facotry"
    private String name;
    //1
    private Integer type;
    //"10005"
    private String value;

    public String getExtCode() {
        return extCode;
    }

    public void setExtCode(String extCode) {
        this.extCode = extCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
