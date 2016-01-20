/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.classwork1.DAO.Impl;

import com.leapfrog.classwork1.DAO.CourseDAO;
import com.leapfrog.classwork1.entity.Course;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

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

    @Override
    public void export(String filePath, String content) throws IOException {
        FileWriter writer=new FileWriter(new File(filePath));
        writer.write(content);
        writer.close();
    }

    @Override
    public void importData(String filePath) throws IOException {
         BufferedReader bReader = new BufferedReader(new FileReader(new File(filePath)));
        
        String line="";
        while ((line = bReader.readLine())!= null){
        StringTokenizer tokens = new StringTokenizer(line,",");
        Course c = new Course();
        c.setId(strToInt(tokens.nextToken()));
        c.setName(tokens.nextToken());
        c.setDescritpion(tokens.nextToken());
        c.setDuration(tokens.nextToken());
        c.setTime(tokens.nextToken());
        c.setStatus(Boolean.parseBoolean(tokens.nextToken()));
        
        insert(c);
    }
        bReader.close();
    }
    
     public Integer strToInt(String data){
        return Integer.parseInt(data);
    }
    
}
