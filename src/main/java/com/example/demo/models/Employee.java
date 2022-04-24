package com.example.demo.models;
import java.sql.Date;
import java.sql.ResultSet;

import com.mysql.cj.protocol.Resultset;

public class Employee {
    int id;
    String employeeName;
    String job;
    int manager;
    Date hiredate;
    int salary;
    int commission;
    int deptNo;

    public Employee(int id, String employeeName, String job, int manager, Date hiredate, int salary, int commission, int deptNo) {
        this.id = id;
        this.employeeName = employeeName;
        this.job = job;
        this.manager = manager;
        this.hiredate = hiredate;
        this.salary = salary;
        this.commission = commission;
        this.deptNo = deptNo;
    }

    public Employee(ResultSet rs) {
        try {
            this.id = rs.getInt(1);
            this.employeeName = rs.getString(2);
            this.job = rs.getString(3);
            this.manager = rs.getInt(4);
            this.hiredate = rs.getDate(5);
            this.salary = rs.getInt(6);
            this.commission = rs.getInt(7);
            this.deptNo = rs.getInt(8);
        } catch (Exception e) {
            System.out.println("Something went wrong");
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getManager() {
        return manager;
    }

    public void setManager(int manager) {
        this.manager = manager;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getCommission() {
        return commission;
    }

    public void setCommission(int commission) {
        this.commission = commission;
    }

    public int getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(int deptNo) {
        this.deptNo = deptNo;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", employeeName='" + employeeName + '\'' +
                ", job='" + job + '\'' +
                ", manager=" + manager +
                ", hiredate=" + hiredate +
                ", salary=" + salary +
                ", commission=" + commission +
                ", deptNo=" + deptNo +
                '}';
    }
}
