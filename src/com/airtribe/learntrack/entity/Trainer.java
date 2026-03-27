package com.airtribe.learntrack.entity;

public class Trainer extends Person{

    private String id;
    private String firstName;
    private String lastName;

    public Trainer(String id, String firstName, String lastName){
        super(id,firstName,lastName);
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

}
