package com.market.bean.po;



public class User {
    private Integer userId;
    private String userAccount;
    private String userName;
    private Integer userSex;//0男，1女
    private Integer userStatus;//0有效，1无效
    private Integer userTitle;
    private String userPhone;
    private String userEmail;
    private String userRemark1;
    private String userRemark2;
    private String userRemark3;
    private String userRemark4;
    private String userRemark5;
    private int userDept;
    private int userRole;
    private Dept dept;
    private Role role;

    public User() {
    }

    public User(Integer userId, String userAccount, String userName, Integer userSex, Integer userStatus, Integer userTitle, String userPhone, String userEmail, String userRemark1, String userRemark2, String userRemark3, String userRemark4, String userRemark5, int userDept, int userRole, Dept dept, Role role) {
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
        this.dept=dept;
        this.role=role;
    }

    public Integer getUserId() { return userId; }
    public void setUserId(Integer userId) { this.userId = userId; }



    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    public Integer getUserSex() { return userSex; }
    public void setUserSex(Integer userSex) { this.userSex = userSex; }

    public Integer getUserStatus() { return userStatus; }
    public void setUserStatus(Integer userStatus) { this.userStatus = userStatus; }

    public Integer getUserTitle() { return userTitle; }
    public void setUserTitle(Integer userTitle) { this.userTitle = userTitle; }

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

    public int getUserDept() { return userDept; }
    public void setUserDept(int userDept) { this.userDept = userDept; }

    public int getUserRole() { return userRole; }
    public void setUserRole(int userRole) { this.userRole = userRole; }


    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }
}
