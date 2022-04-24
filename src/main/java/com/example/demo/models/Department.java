package com.example.demo.models;

import java.sql.ResultSet;

public class Department {
    private int deptNo;
    private String deptName;
    private String location;

    public Department(ResultSet rs) {
        try {
            this.deptNo = rs.getInt(1);
            this.deptName = rs.getString(2);
            this.location = rs.getString(3);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public int getDeptno() {
        return this.deptNo;
    }

    public void setDeptno(int deptno) {
        this.deptNo = deptno;
    }

    public String getDeptName() {
        return this.deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Department{" +
                "deptno=" + deptNo +
                ", deptName='" + deptName + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
