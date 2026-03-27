package com.airtribe.learntrack.entity;

import com.airtribe.learntrack.exception.InvalidInputException;

public class Person {
    private final String id;
    private String firstName;
    private String lastName;

    public Person(String id, String firstName, String lastName){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void getDisplayName(){
        System.out.println("My name is :"+firstName+" "+lastName);
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) throws InvalidInputException {
        if(firstName == null || firstName.isEmpty()){
            throw new InvalidInputException(" FirstName cannot be empty!");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
