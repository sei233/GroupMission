package com.market.bean.po;

public class SecondGood {
    private Integer goodId;
    private String goodName;
    private Float adoptPrice;
    private Float marketPrice;
    private Float shopPrice;
    private Integer minNo;
    private Integer adopt;//0不可，1可以采购
    private String creatTime;
    private String updateTime;
    private String operator;
    private Integer typeId;
    private Integer brandId;
    private String goodModel;
    private String goodColor;
    private String brandName;
    private String typeName;

    public SecondGood() {
    }

    public SecondGood(Integer goodId, String goodName, Float adoptPrice, Float marketPrice, Float shopPrice, Integer minNo, Integer adopt, String creatTime, String updateTime, String operator, Integer typeId, Integer brandId, String goodModel, String goodColor, String brandName, String typeName) {
        this.goodId = goodId;
        this.goodName = goodName;
        this.adoptPrice = adoptPrice;
        this.marketPrice = marketPrice;
        this.shopPrice = shopPrice;
        this.minNo = minNo;
        this.adopt = adopt;
        this.creatTime = creatTime;
        this.updateTime = updateTime;
        this.operator = operator;
        this.typeId = typeId;
        this.brandId = brandId;
        this.goodModel = goodModel;
        this.goodColor = goodColor;
        this.brandName = brandName;
        this.typeName = typeName;
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

    public Float getAdoptPrice() {
        return adoptPrice;
    }

    public void setAdoptPrice(Float adoptPrice) {
        this.adoptPrice = adoptPrice;
    }

    public Float getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(Float marketPrice) {
        this.marketPrice = marketPrice;
    }

    public Float getShopPrice() {
        return shopPrice;
    }

    public void setShopPrice(Float shopPrice) {
        this.shopPrice = shopPrice;
    }

    public Integer getMinNo() {
        return minNo;
    }

    public void setMinNo(Integer minNo) {
        this.minNo = minNo;
    }

    public Integer getAdopt() {
        return adopt;
    }

    public void setAdopt(Integer adopt) {
        this.adopt = adopt;
    }

    public String getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(String creatTime) {
        this.creatTime = creatTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
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

    public String getGoodModel() {
        return goodModel;
    }

    public void setGoodModel(String goodModel) {
        this.goodModel = goodModel;
    }

    public String getGoodColor() {
        return goodColor;
    }

    public void setGoodColor(String goodColor) {
        this.goodColor = goodColor;
    }
}
