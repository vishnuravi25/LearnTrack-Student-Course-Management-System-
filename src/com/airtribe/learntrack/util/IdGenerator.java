package com.airtribe.learntrack.util;

public class IdGenerator {

    private static int studentIdCounter;
    private static int courseIdCounter;

    public static String getNextStudentId(){

        return "S"+(++studentIdCounter);
    }
    public static String getNextCourseId(){
        return "C"+(++courseIdCounter);
    }
}
