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
import com.leapfrog.classwork1.entity.Course;
import com.leapfrog.classwork1.entity.Mentor;
import com.leapfrog.classwork1.entity.Student;
import com.leapfrog.classwork1.view.CourseView;
import java.util.Scanner;

/**
 *
 * @author HYOJU
 */
public class Program {

    public static void mainmenu() {
        System.out.println("1. Course");
        System.out.println("2. Student");
        System.out.println("3. Mentor");
        System.out.println("4. Exit");
        System.out.println("Enter your choice[1-3]: ");
        System.out.println("---------------------------");

    }

    public static void submenu() {
        System.out.println("1. Add Record");
        System.out.println("2. Delete Record");
        System.out.println("3. Get Record ById");
        System.out.println("4. Get All Records");
        System.out.println("5. Exit");
        System.out.println("Enter your Choice [1-5]: ");
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

        mainmenu();
        while (true) {
            switch (input.nextInt()) {
                case 1:
                    CourseView cv=new CourseView(input, courseService);
                    cv.submenu();
                    break;
                    
                case 2:
                    submenu();
                    while (true) {
                        switch (input.nextInt()) {
                            case 1:
                                Student std = new Student();

                                System.out.println("Enter Student Id: ");
                                std.setId(input.nextInt());
                                System.out.println("Enter Student First Name: ");
                                std.setFirstName(input.next());
                                System.out.println("Enter Student  Last Name: ");
                                std.setLastName(input.next());
                                System.out.println("Enter Student Email: ");
                                std.setEmail(input.next());
                                System.out.println("Enter Student Contact: ");
                                std.setContact(input.next());
                                System.out.println("Enter Student Status: ");
                                std.setStatus(input.nextBoolean());
                                studentService.insert(std);
                                System.out.println("The Student Records have been saved.");
                                break;

                            case 2:
                                System.out.println("Enter the Student Id you want to delete: ");
                                studentService.delete(input.nextInt());
                                System.out.println("The Student Records has been deleted.");
                                break;

                            case 3:
                                System.out.println("Enter the Student Id you want to view: ");
                                System.out.println("The Student Records is: " + studentService.getById(input.nextInt()));
                                break;

                            case 4:
                                System.out.println("The Student Records are");
                                studentService.getAll().forEach((s -> {
                                    System.out.println(s);
                                }));
                                break;

                            case 5:
                                System.exit(0);
                                break;

                        }
                        showConfirmDialog(input);
                        break;
                    }
                case 3:
                    submenu();
                    while (true) {
                        switch (input.nextInt()) {
                            case 1:
                                Mentor mnt = new Mentor();

                                System.out.println("Enter Mentor Id: ");
                                mnt.setId(input.nextInt());
                                System.out.println("Enter Mentor First Name: ");
                                mnt.setFirstName(input.next());
                                System.out.println("Enter Mentor Last Name: ");
                                mnt.setLastName(input.next());
                                System.out.println("Enter Mentor Address: ");
                                mnt.setAddress(input.next());
                                System.out.println("Enter Mentor  Contact: ");
                                mnt.setContact(input.next());
                                System.out.println("Enter Mentor Email: ");
                                mnt.setEmail(input.next());
                                System.out.println("Enter Mentor Status: ");
                                mnt.setStatus(input.nextBoolean());
                                mentorService.insert(mnt);
                                System.out.println("The Mentor Records have been saved.");
                                break;

                            case 2:
                                System.out.println("Enter the Mentor Id you want to delete: ");
                                mentorService.delete(input.nextInt());
                                System.out.println("The Mentor Records has been deleted.");
                                break;

                            case 3:
                                System.out.println("Enter the Mentor Id you want to view: ");
                                System.out.println("The Mentor Records is: " + mentorService.getById(input.nextInt()));
                                break;

                            case 4:
                                System.out.println("The Mentor Records are");
                                mentorService.getAll().forEach((m -> {
                                    System.out.println(m);
                                }));
                                break;

                            case 5:
                                System.exit(0);
                                break;

                        }
                        showConfirmDialog(input);
                        break;
                    }
                case 4:
                    System.exit(0);
                    break;
            }
            showConfirmDialog(input);
        }

    }

}
