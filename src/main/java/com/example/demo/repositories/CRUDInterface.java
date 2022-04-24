package com.example.demo.repositories;

import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface CRUDInterface <T>{
    //Create
    public boolean create(T entity);

    //Read
    public T getSingleEntityById(@RequestParam(required = false) String id);
    public List<T> getAllEntities();

    //Update
    public boolean update(T entity);

    //Delete
    public boolean deleteById(int id);
}
