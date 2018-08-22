package com.market.bean.po;

public class Permission {
    private Integer permissionId;
    private String permissionName;
    private String permissionDesc;
    private String permissionOps;

    public Permission() {
    }

    public Permission(Integer permissionId, String permissionName, String permissionDesc, String permissionOps) {
        this.permissionId = permissionId;
        this.permissionName = permissionName;
        this.permissionDesc = permissionDesc;
        this.permissionOps = permissionOps;
    }


    public Integer getPermissionId() { return permissionId; }
    public void setPermissionId(Integer permissionId) { this.permissionId = permissionId; }

    public String getPermissionName() { return permissionName; }
    public void setPermissionName(String permissionName) { this.permissionName = permissionName; }

    public String getPermissionDesc() { return permissionDesc; }
    public void setPermissionDesc(String permissionDesc) { this.permissionDesc = permissionDesc; }

    public String getPermissionOps() { return permissionOps; }
    public void setPermissionOps(String permissionOps) { this.permissionOps = permissionOps; }
}

