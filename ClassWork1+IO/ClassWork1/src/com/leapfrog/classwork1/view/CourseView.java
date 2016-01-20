/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.classwork1.view;

import com.leapfrog.classwork1.Service.CourseService;
import com.leapfrog.classwork1.entity.Course;
import com.leapfrog.classwork1.util.FileHandler;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

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

        System.out.println("1. Add Course Record");
        System.out.println("2. Delete Course Record");
        System.out.println("3. Get Course Record ById");
        System.out.println("4. Get All Course Records");
        System.out.println("5. Export Course Records");
        System.out.println("6. Import Course Records");
        System.out.println("7. Go Back");
        System.out.println("8. Exit");
        System.out.println("Enter your Choice [1-8]: ");
        System.out.println("---------------------------");
    }

    public void addCourse() {

        System.out.println("===========Add Course Records==============");
        while (true) {
            Course cc = new Course();

            System.out.println("Enter Course Id: ");
            cc.setId(input.nextInt());
            
            input.nextLine();
            System.out.println("Enter Course Name: ");
            cc.setName(input.nextLine());
            System.out.println("Enter Course Description: ");
            cc.setDescritpion(input.nextLine());
            System.out.println("Enter Course Duration: ");
            cc.setDuration(input.nextLine());
            System.out.println("Enter Course Time: ");
            cc.setTime(input.nextLine());
            System.out.println("Enter Course Status: ");
            cc.setStatus(input.nextBoolean());
            courseService.insert(cc);
            System.out.println("The Course Records have been saved.");
            
            System.out.println("Do you want to add more[Y/N]");
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

            System.out.println("Do you want to delete more[Y/N]");
            if (input.next().equalsIgnoreCase("n")) {
                break;
            }

        }
    }

    public void showByIdCourse() {
        while (true) {
            System.out.println("Enter the Course Id you want to view: ");
            Course course = courseService.getById(input.nextInt());
            if (course != null) {
                System.out.println("The Course Records is: " + course.toString());
            }
            System.out.println("Do you want to view more Course Records ?[Y/N]");
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
    
    public void importDataScreen() throws IOException{
        
        System.out.println("Enter the file name to import from: ");
        //String fileName = input.next();
        //courseService.importData(fileName);
        courseService.importData(input.next());
        System.out.println("Import Successful !");
        
    }
    
    public void exportScreen() throws IOException{
        System.out.println("Enter the file Name to export to:  ");
        //String fileName = input.next();
        StringBuilder builder = new StringBuilder();
        courseService.getAll().forEach(cc ->{
        builder.append(cc.toCSV());
        });
        courseService.export(input.next(), builder.toString());
        System.out.println("Export Successful !");
    }
    
    

    public void courseController() throws IOException {
        boolean back = false;
        while (true) {
            submenu();
            switch (input.nextInt()) {
                case 1:
                    addCourse();
                    break;
                case 2:
                    deleteCourse();
                    break;
                case 3:
                    showByIdCourse();
                    break;
                case 4:
                    showAllCourse();
                    break;
                case 5:
                    exportScreen();
                    break;
                case 6:
                    importDataScreen();
                    break;
                case 7:
                    back = true;
                    break;
                case 8:
                    System.exit(0);
                    break;
            }
            if (back){
                break;
            }
        }
    }
}
