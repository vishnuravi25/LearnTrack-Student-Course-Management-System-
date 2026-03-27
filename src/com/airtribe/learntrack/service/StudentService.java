package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.util.IdGenerator;

public class StudentService {

    private Student[] students = new Student[100];
    private int count=0;

    public void addStudent(Student student){
        if(count<students.length){
            students[count]=student;
            count++;
            System.out.println("Student added Successfully!( Object )");
        }else{
            System.out.println("Storage full!");
        }
    }

    public void addStudent(String firstName, String lastName, String email, String batch, boolean active){
        if(count<students.length){
            Student s = new Student(firstName, lastName, email, batch, true);
            students[count] = s;
            count++;
            System.out.println("Student added Successfully!( details )");
        }else{
            System.out.println("Storage full!");
        }

    }

    public void removeStudent(String id){
        for(int i=0;i< count;i++){
            if(students[i].getId().equals(id)) {
                //shift elements left
                for (int j = i; j < count - 1; j++) {
                    students[j] = students[j + 1];
                }
                students[count - 1] = null;
                count--;

                System.out.println("Student Removed with id:" + id);
                return;
            }
        }
        System.out.println("Student not found");

    }

    public void listStudents(){
        for(int i=0;i<count;i++){
            students[i].getDisplayName();
        }
    }

    public void updateStudentEmail(String id, String newEmail){
        for(int i=0;i<count;i++){
            if(students[i].getId().equals(id)){
                students[i].setEmail(newEmail);
                System.out.println("Email ID updated to"+newEmail);
                return;
            }
        }
        System.out.println("Student not found!");
    }

    public Student searchStudentById(String id){
        for(int i=0;i<count;i++){
            if(students[i].getId().equals(id)){
                return students[i];
            }
        }
        return null;
    }

    public void deactivateStudent(String id){
        Student s = searchStudentById(id);
        if(s!=null){
            s.setActive(false);
        }
    }
}
