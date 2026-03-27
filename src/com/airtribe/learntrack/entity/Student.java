package com.airtribe.learntrack.entity;

import com.airtribe.learntrack.util.IdGenerator;

public class Student extends Person{
    private String email;
    private String batch;
    private boolean active;

    public Student(String firstName, String lastName, String email, String batch, boolean active){
        super(IdGenerator.getNextStudentId(),firstName,lastName);
        this.email = email;
        this.batch = batch;
        this.active= active;
    }

    public Student(String firstName, String lastName) {
        this(firstName,lastName,"NA","NA",false);
    }

    public Student(){
        this("NA","NA","NA","NA",false);
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getEmail() {
        return email;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public void getDisplayName() {
        System.out.println("My name is :"+super.getFirstName()+" "+super.getLastName() + "with Student ID :"+getId());
    }
}
