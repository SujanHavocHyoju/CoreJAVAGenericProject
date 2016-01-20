/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.classwork1.DAO.Impl;

import com.leapfrog.classwork1.DAO.MentorDAO;
import com.leapfrog.classwork1.entity.Mentor;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author HYOJU
 */
public class MentorDAOImpl implements MentorDAO {

    private List<Mentor> mentorList;

    public MentorDAOImpl(List<Mentor> mentorList) {
        this.mentorList = mentorList;
    }

    @Override
    public int insert(Mentor m) {
        return (mentorList.add(m)) ? 1 : 0;
    }

    @Override
    public int delete(int id) {
        for (Mentor m : mentorList) {
            if (m.getId() == id) {
                mentorList.remove(m);
                return 1;
            }
        }
        return 0;
    }

    @Override
    public Mentor getById(int id) {
        for (Mentor m : mentorList) {
            if (m.getId() == id) {
                mentorList.remove(m);
                return m;
            }
        }
        return null;
    }

    @Override
    public List<Mentor> getAll() {
        return mentorList;
    }

    @Override
    public void export(String filePath, String content) throws IOException {
        FileWriter writer = new FileWriter(new File(filePath));
        writer.write(content);
        writer.close();
    }

    @Override
    public void importData(String filePath) throws IOException {
        BufferedReader bReader = new BufferedReader(new FileReader(new File(filePath)));
        String line= "";
        while((line= bReader.readLine())!=null){
            StringTokenizer tokens = new StringTokenizer(line,",");
            Mentor m = new Mentor();
            m.setId(strToInt(tokens.nextToken()));
            m.setFirstName(tokens.nextToken());
            m.setLastName(tokens.nextToken());
            m.setAddress(tokens.nextToken());
            m.setContact(tokens.nextToken());
            m.setEmail(tokens.nextToken());
            m.setStatus(Boolean.parseBoolean(tokens.nextToken()));
            
            insert(m);
        }
        bReader.close();
    
    }
    
    public Integer strToInt(String data){
        return Integer.parseInt(data);
    }
}
