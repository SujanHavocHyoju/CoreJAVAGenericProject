/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.classwork1.DAO.Impl;

import com.leapfrog.classwork1.DAO.StudentDAO;
import com.leapfrog.classwork1.entity.Student;
import java.util.List;

/**
 *
 * @author HYOJU
 */
public class StudentDAOImpl implements StudentDAO {

    
    private List<Student> studentList;

    public StudentDAOImpl(List<Student> studentList) {
        this.studentList = studentList;
    }
       
    
    @Override
    public int insert(Student s) {
        return (studentList.add(s))?1:2;
    }

    @Override
    public int delete(int id) {
        for(Student s: studentList){
            if(s.getId()== id){
                studentList.remove(s);
            }return 1;
        }return 0;
        
    }

    @Override
    public Student getById(int id) {
         for(Student s: studentList){
            if(s.getId()== id){
                studentList.remove(s);
            }return s;
        }return null;
    }

    @Override
    public List<Student> getAll() {
        return studentList;
    }
    
}
