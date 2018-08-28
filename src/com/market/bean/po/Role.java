package com.market.bean.po;
public class Role {
    private Integer roleId;
    private String roleName;
    private String roleDesc;
    private String roleStatus;
    private String roleDept;


    public Role() {
    }

    public Role(Integer roleId, String roleName, String roleDesc, String roleStatus, String roleDept) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.roleDesc = roleDesc;
        this.roleStatus = roleStatus;
        this.roleDept = roleDept;


    }


    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public String getRoleStatus() {
        return roleStatus;
    }

    public void setRoleStatus(String roleStatus) {
        this.roleStatus=roleStatus;
    }

    public String getRoleDept() {
        return roleDept;
    }

    public void setRoleDept(String roleDept) {
        this.roleDept = roleDept;
    }
}


