/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.classwork1.Service;

import com.leapfrog.classwork1.entity.Mentor;
import java.util.List;

/**
 *
 * @author HYOJU
 */
public interface MentorService {
    int insert(Mentor m);
    int delete(int id);
    Mentor getById(int id);
    List<Mentor> getAll();
    
}
