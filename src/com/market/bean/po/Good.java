package com.market.bean.po;

import java.util.Date;

public class Good {
    private int goodId;
    private String goodName;
    private String goodType;
    private String goodBrand;
    private String goodModel;
    private String goodColor;
    private Integer goodRank;//商品等级
    private Float goodAdoptPrice;
    private Float goodMarketPrice;
    private Float goodShopPrice;
    private int goodNumber;//库存
    private Date creatTime;
    private Date updateTime;
    private String operator;


    public Good() {
    }

    public Good(int goodId, String goodName, String goodType, String goodBrand, String goodModel, String goodColor, Integer goodRank, Float goodAdoptPrice, Float goodMarketPrice, Float goodShopPrice, int goodNumber, Date creatTime, Date updateTime, String operator) {
        this.goodId = goodId;
        this.goodName = goodName;
        this.goodType = goodType;
        this.goodBrand = goodBrand;
        this.goodModel = goodModel;
        this.goodColor = goodColor;
        this.goodRank = goodRank;
        this.goodAdoptPrice = goodAdoptPrice;
        this.goodMarketPrice = goodMarketPrice;
        this.goodShopPrice = goodShopPrice;
        this.goodNumber = goodNumber;
        this.creatTime = creatTime;
        this.updateTime = updateTime;
        this.operator = operator;
    }

    public Float getGoodAdoptPrice() {
        return goodAdoptPrice;
    }

    public void setGoodAdoptPrice(Float goodAdoptPrice) {
        this.goodAdoptPrice = goodAdoptPrice;
    }

    public Float getGoodMarketPrice() {
        return goodMarketPrice;
    }

    public void setGoodMarketPrice(Float goodMarketPrice) {
        this.goodMarketPrice = goodMarketPrice;
    }

    public Float getGoodShopPrice() {
        return goodShopPrice;
    }

    public void setGoodShopPrice(Float goodShopPrice) {
        this.goodShopPrice = goodShopPrice;
    }

    public int getGoodNumber() {
        return goodNumber;
    }

    public void setGoodNumber(int goodNumber) {
        this.goodNumber = goodNumber;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public int getGoodId() {
        return goodId;
    }

    public void setGoodId(int goodId) {
        this.goodId = goodId;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public String getGoodType() {
        return goodType;
    }

    public void setGoodType(String goodType) {
        this.goodType = goodType;
    }

    public String getGoodBrand() {
        return goodBrand;
    }

    public void setGoodBrand(String goodBrand) {
        this.goodBrand = goodBrand;
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

    public Integer getGoodRank() {
        return goodRank;
    }

    public void setGoodRank(Integer goodRank) {
        this.goodRank = goodRank;
    }
}
