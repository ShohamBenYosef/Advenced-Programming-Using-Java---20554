package com.company;

import java.util.Date;
import java.util.Map;

public class Student implements Comparable<Student> {

    // variables
    private String firstName;
    private String lastName;
    private int id;
    private int birthYear;

    // const
    public Student(String firstName, String lastName,int id, int birthday){
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.birthYear = birthday;
    }

    // get
    public String getFirstName() {
        return this.firstName;
    }
    public String getLastName() {
        return this.lastName;
    }
    public int getId() {
        return this.id;
    }
    public int getBirthYear() {
        return this.birthYear;
    }
    // set
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setBirthYear(int year) {
        this.birthYear = year;
    }



    @Override
    public int compareTo(Student other) {
        return id - other.getId();
    }

}
