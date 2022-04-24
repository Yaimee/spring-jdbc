package com.example.demo.repositories;

import com.example.demo.models.Department;
import com.example.demo.models.Employee;
import com.example.demo.utility.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements CRUDInterface<Employee> {

    @Override
    public boolean create(Employee employee) {
        try (Connection conn = DatabaseConnectionManager.getConnection()){
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO employees (*) VALUES (employee.getId(),employee.getEmployeeName(),employee.getJob(),employee.getManager(),employee.getHiredate(),employee.getSalary(),employee.getCommission(),employee.getDeptNo())");
            stmt.executeQuery();
        } catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Something wrong with the database");
        }
        return true;
    }

    @Override
    public Employee getSingleEntityById(String id) {
        Employee employee = null;
        try (Connection conn = DatabaseConnectionManager.getConnection()){
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM employees WHERE id="+ id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            employee = new Employee(rs);
        } catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Something wrong with the database");
        }
        return employee;
    }

    @Override
    public List<Employee> getAllEntities() {
        List<Employee> employeeList = new ArrayList<>();

        try (Connection conn = DatabaseConnectionManager.getConnection()){
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM employees");
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                Employee employee = new Employee(rs);
                employeeList.add(employee);
            }
        } catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Something wrong with the database");
        }

        return employeeList;
    }

    @Override
    public boolean update(Employee entity) {
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }
}
