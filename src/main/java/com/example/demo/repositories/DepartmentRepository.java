package com.example.demo.repositories;

import com.example.demo.models.Department;
import com.example.demo.utility.DatabaseConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class  DepartmentRepository implements CRUDInterface<Department>{
    @Override
    public boolean create(Department entity) {
        return false;
    }

    @Override
    public Department getSingleEntityById(String id) {
        return null;
    }

    @Override
    public List<Department> getAllEntities() {
        List<Department> departmentList = new ArrayList<>();

        try (Connection conn = DatabaseConnectionManager.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM departments");
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                Department department = new Department(rs);
                departmentList.add(department);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
            System.out.println("Something wrong with database");
        }
        return departmentList;
    }

    @Override
    public boolean update(Department entity) {
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }
}
