package com.market.service.Impl;

public class SqlSmt {
    //firstGood增删改查语句
    public static final String INSERT_FIRSTGOOD="insert into firstGood(goodName,adoptPrice,marketPrice,shopPrice,minNo,adopt,creatTime,updateTime,operator,typeId,productId) values(?,?,?,?,?,?,?,?,?,?,?) ";
    public static final String UPDATE_FIRSTGOOD="update firstGood set goodName=?,typeId=?,marketPrice=?,shopPrice=?,minNo=?,adopt=?,updateTime=? where goodId=?";
    public static final String DELETE_FIRSTGOOD="delete from firstGood where goodId=?";
    public static final String FINDID_FIRSTGOOD="select * from firstGood where goodId=?";
    public static final String FINDALL_FIRSTGOOD="select * from firstGood where 1=1";
    //secondGood增删改查语句
    public static final String INSERT_SECONDGOOD="insert into secondGood(goodName,adoptPrice,marketPrice,shopPrice,minNo,adopt,creatTime,updateTime,operator,typeId,brandId,goodModel,goodColor) values(?,?,?,?,?,?,?,?,?,?,?) ";
    public static final String UPDATE_SECONDGOOD="update secondGood set goodName=?,typeId=?,marketPrice=?,shopPrice=?,minNo=?,adopt=?,updateTime=? where goodId=?";
    public static final String DELETE_SECONDGOOD="delete from secondGood where goodId=?";
    public static final String FINDID_SECONDGOOD="select * from secondGood where goodId=?";
    public static final String FINDALL_SECONDGOOD="select * from secondGood where 1=1";
    //brand增删改查语句
    public static final String INSERT_BRAND="insert into brand(brandName,brandWeb,brandDescribe)values(?,?,?)";
    public static final String UPDATE_BRAND="update brand set brandName=?,brandWeb=?,brandDescribe=? where brandId=?";
    public static final String DELETE_BRAND="delete from brand where brandId=?";
    public static final String FINDID_BRAND="select * from brand where brandId=?";
    public static final String FINDALL_BRAND="select * from brand where 1=1";
    //type增删改查语句
    public static final String INSERT_TYPE="insert into type(typeName,typeState,typeDescribe) values(?,1,?)";
    public static final String UPDATE_TYPE="update type set typeName=?,typeDescribe=? where typeId=?";
    public static final String DELETE_TYPE="delete from type where typeId=?";
    public static final String FINDID_TYPE="select * from type where typeId=?";
    public static final String FINDALL_TYPE="select * from type where 1=1";
    //gift增删改查语句
    public static final String INSERT_GIFT="insert into gift(giftName,typeId,giftModel,giftPrice,adoptPrice,adoptDepartment,minNo,giftColor,brandId) values(?,?,?,?,?,?,?,?,?)";
    public static final String UPDATE_GIFT="update gift set giftName=?,typeId=?,giftModel=?,giftPrice=?,adoptPrice=?,adoptDepartment=?,minNo=?,giftColor=?,brandId=? where giftId=?";
    public static final String DELETE_GIFT="delete from gift where giftId=?";
    public static final String FINDID_GIFT="select * from gift where giftId=?";
    public static final String FINDALL_GIFT="select * from gift where 1=1";
    //application的sql语句
    public static final String FINDPAGE_APP="select * from application limit ?,?";
    public static final String DELETE_APP="delete from application where appID=?";
    //user增删改查语句
    public static final String INSERT_USER="insert into user(userAccount,userName,userDept,userPassword,userSex,userStatus,userTitle,userPhone,userEmail,userRemark1,userRemark2,userRemark3,userRemark4,userRemark5,userRole) values(?,?,?,?,0,0,?,?,?,?,?,?,?,?,?)";
    public static final String UPDATE_USER="update user set userAccount=?,userName=?,userDept=?,userPassword=?,userTitle=?,userPhone=?,userEmail=?,userRemark1=?,userRemark2=?,userRemark3=?,userRemark4=?,userRemark5=?,userRole=? where userId=?";
    public static final String DELETE_USER="delete user where userId=?";
    public static final String FINDID_USER="select * from user where userId=?";
    public static final String FINDALL_USER="select * from user where 1=1";
    //role增删改查语句
    public static final String INSERT_ROLE="insert into role(roleName,roleDesc,roleStatus,roleDept)values(?,?,0,?)";
    public static final String UPDATE_ROLE="update role set roleName=?,roleDesc=?,roleDept=? where roleId=?";
    public static final String DELETE_ROLE="delete role where roleId=?";
    public static final String FINDID_ROLE="select * from role where roleId=?";
    public static final String FINDALL_ROLE="select * from role where 1=1";
    //permission增删改查语句
    public static final String INSERT_PERMISSION="insert into permission(permissionName,permissionDesc,permissionOps) values(?,?,?)";
    public static final String UPDATE_PERMISSION="update permission set permissionName=?,permissionDesc=?,permissionOps=? where permissionId=?";
    public static final String DELETE_PERMISSION="delete permission where permissionId=?";
    public static final String FINDID_PERMISSION="select * from permission where permissionId=?";
    public static final String FINDALL_PERMISSION="select * from permission where 1=1";
}
