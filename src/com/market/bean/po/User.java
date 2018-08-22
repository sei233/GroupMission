package com.market.bean.po;



public class User {
    private Integer userId;
    private String userAccount;
    private String userName;
    private String userPassword;
    private Integer userSex;//0男，1女
    private Integer userStatus;//0有效，1无效
    private String userTitle;
    private String userPhone;
    private String userEmail;
    private String userRemark1;
    private String userRemark2;
    private String userRemark3;
    private String userRemark4;
    private String userRemark5;
    private Integer userDept;
    private Integer userRole;

    public Integer getUserId() { return userId; }
    public void setUserId(Integer userId) { this.userId = userId; }

    public String getUserAccount() { return userAccount; }
    public void setUserAccount(String userAccount) { this.userAccount = userAccount; }

    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    public String getUserPassword() { return userPassword; }
    public void setUserPassword(String userPassword) { this.userPassword = userPassword; }

    public Integer getUserSex() { return userSex; }
    public void setUserSex(Integer userSex) { this.userSex = userSex; }

    public Integer getUserStatus() { return userStatus; }
    public void setUserStatus(Integer userStatus) { this.userStatus = userStatus; }

    public String getUserTitle() { return userTitle; }
    public void setUserTitle(String userTitle) { this.userTitle = userTitle; }

    public String getUserPhone() { return userPhone;}
    public void setUserPhone(String userPhone) { this.userPhone = userPhone; }

    public String getUserEmail() { return userEmail; }
    public void setUserEmail(String userEmail) { this.userEmail = userEmail; }

    public String getUserRemark1() { return userRemark1; }
    public void setUserRemark1(String userRemark1) { this.userRemark1 = userRemark1; }

    public String getUserRemark2() { return userRemark2; }
    public void setUserRemark2(String userRemark2) { this.userRemark2 = userRemark2; }

    public String getUserRemark3() { return userRemark3; }
    public void setUserRemark3(String userRemark3) { this.userRemark3 = userRemark3; }

    public String getUserRemark4() { return userRemark4; }
    public void setUserRemark4(String userRemark4) { this.userRemark4 = userRemark4; }

    public String getUserRemark5() { return userRemark5; }
    public void setUserRemark5(String userRemark5) { this.userRemark5 = userRemark5; }

    public Integer getUserDept() { return userDept; }
    public void setUserDept(Integer userDept) { this.userDept = userDept; }

    public Integer getUserRole() { return userRole; }
    public void setUserRole(Integer userRole) { this.userRole = userRole; }


}
