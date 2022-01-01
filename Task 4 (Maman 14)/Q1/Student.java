package com.company;

import java.util.Date;
import java.util.Map;

public class Student {

    private String firstName;
    private String lastName;
    private long id;
    private int birthYear;


    public Student(String firstName, String lastName,long id, int birthday){
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.birthYear = birthday;
    }

    public static void main(String[] args) {

        Student s = new Student("s", "b", 111, 1993);
        Student t = new Student("t", "c", 222, 1994);
        Student r = new Student("r", "a", 333, 1995);
/*
        try {
            AssociationTable<Student, String> a1 = new AssociationTable<Student, String>();
            a1.add(s,"052");

            for(Map.Entry<Student, String> entry : a1.entrySet())
                System.out.println("["+entry.getKey()+", "+entry.getValue()+"]");
*/
        }
    }

}
