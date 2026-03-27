package com.airtribe.learntrack.entity;
import com.airtribe.learntrack.enums.Status;

import java.time.LocalDate;

public class Enrollment {

    private Student student;
    private Course course;
    private LocalDate enrollmentDate;
    private Status status;

    public Enrollment( Student student, Course course, Status status){
        this.student = student;
        this.course = course;
        this.enrollmentDate = LocalDate.now();
        this.status = status;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
