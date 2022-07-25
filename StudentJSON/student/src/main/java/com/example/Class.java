package com.example;
import java.util.ArrayList;

public class Class {
    private ArrayList<Student> student = new ArrayList<Student>();
    private int numStudents;
    private int year;

    public Class(){
        super();
    }

    public Class(int y){
        this.year = y;
    }

    public ArrayList<Student> getStudent(){
        return student;
    }

    public Student getStudent(int i){
        return student.get(i);
    }

    public int getNumStudents(){
        return numStudents;
    }

    public void addStudent(Student s){
        student.add(s);
        numStudents += 1;
    }

    public int getYear(){
        return year;
    }
}
