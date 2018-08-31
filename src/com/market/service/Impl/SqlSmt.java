package com.market.service.Impl;

public class SqlSmt {


    //brand增删改查语句
    public static final String INSERT_BRAND="insert into brand(brandName,brandWeb,brandDescribe)values(?,?,?)";
    public static final String UPDATE_BRAND="update brand set brandName=?,brandWeb=?,brandDescribe=? where brandId=?";
    public static final String DELETE_BRAND="delete from brand where brandId=?";
    public static final String FINDID_BRAND="select * from brand where brandId=?";
    public static final String FINDALL_BRAND="select * from brand where 1=1";
    //type增删改查语句
    public static final String INSERT_TYPE="insert into type(typeName,typeDescribe) values(?,?)";
    public static final String UPDATE_TYPE="update type set typeName=?,typeDescribe=? where typeId=?";
    public static final String DELETE_TYPE="delete from type where typeId=?";
    public static final String FINDID_TYPE="select * from type where typeId=?";
    public static final String FINDALL_TYPE="select * from type where 1=1";
    //gift增删改查语句
    public static final String INSERT_GIFT="insert into gift(giftName,giftModel,giftPrice,giftColor,adoptPrice,adoptDepartment,giftNumber,typeName,brandName) values(?,?,?,?,?,?,?,?,?)";
    public static final String UPDATE_GIFT="update gift set giftName=?,giftPrice=?,giftNumber=? where giftId=?";
    public static final String DELETE_GIFT="delete from gift where giftId=?";
    public static final String FINDID_GIFT="select * from gift where giftId=?";
    public static final String FINDALL_GIFT="select * from gift where 1=1";
    //application的sql语句
    public static final String FINDPAGE_APP="select * from application limit ?,?";
    public static final String DELETE_APP="delete from application where appID=?";
    //user增删改查语句
    public static final String INSERT_USER="insert into user(userAccount,userName,userDept,userSex,userStatus,userTitle,userPhone,userEmail,userRole,userRemark1,userRemark2,userRemark3,userRemark4,userRemark5) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    public static final String UPDATE_USER="update user set userAccount=?,userName=?,userDept=?,userSex=?,userStatus=?,userTitle=?,userPhone=?,userEmail=?,userRole=?,userRemark1=?,userRemark2=?,userRemark3=?,userRemark4=?,userRemark5=? where userId=?";
    public static final String DELETE_USER="delete from user where userId=?";
    public static final String FINDID_USER="select userId,userAccount,userName,userDept,userSex,userStatus,userTitle,userPhone,userEmail,userRole,userRemark1,userRemark2,userRemark3,userRemark4,userRemark5 from user where userId=?";
    public static final String FINDALL_USER="select userId,userAccount,userName,userDept,userSex,userStatus,userTitle,userPhone,userEmail,userRole,userRemark1,userRemark2,userRemark3,userRemark4,userRemark5 from user where 1=1";
    public static final String UPDATE_PASSWORD="update user set userPassword=? where userAccount=?";
    public static final String FIND_LOGIN="select userAccount,userPassword from user";
    //role增删改查语句
    public static final String INSERT_ROLE="insert into role(roleName,roleDesc,roleStatus,roleDept)values(?,?,?,?)";
    public static final String UPDATE_ROLE="update role set roleName=?,roleDesc=?,roleStatus=?,roleDept=? where roleId=?";
    public static final String DELETE_ROLE="delete from role where roleId=?";
    public static final String FINDID_ROLE="select * from role where roleId=?";
    public static final String FINDALL_ROLE="select * from role where 1=1";
    //permission增删改查语句
    public static final String INSERT_PERMISSION="insert into permission(permissionName,permissionDesc,permissionOps) values(?,?,?)";
    public static final String UPDATE_PERMISSION="update permission set permissionName=?,permissionDesc=?,permissionOps=? where permissionId=?";
    public static final String DELETE_PERMISSION="delete from permission where permissionId=?";
    public static final String FINDID_PERMISSION="select * from permission where permissionId=?";
    public static final String FINDALL_PERMISSION="select * from permission where 1=1";
    //product表
    public static final String FINDALL_PRODUCT = "select * from product where 1=1";
    public static final String FINDID_PRODUCT = "select * from product where productId=?";

