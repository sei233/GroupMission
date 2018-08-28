package com.market.bean.po;
public class Role {
    private Integer roleId;
    private String roleName;
    private String roleDesc;
    private Integer roleStatus;//0有效，1无效
    private String roleDept;


    public Role() {
    }

    public Role(Integer roleId, String roleName, String roleDesc, Integer roleStatus, String roleDept) {
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

    public Integer getRoleStatus() {
        return roleStatus;
    }

    public void setRoleStatus(Integer roleStatus) {
        if(getRoleStatus()==0){
            this.roleStatus= Integer.valueOf("有效");
        }else if(getRoleStatus()==1){
            this.roleStatus= Integer.valueOf("无效");
        }
    }

    public String getRoleDept() {
        return roleDept;
    }

    public void setRoleDept(String roleDept) {
        this.roleDept = roleDept;
    }
}


