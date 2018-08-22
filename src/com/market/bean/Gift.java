package com.market.bean;

public class Gift {
    private Integer giftId;
    private String giftName;
    private String giftModel;
    private String giftColor;
    private Float giftPrice;
    private Integer typeId;
    private Integer brandId;
    private Integer minNo;
    private Float giftCost;
    private String giftDepartment;
    private String brandName;
    private String typeName;

    public Gift() {
    }

    public Gift(Integer giftId, String giftName, String giftModel, String giftColor, Float giftPrice, Integer typeId, Integer brandId, Integer minNo, Float giftCost, String giftDepartment, String brandName, String typeName) {
        this.giftId = giftId;
        this.giftName = giftName;
        this.giftModel = giftModel;
        this.giftColor = giftColor;
        this.giftPrice = giftPrice;
        this.typeId = typeId;
        this.brandId = brandId;
        this.minNo = minNo;
        this.giftCost = giftCost;
        this.giftDepartment = giftDepartment;
        this.brandName = brandName;
        this.typeName = typeName;
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

    public String getGiftColor() {
        return giftColor;
    }

    public void setGiftColor(String giftColor) {
        this.giftColor = giftColor;
    }

    public Float getGiftPrice() {
        return giftPrice;
    }

    public void setGiftPrice(Float giftPrice) {
        this.giftPrice = giftPrice;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public Integer getMinNo() {
        return minNo;
    }

    public void setMinNo(Integer minNo) {
        this.minNo = minNo;
    }

    public Float getGiftCost() {
        return giftCost;
    }

    public void setGiftCost(Float giftCost) {
        this.giftCost = giftCost;
    }

    public String getGiftDepartment() {
        return giftDepartment;
    }

    public void setGiftDepartment(String giftDepartment) {
        this.giftDepartment = giftDepartment;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
