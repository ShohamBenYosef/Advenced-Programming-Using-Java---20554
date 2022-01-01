package com.company;


import java.util.ArrayList;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IllegalArgumentException {


        ArrayList<Integer> keys = new ArrayList<Integer>();
        ArrayList<Integer> values = new ArrayList<Integer>();

        Student st1 = new Student("s", "b", 111, 1993);
        Student st2 = new Student("t", "c", 222, 1994);
        Student st3 = new Student("r", "a", 333, 1995);

        for (int i=0; i<10; i++){
            keys.add(i);
            values.add(i+3);
        }


       // try {
            AssociationTable<Student, String> a1 = new AssociationTable<Student, String>();
            a1.add(st1,"052456");
            a1.add(st2,"053753");
            a1.add(st3,"058159");
;

            for(Map.Entry<Student, String> entry : a1.entrySet())
                System.out.println("["+entry.getKey().getFirstName()+", "+entry.getValue()+"]");


            a1.remove(st1);
        System.out.println();
            for(Map.Entry<Student, String> entry : a1.entrySet())
                System.out.println("["+entry.getKey().getFirstName()+", "+entry.getValue()+"]");
       // } catch (IllegalArgumentException e){
       //     throw new IllegalArgumentException("Keys and Values size are not the same.");
       // }


    }
}


