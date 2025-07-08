package com.infosys.beans;

public class Department{
    private String deptName;
    private int deptId;

    public Department(String deptName, int deptId) {
        this.deptName = deptName;
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public int getDeptId() {
        return deptId;
    }
    @Override
    public String toString() {
        return "Department{deptName='" + deptName + "', deptId=" + deptId + "}";
    }
}