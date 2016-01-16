/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.classwork1.DAO.Impl;

import com.leapfrog.classwork1.DAO.CourseDAO;
import com.leapfrog.classwork1.entity.Course;
import java.util.List;

/**
 *
 * @author HYOJU
 */
public class CourseDAOImpl implements CourseDAO {
    
    private List<Course> courseList;

    public CourseDAOImpl(List<Course> courseList) {
        this.courseList = courseList;
    }

    @Override
    public int insert(Course c) {
        return (courseList.add(c))?1:2;
    }

    @Override
    public int delete(int id) {
        for(Course c: courseList){
           if( c.getId() == id){
           courseList.remove(id);
            return 1;
        } 
        }return 0;
    }

    @Override
    public Course getById(int id) {
        for(Course c: courseList){
           if( c.getId() == id){
           courseList.remove(id);
            return c;
        } 
        } return null;
    }

    @Override
    public List<Course> getAll() {
        return courseList;
    }
    
    
}
