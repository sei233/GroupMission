package com.market.bean.po;
public class Role {
    private Integer roleId;
    private String roleName;
    private String roleDesc;
    private Integer roleStatus;//0有效，1无效
    private int roleDept;
    private Dept dept;

    public Role() {
    }

    public Role(Integer roleId, String roleName, String roleDesc, Integer roleStatus, int roleDept, Dept dept) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.roleDesc = roleDesc;
        this.roleStatus = roleStatus;
        this.roleDept = roleDept;
        this.dept =dept;

    }


    public Integer getRoleId() { return roleId; }
    public void setRoleId(Integer roleId) { this.roleId = roleId; }

    public String getRoleName() { return roleName; }
    public void setRoleName(String roleName) { this.roleName = roleName; }

    public String getRoleDesc() { return roleDesc; }
    public void setRoleDesc(String roleDesc) { this.roleDesc = roleDesc; }

    public Integer getRoleStatus() { return roleStatus; }
    public void setRoleStatus(Integer roleStatus) {
        if(this.roleStatus==0)
            roleStatus= Integer.valueOf("有效");
        if(this.roleStatus==1)
            roleStatus= Integer.valueOf("无效");
    }

    public int getRoleDept() { return roleDept; }
    public void setRoleDept(int roleDept) { this.roleDept = roleDept; }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }
}
