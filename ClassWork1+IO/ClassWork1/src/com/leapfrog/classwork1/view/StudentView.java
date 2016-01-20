/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.classwork1.view;

import com.leapfrog.classwork1.Service.StudentService;
import com.leapfrog.classwork1.entity.Student;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author HYOJU
 */
public class StudentView {

    private Scanner input;
    private StudentService studentService;

    public StudentView(Scanner input, StudentService studentService) {
        this.input = input;
        this.studentService = studentService;
    }

    public void submenu() {
        System.out.println("1. Add Student Record");
        System.out.println("2. Delete Student Record");
        System.out.println("3. Get Student Record ById");
        System.out.println("4. Get All Student Records");
        System.out.println("5. Export Student Records");
        System.out.println("6. Import Student Records");
        System.out.println("7. Go Back");
        System.out.println("8. Exit");
        System.out.println("Enter your Choice [1-8]: ");
        System.out.println("---------------------------");

    }

    private void addStudent() {
        System.out.println("===========Add Student Records==============");
        while (true) {
            Student std = new Student();

            System.out.println("Enter Student Id: ");
            std.setId(input.nextInt());
            System.out.println("Enter Student First Name: ");
            std.setFirstName(input.next());
            System.out.println("Enter Student  Last Name: ");
            std.setLastName(input.next());
            System.out.println("Enter Student Email: ");
            std.setEmail(input.next());
            
            input.nextLine();
            System.out.println("Enter Student Contact: ");
            std.setContact(input.nextLine());
            System.out.println("Enter Student Status: ");
            std.setStatus(input.nextBoolean());
            studentService.insert(std);
            System.out.println("The Student Records have been saved.");

            System.out.println("Do you want to add more[Y/N]");
            if (input.next().equalsIgnoreCase("n")) {
            break;
            }
            
        } 

    }

    private void deleteStudent() {
        while (true) {
            System.out.println("Enter the Student Id you want to delete: ");
            studentService.delete(input.nextInt());
            System.out.println("The Student Records has been deleted.");

            System.out.println("Do you want to add more[Y/N]");
            if (input.next().equalsIgnoreCase("n")) {
               break;
            }
        }
    }

    private void showByIdStudent() {
        while (true) {
            System.out.println("Enter the Student Id you want to view: ");
            Student student = studentService.getById(input.nextInt());
            if (student != null) {
                System.out.println("The Student Records is: " + student.toString());
            }
            System.out.println("Do you want to view more Student Records ?[Y/N]");
            if (input.next().equalsIgnoreCase("n")) {
                break;
            }
        }
    }

    private void showAllStudent() {
        System.out.println("The Student Records are");
        studentService.getAll().forEach((s -> {
            System.out.println(s);
        }));
    }
    
    public void exportScreen() throws IOException{
        System.out.println("Enter the file Name to export to:  ");
        String fileName = input.next();
        StringBuilder builder = new StringBuilder();
        studentService.getAll().forEach(ss ->{
        builder.append(ss.toCSV());
        });
        studentService.export(fileName, builder.toString());
        System.out.println("Export Successful !");
    }
    
    public void importDataScreen() throws IOException{
        System.out.println("Enter the file Name to import from:  ");
        String fileName = input.next();
        studentService.importData(fileName);
        System.out.println("Import Successful !");
        
    }

    public void studentController() throws IOException {
        boolean back = false;
        while (true) {
            submenu();
            switch (input.nextInt()) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    deleteStudent();
                    break;
                case 3:
                    showByIdStudent();
                    break;
                case 4:
                    showAllStudent();
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
            if (back) {
                break;
            }
        }
    }

}
