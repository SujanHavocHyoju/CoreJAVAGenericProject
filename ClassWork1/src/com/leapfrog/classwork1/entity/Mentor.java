/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.classwork1.entity;

/**
 *
 * @author HYOJU
 */
public class Mentor {
    private int id;
    private String firstName, lastName, address, contact, email;
    private Boolean status;

    public Mentor() {
    }

    public Mentor(int id, String firstName, String address, String contact, String email, Boolean status) {
        this.id = id;
        this.firstName = firstName;
        this.address = address;
        this.contact = contact;
        this.email = email;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Mentor{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", contact=" + contact + ", email=" + email + ", status=" + status + '}';
    }
    
    
    
    
}