    //获取某表的某一列不重复值
    public static final String GET_COLUMN = "select distinct ? from ?";

    //good表增删改
    public static final String INSERT_GOOD = "insert into good(goodName,goodType,goodBrand,goodModel,goodColor,goodRank,goodAdoptPrice,goodMarketPrice,goodShopPrice,goodNumber,creatTime,operator) values(?,?,?,?,?,?,?,?,?,?,?,?)";
    public static final String UPDATE_GOOD="update good set goodName=?,goodMarketPrice=?,goodShopPrice=?,goodNumber=?,updateTime=?,operator=? where goodId=?";
    public static final String DELETE_GOOD="delete from good where goodId=?";
    public static final String FINDID_GOOD="select * from good where goodId=?";
    public static final String FINDALL_GOOD="select * from good where 1=1";
    //activity表操作
    public static final String INSERT_ACTIVITY = "insert into activity(activityName,beginTime,endTime,goodId,goodName,goodPrice,activityNumber,priceRange,activityPrice,reason,remarks) values(?,?,?,?,?,?,?,?,?,?,?)";
    public static final String DELETE_ACTIVITY = "delete from activity where activityId=?";
    public static final String UPDATE_ACTIVITY = "update activity set activityName=?,beginTime=?,endTime=?,priceRange=?,reason=?,remarks=?,activityNumber=?,activityPrice=? where activityId=?";
    public static final String FINDID_ACTIVITY = "select * from activity where activityId=?";
    public static final String FINDALL_ACTIVITY = "select * from activity where 1=1";
    public static final String UPDATE_APV = "update activity set approveState=?,approveComment=?,approveDate=? where activityId=?";
    //log表操作
    public static final String INSERT_LOG ="insert into log(logName,logOps,logTime)values(?,?,?)";
    public static final String DELETE_LOG = "delete from log where logId=?";
    public static final String FINDID_LOG = "select * from log where logId=?";
    public static final String FINDALL_LOG = "select * from log where 1=1";
    //    //firstGood增删改查语句
//    public static final String INSERT_FIRSTGOOD="insert into firstGood(goodName,adoptPrice,marketPrice,shopPrice,minNo,adopt,creatTime,updateTime,operator,typeId,productId) values(?,?,?,?,?,?,?,?,?,?,?) ";
//    public static final String UPDATE_FIRSTGOOD="update firstGood set goodName=?,typeId=?,marketPrice=?,shopPrice=?,minNo=?,adopt=?,updateTime=? where goodId=?";
//    public static final String DELETE_FIRSTGOOD="delete from firstGood where goodId=?";
//    public static final String FINDID_FIRSTGOOD="select * from firstGood where goodId=?";
//    public static final String FINDALL_FIRSTGOOD="select * from firstGood where 1=1";
//    //secondGood增删改查语句
//    public static final String INSERT_SECONDGOOD="insert into secondGood(goodName,adoptPrice,marketPrice,shopPrice,minNo,adopt,creatTime,updateTime,operator,typeId,brandId,goodModel,goodColor) values(?,?,?,?,?,?,?,?,?,?,?) ";
//    public static final String UPDATE_SECONDGOOD="update secondGood set goodName=?,typeId=?,marketPrice=?,shopPrice=?,minNo=?,adopt=?,updateTime=? where goodId=?";
//    public static final String DELETE_SECONDGOOD="delete from secondGood where goodId=?";
//    public static final String FINDID_SECONDGOOD="select * from secondGood where goodId=?";
//    public static final String FINDALL_SECONDGOOD="select * from secondGood where 1=1";

}
