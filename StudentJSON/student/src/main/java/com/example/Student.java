package com.example;

/**
 * Student class has certain paramaters such as
 * name, course, grade
 *
 */
public class Student 
{
    private String name;
    private String course;
    private int grade;
    
   public Student(){
        super();
   }

   public Student(String n, int g, String c){
    this.name = n;
    this.grade = g;
    this.course = c;
   }

    public String getName(){
        return name;
    }

    public int getGrade(){
        return grade;
    }

    public String getCourse(){
        return course;
    }

    public String determineLetterGrade(){
        if (grade < 0){
            throw new IllegalArgumentException("Letter Grade cannot be completeed");
        }else if(grade < 60){
            return "F";
        }else if(grade < 70){
            return "D";
        }else if(grade < 80){
            return "C";
        }else if(grade < 90){
            return "B";
        }else{
            return "A";
        }
    }

}


