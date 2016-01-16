/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.classwork1.Service.Impl;

import com.leapfrog.classwork1.DAO.CourseDAO;
import com.leapfrog.classwork1.DAO.Impl.CourseDAOImpl;
import com.leapfrog.classwork1.Service.CourseService;
import com.leapfrog.classwork1.entity.Course;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HYOJU
 */
public class CourseServiceImpl implements CourseService{

    private CourseDAO courseDAO;

    public CourseServiceImpl() {
        courseDAO = new CourseDAOImpl(new ArrayList<>());
    }
    
    
    @Override
    public int insert(Course c) {
        return courseDAO.insert(c);
    }

    @Override
    public int delete(int id) {
        return courseDAO.delete(id);
    }

    @Override
    public Course getById(int id) {
        return courseDAO.getById(id);
    }

    @Override
    public List<Course> getAll() {
        return courseDAO.getAll();
    }
    
    
    
}
