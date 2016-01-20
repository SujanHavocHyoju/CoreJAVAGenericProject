/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.classwork1.DAO;

import com.leapfrog.classwork1.entity.Mentor;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author HYOJU
 */
public interface MentorDAO {
    int insert(Mentor m);
    int delete(int id);
    Mentor getById(int id);
    List<Mentor> getAll();
    void export(String filePath, String content) throws IOException;
    void importData(String filePath) throws IOException;
}
