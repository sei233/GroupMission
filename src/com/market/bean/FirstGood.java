package com.market.bean;

import java.util.List;

public class FirstGood {
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
    private int typeId;
    private int productId;
    private Product product;
    private String typeName;
    public FirstGood() {
    }

    public FirstGood(Integer goodId, String goodName, Float adoptPrice, Float marketPrice, Float shopPrice, Integer minNo, Integer adopt, String creatTime, String updateTime, String operator, int typeId, int productId, Product product, String typeName) {
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
        this.productId = productId;
        this.product = product;
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
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

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
    //    private List<String> list;//加载的是type表类型状态0的list（name）


}
