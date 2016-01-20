/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.classwork1.DAO.Impl;

import com.leapfrog.classwork1.DAO.StudentDAO;
import com.leapfrog.classwork1.entity.Student;
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

    @Override
    public void export(String filePath, String content) throws IOException {
       FileWriter writer = new FileWriter(new File(filePath)) ;
       writer.write(content);
       writer.close();
    }

    @Override
    public void importData(String filePath) throws IOException {
        BufferedReader bReader= new BufferedReader(new FileReader(new File(filePath)));
        String line="";
        while((line = bReader.readLine())!= null){
            StringTokenizer tokens = new StringTokenizer(line,",");
            Student s = new Student();
            s.setId(strToInt(tokens.nextToken()));
            s.setFirstName(tokens.nextToken());
            s.setEmail(tokens.nextToken());
            s.setContact(tokens.nextToken());
            s.setStatus(Boolean.parseBoolean(tokens.nextToken()));
            
            insert(s);
        }
        bReader.close();
    }
    
    public Integer strToInt(String data){
        return Integer.parseInt(data);
    }
}
