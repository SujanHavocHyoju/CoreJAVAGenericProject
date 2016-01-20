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
public class Course {

    private int id;
    private String name, descritpion, duration, time;
    private boolean status;


    public Course() {
    }

    public Course(int id, String name, String descritpion, String duration, String time, Boolean status) {
        this.id = id;
        this.name = name;
        this.descritpion = descritpion;
        this.duration = duration;
        this.time = time;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescritpion() {
        return descritpion;
    }

    public void setDescritpion(String descritpion) {
        this.descritpion = descritpion;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Course{" + "id=" + id + ", name=" + name + ", descritpion=" + descritpion + ", duration=" + duration + ", time=" + time + ", status=" + status + '}';
    }

    

   public String toCSV() {
        return id + "," + name + "," + descritpion + "," + duration + "," + time + "," + status + "\r\n";
    }

}
