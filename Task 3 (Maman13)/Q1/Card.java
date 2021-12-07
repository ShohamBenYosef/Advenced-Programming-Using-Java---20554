package com.company;

/**
 *
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class Card {

    private String fileName;
    ArrayList<String> lines = new ArrayList<String>();


    public Card(){
        this.fileName = getPath();// TODO - method that get path.
    }

    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }


    /**
     *
     * @return
     */
    private String getPath(){
        Scanner s = new Scanner(System.in);
        System.out.println("Please Enter File Path:");
        return s.next();
    }

    /**
     *
     * @return
     */
    public ArrayList purseFile() {
        try{
            Scanner s = new Scanner(new File(fileName));
            while (s.hasNext()){
                lines.add(s.next());
            }
            s.close();
        } catch (IOException e){
            System.out.println("ERROR NO 1");
        }
        return lines;
    }

    // print ArrayList using
    public void printArryList(ArrayList<String> s){
        for (String str : s)
            System.out.println(str);
    }
}