/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.classwork1.Service;

import com.leapfrog.classwork1.entity.Student;
import java.util.List;

/**
 *
 * @author HYOJU
 */
public interface StudentService {
    int insert(Student s);
    int delete(int id);
    Student getById(int id);
    List<Student> getAll();
}
