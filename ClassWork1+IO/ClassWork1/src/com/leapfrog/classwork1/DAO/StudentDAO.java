/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.classwork1.DAO;

import com.leapfrog.classwork1.entity.Student;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author HYOJU
 */
public interface StudentDAO {
    int insert(Student s);
    int delete(int id);
    Student getById(int id);
    List<Student> getAll();
    void export(String filePath, String content) throws IOException;
    void importData(String filePath) throws IOException;
    
    
}
