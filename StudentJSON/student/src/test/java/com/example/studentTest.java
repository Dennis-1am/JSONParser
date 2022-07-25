package com.example;
import static org.junit.Assert.*;
// import java.nio.*;
// import java.nio.channels.FileChannel;
// import java.nio.charset.Charset;
// import java.nio.file.Files;
// import java.nio.file.Path;
// import java.nio.file.Paths;
// import java.nio.file.StandardOpenOption;
// import java.util.EnumSet;

import org.junit.Test;


/**
 * Unit test for simple App.
 */
public class studentTest 
{
    /**
     * This method will test if the determine grade in
     * the student class will conver to letter grade correctly
     */
    @Test
    public void testDetermineGrade()
    {
        Student testA = new Student("Ross", 92, "Science");
        Student testB = new Student("Ross", 82, "Science");
        Student testC = new Student("Ross", 72, "Science");
        Student testD = new Student("Ross", 62, "Science");
        Student testF = new Student("Ross", 52, "Science");
        
        assertEquals(testA.determineLetterGrade(), "A");
        assertEquals(testB.determineLetterGrade(), "B");
        assertEquals(testC.determineLetterGrade(), "C");
        assertEquals(testD.determineLetterGrade(), "D");
        assertEquals(testF.determineLetterGrade(), "F");
    }

    /** 
     * This method will test if the .json deserializes correctly
     * It takes in a testDeserializer.json file and checks if the name course and grade
     * of each individual student is correct
     */
     
    @Test
    public void testDeserializer(){
        Class dClass = JSON.deserializeStudent("testDeserializer.json");

        assertEquals(dClass.getStudent(0).getName(), "Ross");
        assertEquals(dClass.getStudent(1).getName(), "George");
        assertEquals(dClass.getStudent(0).getCourse(), "Science");
        assertEquals(dClass.getStudent(1).getCourse(), "Math");
        assertEquals(dClass.getStudent(0).getGrade(), 92);
        assertEquals(dClass.getStudent(1).getGrade(), 75);
        assertEquals(dClass.getNumStudents(),2);
        assertEquals(dClass.getYear(), 0);
    }
    
    /**
     * This method first serializes two separate students and 
     * writes to a file. Then to check if the file was written to
     * correct the method deserializes and checks the student objects
     * if they have the correct information
     */
    @Test
    public void testSerializer(){
        Class sClass = new Class(0);
        Student s1 = new Student("Ross", 92, "Science");
        Student s2 = new Student("George", 75, "Math");
        sClass.addStudent(s1);
        sClass.addStudent(s2);
        JSON.serializeStudent("testSerializer.json", sClass);
        Class dClass = JSON.deserializeStudent("testSerializer.json");

        assertEquals(dClass.getStudent(0).getName(), "Ross");
        assertEquals(dClass.getStudent(1).getName(), "George");
        assertEquals(dClass.getStudent(0).getCourse(), "Science");
        assertEquals(dClass.getStudent(1).getCourse(), "Math");
        assertEquals(dClass.getStudent(0).getGrade(), 92);
        assertEquals(dClass.getStudent(1).getGrade(), 75);
        assertEquals(dClass.getNumStudents(),2);
        assertEquals(dClass.getYear(), 0);
    }
/** 
    Path getFileURIFromResources(String fileName) throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        return Paths.get(classLoader.getResource(fileName).getPath());
    }


    @Test
    public void testMappedByteBuffer(){
        CharBuffer charBuffer = null;
        Path pathToRead = getFileURIFromResources("testSerializer.json");

        try (FileChannel fileChannel (FileChannel) Files.newByteChannel(
            pathToRead, EnumSet.of(StandardOpenOption.READ))) {
 
            MappedByteBuffer mappedByteBuffer = fileChannel
            .map(FileChannel.MapMode.READ_ONLY, 0, fileChannel.size());

            if (mappedByteBuffer != null) {
            charBuffer = Charset.forName("UTF-8").decode(mappedByteBuffer);
            }
        }
    }
    */

}
