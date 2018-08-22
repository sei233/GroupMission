package com.market.service.Impl;

public class SqlSmt {
    //firstGood增删改查语句
    public static final String INSERT_FIRSTGOOD="insert into firstGood(goodName,adoptPrice,marketPrice,shopPrice,minNo,adopt,creatTime,updateTime,operator,typeId,productId) values(?,?,?,?,?,?,?,?,?,?,?) ";
    public static final String UPDATE_FIRSTGOOD="update firstGood set goodName=?,typeId=?,marketPrice=?,shopPrice=?,minNo=?,adopt=?,updateTime=? where goodId=?";
    public static final String DELETE_FIRSTGOOD="delete firstGood where goodId=?";
    public static final String FINDID_FIRSTGOOD="select * from firstGood where goodId=?";
    public static final String FINDALL_FIRSTGOOD="select * from firstGood where 1=1";
    //secondGood增删改查语句
    public static final String INSERT_SECONDGOOD="insert into secondGood(goodName,adoptPrice,marketPrice,shopPrice,minNo,adopt,creatTime,updateTime,operator,typeId,brandId,goodModel,goodColor) values(?,?,?,?,?,?,?,?,?,?,?) ";
    public static final String UPDATE_SECONDGOOD="update secondGood set goodName=?,typeId=?,marketPrice=?,shopPrice=?,minNo=?,adopt=?,updateTime=? where goodId=?";
    public static final String DELETE_SECONDGOOD="delete secondGood where goodId=?";
    public static final String FINDID_SECONDGOOD="select * from secondGood where goodId=?";
    public static final String FINDALL_SECONDGOOD="select * from secondGood where 1=1";
    //brand增删改查语句
    public static final String INSERT_BRAND="insert into brand(brandName,brandWeb,brandDescribe)values(?,?,?)";
    public static final String UPDATE_BRAND="update brand set brandName=?,brandWeb=?,brandDescribe=? where brandId=?";
    public static final String DELETE_BRAND="delete brand where brandId=?";
    public static final String FINDID_BRAND="select * from brand where brandId=?";
    public static final String FINDALL_BRAND="select * from brand where 1=1";
    //type增删改查语句
    public static final String INSERT_TYPE="insert into type(typeName,typeState,typeDescribe) values(?,1,?)";
    public static final String UPDATE_TYPE="update type set typeName=?,typeDescribe=? where typeId=?";
    public static final String DELETE_TYPE="delete type where typeId=?";
    public static final String FINDID_TYPE="select * from type where typeId=?";
    public static final String FINDALL_TYPE="select * from type where 1=1";
    //gift增删改查语句
    public static final String INSERT_GIFT="insert into gift(giftName,typeId,giftModel,giftPrice,adoptPrice,adoptDepartment,minNo,giftColor,brandId) values(?,?,?,?,?,?,?,?,?)";
    public static final String UPDATE_GIFT="update gift set giftName=?,typeId=?,giftModel=?,giftPrice=?,adoptPrice=?,adoptDepartment=?,minNo=?,giftColor=?,brandId=? where giftId=?";
    public static final String DELETE_GIFT="delete gift where giftId=?";
    public static final String FINDID_GIFT="select * from gift where giftId=?";
    public static final String FINDALL_GIFT="select * from gift where 1=1";
    //application的sql语句
    public static final String FINDPAGE_APP="select * from application limit ?,?";
}
