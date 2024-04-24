package com.opr.oders.pojo.yw.result;

/**
 * @Auther: gina
 * @Date: 2024-04-17
 * @Description:
 */
public class SubOrderBuyer {
    // "独立导单优选默认会员"
    private String name;
    //"User2e52d33b6e314c24909f1fe6e8e099fcd"
    private String memberName;
    //""
    private String memo;
    //    "U114548832050766279"
    private String buyerId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }
}
