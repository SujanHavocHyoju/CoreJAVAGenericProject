/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.classwork1.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HYOJU
 */
public class FileHandler {
    public static List<String> readCSV(String fileName) throws IOException{
        List<String> data=new ArrayList<String>();
        BufferedReader reader=new BufferedReader(new FileReader(new File(fileName)));
        String line="";
        while((line=reader.readLine())!=null){
            data.add(line);
        }
        reader.close();
        return data;
    }
    
    public static void writeCSV(String fileName,String content) throws IOException{
        FileWriter writer=new FileWriter(new File(fileName));
        writer.write(content);
        writer.close();
    }
    
}
