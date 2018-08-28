package com.market.bean.po;

public class Gift {
    private Integer giftId;
    private String giftName;
    private String giftModel;
    private Float giftPrice;
    private String giftColor;
    private Float adoptPrice;
    private String adoptDepartment;
    private Integer giftNumber;
    private String typeName;
    private String brandName;
    public Gift() {
    }
    public Gift(Integer giftId, String giftName, String giftModel, Float giftPrice, String giftColor, Float adoptPrice, String adoptDepartment, Integer giftNumber, String typeName, String brandName) {
        this.giftId = giftId;
        this.giftName = giftName;
        this.giftModel = giftModel;
        this.giftPrice = giftPrice;
        this.giftColor = giftColor;
        this.adoptPrice = adoptPrice;
        this.adoptDepartment = adoptDepartment;
        this.giftNumber = giftNumber;
        this.typeName = typeName;
        this.brandName = brandName;
    }
    public Integer getGiftId() {
        return giftId;
    }
    public void setGiftId(Integer giftId) {
        this.giftId = giftId;
    }
    public String getGiftName() {
        return giftName;
    }
    public void setGiftName(String giftName) {
        this.giftName = giftName;
    }
    public String getGiftModel() {
        return giftModel;
    }
    public void setGiftModel(String giftModel) {
        this.giftModel = giftModel;
    }
    public Float getGiftPrice() {
        return giftPrice;
    }
    public void setGiftPrice(Float giftPrice) {
        this.giftPrice = giftPrice;
    }
    public String getGiftColor() {
        return giftColor;
    }
    public void setGiftColor(String giftColor) {
        this.giftColor = giftColor;
    }
    public Float getAdoptPrice() {
        return adoptPrice;
    }
    public void setAdoptPrice(Float adoptPrice) {
        this.adoptPrice = adoptPrice;
    }
    public String getAdoptDepartment() {
        return adoptDepartment;
    }
    public void setAdoptDepartment(String adoptDepartment) {
        this.adoptDepartment = adoptDepartment;
    }
    public Integer getGiftNumber() {
        return giftNumber;
    }
    public void setGiftNumber(Integer giftNumber) {
        this.giftNumber = giftNumber;
    }
    public String getTypeName() {
        return typeName;
    }
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
    public String getBrandName() {
        return brandName;
    }
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
}
