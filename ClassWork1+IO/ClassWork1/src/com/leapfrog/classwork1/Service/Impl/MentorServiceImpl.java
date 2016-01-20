/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.classwork1.Service.Impl;

import com.leapfrog.classwork1.DAO.Impl.MentorDAOImpl;
import com.leapfrog.classwork1.DAO.MentorDAO;
import com.leapfrog.classwork1.Service.MentorService;
import com.leapfrog.classwork1.entity.Mentor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HYOJU
 */
public class MentorServiceImpl implements MentorService {

    private MentorDAO mentorDAO;

    public MentorServiceImpl() {
        mentorDAO = new MentorDAOImpl(new ArrayList<>());
    }
    
    
    @Override
    public int insert(Mentor m) {
        return mentorDAO.insert(m);
    }

    @Override
    public int delete(int id) {
        return mentorDAO.delete(id);
    }

    @Override
    public Mentor getById(int id) {
        return mentorDAO.getById(id);
    }

    @Override
    public List<Mentor> getAll() {
        return mentorDAO.getAll();
    }

    @Override
    public void export(String filePath, String content) throws IOException {
        mentorDAO.export(filePath, content);
    }

    @Override
    public void importData(String filePath) throws IOException {
        mentorDAO.importData(filePath);
    }
    
}
