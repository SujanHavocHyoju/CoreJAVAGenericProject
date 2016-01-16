/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.classwork1.view;

import com.leapfrog.classwork1.Service.MentorService;
import com.leapfrog.classwork1.entity.Mentor;
import java.util.Scanner;

/**
 *
 * @author HYOJU
 */
public class MentorView {

    private Scanner input;
    private MentorService mentorService;

    public MentorView(Scanner input, MentorService mentorService) {
        this.input = input;
        this.mentorService = mentorService;
    }

    public void submenu() {
        System.out.println("1. Add Mentor Record");
        System.out.println("2. Delete Mentor Record");
        System.out.println("3. Get Mentor Record ById");
        System.out.println("4. Get All Mentor Records");
        System.out.println("5. Go Back");

        System.out.println("6. Exit");
        System.out.println("Enter your Choice [1-6]: ");
        System.out.println("---------------------------");

    }

    public void addMentor() {
        System.out.println("===========Add Mentor Records==============");
        while (true) {
            Mentor mnt = new Mentor();

            System.out.println("Enter Mentor Id: ");
            mnt.setId(input.nextInt());
            System.out.println("Enter Mentor First Name: ");
            mnt.setFirstName(input.next());
            System.out.println("Enter Mentor Last Name: ");
            mnt.setLastName(input.next());
            
            input.nextLine();
            System.out.println("Enter Mentor Address: ");
            mnt.setAddress(input.nextLine());
            System.out.println("Enter Mentor  Contact: ");
            mnt.setContact(input.next());
            System.out.println("Enter Mentor Email: ");
            mnt.setEmail(input.next());
            System.out.println("Enter Mentor Status: ");
            mnt.setStatus(input.nextBoolean());
            mentorService.insert(mnt);
            System.out.println("The Mentor Records have been saved.");

            System.out.println("Do you want to add more[Y/N]");
            if (input.next().equalsIgnoreCase("n")) {
                break;
            }
        }
    }

    public void deleteMentor() {
        while (true) {
            System.out.println("Enter the Mentor Id you want to delete: ");
            mentorService.delete(input.nextInt());
            System.out.println("The Mentor Records has been deleted.");
            
            System.out.println("Do you want to delete more[Y/N]");
            if (input.next().equalsIgnoreCase("n")) {
                break;
            }
        }
    }

    public void showByIdMentor() {
        while (true) {
            System.out.println("Enter the Mentor Id you want to view: ");
            Mentor mentor = mentorService.getById(input.nextInt());
            if (mentor != null) {
                System.out.println("The Mentor Records is: " + mentor.toString());
            }
            System.out.println("Do you want to view more Mentor Records ?[Y/N]");
            if (input.next().equalsIgnoreCase("n")) {
                break;
            }
        }
    }

    public void showAllMentor() {
        
        System.out.println("The Mentor Records are");
        mentorService.getAll().forEach((m -> {
            System.out.println(m);
        }));
    }

    public void mentorController() {
        boolean back = false;
        while (true) {
            submenu();
            switch (input.nextInt()) {
                case 1:
                    addMentor();
                    break;
                case 2:
                    deleteMentor();
                    break;
                case 3:
                    showByIdMentor();
                    break;
                case 4:
                    showAllMentor();
                    break;
                case 5:
                    back = true; 
                    break;
                case 6:
                    System.exit(0);
                    break;

            }
            if (back) {
                break;
            }
        }
    }

}
