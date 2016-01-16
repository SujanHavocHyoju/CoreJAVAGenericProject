/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.classwork1;

import com.leapfrog.classwork1.Service.CourseService;
import com.leapfrog.classwork1.Service.Impl.CourseServiceImpl;
import com.leapfrog.classwork1.Service.Impl.MentorServiceImpl;
import com.leapfrog.classwork1.Service.Impl.StudentServiceImpl;
import com.leapfrog.classwork1.Service.MentorService;
import com.leapfrog.classwork1.Service.StudentService;
import com.leapfrog.classwork1.view.CourseView;
import com.leapfrog.classwork1.view.MentorView;
import com.leapfrog.classwork1.view.StudentView;
import java.util.Scanner;

/**
 *
 * @author HYOJU
 */
public class Program {

    public static void mainmenu() {
        System.out.println("**Leapfrog Academy**");
        System.out.println("1. Course");
        System.out.println("2. Student");
        System.out.println("3. Mentor");
        System.out.println("4. Exit");
        System.out.println("Enter your choice[1-3]: ");
        System.out.println("---------------------------");

    }

    public static void showConfirmDialog(Scanner input) {
        System.out.println("Do you want to continue[Y/N] ");
        if (input.next().equalsIgnoreCase("n")) {
            System.exit(0);
        } else {
            System.out.println("------------------------");
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        StudentService studentService = new StudentServiceImpl();
        CourseService courseService = new CourseServiceImpl();
        MentorService mentorService = new MentorServiceImpl();

        
        while (true) {
            mainmenu();
            switch (input.nextInt()) {
                case 1:
                    CourseView cv = new CourseView(input, courseService);
                    cv.courseController();
                    break;

                case 2:
                    StudentView sv = new StudentView(input, studentService);
                    sv.studentController();
                    break;

                case 3:
                    MentorView mv = new MentorView(input, mentorService);
                    mv.mentorController();
                    break;

                case 4:
                    System.exit(0);
                    break;
            }
            
        }

    }

}
