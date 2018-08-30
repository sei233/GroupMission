package com.market.bean.po;



public class User {
    private Integer userId;
    private String userAccount;
    private String userName;
    private String userSex;
    private String userStatus;
    private String userTitle;
    private String userPhone;
    private String userEmail;
    private String userRemark1;
    private String userRemark2;
    private String userRemark3;
    private String userRemark4;
    private String userRemark5;
    private String userDept;
    private String userRole;
   

    public User() {
    }

    public User(Integer userId, String userAccount, String userName, String userSex, String userStatus, String userTitle, String userPhone, String userEmail, String userRemark1, String userRemark2, String userRemark3, String userRemark4, String userRemark5, String userDept, String userRole) {
        this.userId=userId;
        this.userAccount=userAccount;
        this.userName=userName;
        this.userSex=userSex;
        this.userStatus=userStatus;
        this.userTitle=userTitle;
        this.userPhone=userPhone;
        this.userEmail=userEmail;
        this.userRemark1=userRemark1;
        this.userRemark2=userRemark2;
        this.userRemark3=userRemark3;
        this.userRemark3=userRemark4;
        this.userRemark5=userRemark5;
        this.userDept=userDept;
        this.userRole=userRole;

    }

    public Integer getUserId() { return userId; }
    public void setUserId(Integer userId) { this.userId = userId; }



    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    public String getUserSex() { return userSex; }
    public void setUserSex(String userSex) { this.userSex = userSex; }

    public String getUserStatus() { return userStatus; }
    public void setUserStatus(String userStatus) { this.userStatus = userStatus; }

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

    public String getUserDept() { return userDept; }
    public void setUserDept(String userDept) { this.userDept = userDept; }

    public String getUserRole() { return userRole; }
    public void setUserRole(String userRole) { this.userRole = userRole; }


    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }
}
