package com.market.bean.po;

import java.util.Date;

public class ActivityAPC {
    private Integer activityId;
    private String activityName;
    private Date beginTime;
    private Date endTime;
    private Integer goodId;
    private String goodName;
    private Float goodPrice;
    private Integer activityNumber;
    private Integer priceRange;
    private Float activityPrice;
    private String reason;
    private String remarks;
    private Integer approveState;//012345
    private String approveComment;
    private Date approveDate;

    public ActivityAPC() {
    }

    public ActivityAPC(Integer activityId, String activityName, Date beginTime, Date endTime, Integer goodId, String goodName, Float goodPrice, Integer activityNumber, Integer priceRange, Float activityPrice, String reason, String remarks, Integer approveState, String approveComment, Date approveDate) {
        this.activityId = activityId;
        this.activityName = activityName;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.goodId = goodId;
        this.goodName = goodName;
        this.goodPrice = goodPrice;
        this.activityNumber = activityNumber;
        this.priceRange = priceRange;
        this.activityPrice = activityPrice;
        this.reason = reason;
        this.remarks = remarks;
        this.approveState = approveState;
        this.approveComment = approveComment;
        this.approveDate = approveDate;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public Float getGoodPrice() {
        return goodPrice;
    }

    public void setGoodPrice(Float goodPrice) {
        this.goodPrice = goodPrice;
    }

    public Integer getActivityNumber() {
        return activityNumber;
    }

    public void setActivityNumber(Integer activityNumber) {
        this.activityNumber = activityNumber;
    }

    public Integer getPriceRange() {
        return priceRange;
    }

    public void setPriceRange(Integer priceRange) {
        this.priceRange = priceRange;
    }

    public Float getActivityPrice() {
        return activityPrice;
    }

    public void setActivityPrice(Float activityPrice) {
        this.activityPrice = activityPrice;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getApproveState() {
        return approveState;
    }

    public void setApproveState(Integer approveState) {
        this.approveState = approveState;
    }

    public String getApproveComment() {
        return approveComment;
    }

    public void setApproveComment(String approveComment) {
        this.approveComment = approveComment;
    }

    public Date getApproveDate() {
        return approveDate;
    }

    public void setApproveDate(Date approveDate) {
        this.approveDate = approveDate;
    }
}
