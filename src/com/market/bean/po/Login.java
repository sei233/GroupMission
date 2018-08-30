package com.market.bean.po;

public class Login {

    private String userAccount;
    private String userPassword;

    public Login() {
    }
    public Login(String userAccount,String userPassword){

        this.userAccount=userAccount;
        this.userPassword=userPassword;
    }
    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }


}


