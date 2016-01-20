/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.classwork1.Service.Impl;

import com.leapfrog.classwork1.DAO.Impl.StudentDAOImpl;
import com.leapfrog.classwork1.DAO.StudentDAO;
import com.leapfrog.classwork1.Service.StudentService;
import com.leapfrog.classwork1.entity.Student;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HYOJU
 */
public class StudentServiceImpl implements StudentService{

    private StudentDAO studentDAO;

    public StudentServiceImpl() {
        studentDAO = new StudentDAOImpl(new ArrayList<>());
    }
    
    
    @Override
    public int insert(Student s) {
        return studentDAO.insert(s);
    }

    @Override
    public int delete(int id) {
        return studentDAO.delete(id);
    }

    @Override
    public Student getById(int id) {
        return studentDAO.getById(id);
    }

    @Override
    public List<Student> getAll() {
        return studentDAO.getAll();
    }

    @Override
    public void export(String filePath, String content) throws IOException {
        studentDAO.export(filePath, content);
    }

    @Override
    public void importData(String filePath) throws IOException {
        studentDAO.importData(filePath);
    }
    
    
    
}
