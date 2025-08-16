package com.springboot.cruddemo.dao;

import com.springboot.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO{
    void save(Student theStudent); //saving /updating

    Student findById(Integer id); //to read or retrieve

    List<Student> findAll();

    List<Student> findByLastName(String theLastName);

    void update(Student theStudent); //saving/update, values change so used void

    void delete(Integer id);

    int deleteAll();
}
