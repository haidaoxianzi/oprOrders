package com.opr.oders.pojo.yw.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Auther: gina
 * @Date: 2024-04-15
 * @Description:
 */
@ToString
public class SubGuideBuryingPoint {
    private String externalActivityChannelName="";
    private String externalActivityId="";
    private String externalActivityName="";

    public String getExternalActivityChannelName() {
        return externalActivityChannelName;
    }

    public void setExternalActivityChannelName(String externalActivityChannelName) {
        this.externalActivityChannelName = externalActivityChannelName;
    }

    public String getExternalActivityId() {
        return externalActivityId;
    }

    public void setExternalActivityId(String externalActivityId) {
        this.externalActivityId = externalActivityId;
    }

    public String getExternalActivityName() {
        return externalActivityName;
    }

    public void setExternalActivityName(String externalActivityName) {
        this.externalActivityName = externalActivityName;
    }
}
