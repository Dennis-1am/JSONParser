package com.example;
import java.io.File;
import java.util.Scanner;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSON extends Class{
    static Scanner sc = new Scanner(System.in);
    static ObjectMapper objMapper = new ObjectMapper();
    public static void main(String[] args) {
        
        
        System.out.println("WELCOME TO THE ClASS DATABASE");
        System.out.println("Enter in the class year: ");
        int classYear = sc.nextInt();

        Class tempClass = makeClass(classYear);
        //Serialize the student array to JSON
        serializeStudent("student.json", tempClass);

        //Deserialize the JSON and convert to java object
        Class dStudentArray = deserializeStudent("student.json");
        System.out.println("");
        printStudentArrayList(dStudentArray);

       
    }

    /**
     * This method will return an array of student
     * It takes in user input and creates new student objects
     * @param numStudents
     * @return
     */
    public static Class makeClass(int cy){
        Class temp = new Class(cy);
        boolean yes = true;
        while(yes){
            System.out.println("Enter in new students name, course and grade");
            System.out.println("Name: ");
            String tempName = sc.next();
            System.out.println("Course: ");
            String tempCourse = sc.next();
            System.out.println("Grade: ");
            int tempGrade = sc.nextInt();
            Student tempStudent = new Student(tempName, tempGrade, tempCourse);
            temp.addStudent(tempStudent);
            System.out.println("Enter y to continue or n to exit");
            if(sc.next().equals("n"))
                yes = false;
        }
        return temp;
    }

    /**
     * This method returns the student array to the command line
     * It also converts the number grade to a letter
     * @param sA
     */
    public static void printStudentArrayList(Class sA){
        System.out.println("Class of: " + sA.getYear());
        System.out.println("");
        for(int i = 0; i < sA.getStudent().size(); i++){
            System.out.println("Student #" + (i+1));
            System.out.println("Name: " + sA.getStudent(i).getName());
            System.out.println("Course: " + sA.getStudent(i).getCourse());
            System.out.println("Grade: "  + sA.getStudent(i).determineLetterGrade() + "(" + sA.getStudent(i).getGrade() + ")");
            System.out.println("");
        }
    }

    /**
     * This method reads in a .json file and returns an array of student objects
     * @param fileName
     * @return
     */
    public static Class deserializeStudent(String fileName){
        Class temp = null;
        try{
            temp = objMapper.readValue(new File(fileName),Class.class);
        }catch(final Exception e){
            e.printStackTrace();
        }
        return temp;
    }

    /**
     * This method will take in a filename and array of students
     * and writes it to a .json file
     * @param fileName
     * @param temp
     */
    public static void serializeStudent(String fileName, Class temp){
        try{
            objMapper.writerWithDefaultPrettyPrinter().writeValue(new File(fileName), temp);
        }catch(final Exception e){
            e.printStackTrace();
        }
    }
}
