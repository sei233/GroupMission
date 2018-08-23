package com.market.bean.vo;

import com.market.bean.po.Application;

public class ApplicationVo {
    private Application app;
    private String outSign;
    private String approvalState;

    public String getOutSign() {
        return outSign;
    }

    public void setOutSign(String outSign) {
        this.outSign = outSign;
    }

    public String getApprovalState() {
        return approvalState;
    }

    public void setApprovalState(String approvalState) {
        this.approvalState = approvalState;
    }

    public Application getApp() {
        return app;
    }

    public void setApp(Application app) {
        this.app = app;
        if(app.getAntiOutSign()==0){
            this.outSign="未出库";
        }else if(app.getAntiOutSign()==1){
            this.outSign="已出库";
        }


        if(app.getApprovalState()==0){
            this.approvalState="未审批";
        }else if(app.getApprovalState()==1){
            this.approvalState="不通过";
        }else if(app.getApprovalState()==2){
            this.approvalState="审批通过";
        }
    }
}
