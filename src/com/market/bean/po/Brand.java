package com.market.bean.po;

public class Brand {
    private Integer brandId;
    private String brandName;
    private String brandDescribe;
    private String brandWeb;

    public Brand() {
    }

    public Brand(Integer brandId, String brandName, String brandDescribe, String brandWeb) {
        this.brandId = brandId;
        this.brandName = brandName;
        this.brandDescribe = brandDescribe;
        this.brandWeb = brandWeb;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandDescribe() {
        return brandDescribe;
    }

    public void setBrandDescribe(String brandDescribe) {
        this.brandDescribe = brandDescribe;
    }

    public String getBrandWeb() {
        return brandWeb;
    }

    public void setBrandWeb(String brandWeb) {
        this.brandWeb = brandWeb;
    }
}
