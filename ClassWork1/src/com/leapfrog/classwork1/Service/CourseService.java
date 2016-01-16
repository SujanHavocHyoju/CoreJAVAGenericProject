/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.classwork1.Service;

import com.leapfrog.classwork1.entity.Course;
import java.util.List;

/**
 *
 * @author HYOJU
 */
public interface CourseService {
    int insert(Course c);
    int delete(int id);
    Course getById(int id);
    List<Course> getAll();
}
