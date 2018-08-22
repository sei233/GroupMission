package com.market.bean.po;

public class Type {
    private Integer typeId;
    private String typeName;
    private String typeDescribe;
    private Integer typeState;//0一类1二类

    public Type() {
    }

    public Type(Integer typeId, String typeName, String typeDescribe, Integer typeState) {
        this.typeId = typeId;
        this.typeName = typeName;
        this.typeDescribe = typeDescribe;
        this.typeState = typeState;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeDescribe() {
        return typeDescribe;
    }

    public void setTypeDescribe(String typeDescribe) {
        this.typeDescribe = typeDescribe;
    }

    public Integer getTypeState() {
        return typeState;
    }

    public void setTypeState(Integer typeState) {
        this.typeState = typeState;
    }
}
