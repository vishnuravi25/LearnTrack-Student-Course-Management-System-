package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.enums.Status;

public class EnrollmentService {
    private Enrollment [] enrollments = new Enrollment[100];
    private int count=0;

    public void enrollStudent(Student student, Course course){
        if(!student.isActive() || !course.isActive()){
            System.out.println("Cannot enroll inactive student or course");
        }
        //prevent duplicate enrolment
        for(int i=0;i<count;i++){
            if(enrollments[i].getStudent().getId().equals(student.getId()) &&
                    enrollments[i].getCourse().getId().equals(course.getId())){
                System.out.println("Student already enrolled in the course");
                return;
            }
        }

        Enrollment enroll = new Enrollment(student,course, Status.ACTIVE);
        enrollments[count++] =  enroll;


    }

    public void viewEnrollments(){

        for(int i=0;i<count;i++){
            String st = String.valueOf(enrollments[i].getStudent());
            System.out.println(enrollments[i].getStudent().getFirstName()+" has enrolled to "+enrollments[i].getCourse().getCourseName());
        }

    }

    public void markEnrollmentById(String studentId, String courseId, Status status){
        for(int i=0;i<count;i++){
            if(enrollments[i].getStudent().getId().equals(studentId) && enrollments[i].getCourse().getId().equals(courseId)){
                enrollments[i].setStatus(status);
                System.out.println("Status updated");
                return;
            }
        }
        System.out.println("Enrollment not found");
    }


}
