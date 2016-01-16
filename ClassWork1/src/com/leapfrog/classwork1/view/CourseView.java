/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.classwork1.view;

import com.leapfrog.classwork1.Service.CourseService;
import com.leapfrog.classwork1.entity.Course;
import java.util.Scanner;

/**
 *
 * @author HYOJU
 */
public class CourseView {

    private Scanner input;
    private CourseService courseService;

    public CourseView(Scanner input, CourseService courseService) {
        this.input = input;
        this.courseService = courseService;
    }
    
    public void submenu() {
        
        System.out.println("1. Add Record");
        System.out.println("2. Delete Record");
        System.out.println("3. Get Record ById");
        System.out.println("4. Get All Records");
        System.out.println("5. Exit");
        System.out.println("Enter your Choice [1-5]: ");
        System.out.println("---------------------------");
        switch (input.nextInt())
        {
            case 1:
                addCourse();
                break;
            case 2:
                deleteCourse();
                break;
        }
            
            
        
    }

    public void addCourse() {

        System.out.println("=============Add Course==================");
        while (true) {
            Course cc = new Course();

            System.out.println("Enter Course Id: ");
            cc.setId(input.nextInt());
            System.out.println("Enter Course Name: ");
            cc.setName(input.next());
            System.out.println("Enter Course Description: ");
            cc.setDescritpion(input.next());
            System.out.println("Enter Course Duration: ");
            cc.setDuration(input.next());
            System.out.println("Enter Course Time: ");
            cc.setTime(input.next());
            System.out.println("Enter Course Status: ");
            cc.setStatus(input.nextBoolean());
            courseService.insert(cc);
            System.out.println("The Course Records have been saved.");
            System.out.println("Do you want to add more[Y/N");
            if (input.next().equalsIgnoreCase("n")) {
                break;
            }
        }
    }

    public void deleteCourse() {
        while (true) {
            System.out.println("Enter the Course Id you want to delete: ");
            courseService.delete(input.nextInt());
            System.out.println("The Course Records has been deleted.");
            
            System.out.println("Do you want to add more[Y/N");
            if (input.next().equalsIgnoreCase("n")) {
                break;
            }
        }
    }

    public void showAllCourse() {
        System.out.println("The Course Records are :");
        courseService.getAll().forEach((c -> {
            System.out.println(c);
        }));
    }

    public void showByIdCourse() {
        System.out.println("Enter the Course Id you want to view: ");
        Course course=courseService.getById(input.nextInt());
        if(course!=null){
            System.out.println("The Course Records is: " + course.toString() );
        }
    }
}
