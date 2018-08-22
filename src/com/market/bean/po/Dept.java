package com.market.bean.po;

public class Dept {
    private Integer deptId;
    private String deptName;
    private String deptDesc;

    public Dept() {
    }

    public Dept(Integer deptId, String deptName, String deptDesc) {
        this.deptId = deptId;
        this.deptName = deptName;
        this.deptDesc = deptDesc;
    }

    public Integer getDeptId() { return deptId; }
    public void setDeptId(Integer deptId) { this.deptId = deptId; }

    public String getDeptName() { return deptName; }
    public void setDeptName(String deptName) { this.deptName = deptName; }

    public String getDeptDesc() { return deptDesc; }
    public void setDeptDesc(String deptDesc) { this.deptDesc = deptDesc; }
}
