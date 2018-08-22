package com.market.bean.po;

public class Product {
    private Integer productId;
    private String productName;
    private String productType;
    private String productBrand;
    private String productColor;
    private String productModel;

    public Product() {
    }

    public Product(Integer productId, String productName, String productType, String productBrand, String productColor, String productModel) {
        this.productId = productId;
        this.productName = productName;
        this.productType = productType;
        this.productBrand = productBrand;
        this.productColor = productColor;
        this.productModel = productModel;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }

    public String getProductColor() {
        return productColor;
    }

    public void setProductColor(String productColor) {
        this.productColor = productColor;
    }

    public String getProductModel() {
        return productModel;
    }

    public void setProductModel(String productModel) {
        this.productModel = productModel;
    }
}
