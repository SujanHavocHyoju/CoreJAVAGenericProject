/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.classwork1.DAO.Impl;

import com.leapfrog.classwork1.DAO.MentorDAO;
import com.leapfrog.classwork1.entity.Mentor;
import java.util.List;

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

}
