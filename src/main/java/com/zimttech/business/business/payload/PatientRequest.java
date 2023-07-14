package com.zimttech.business.business.payload;

import lombok.Data;

@Data
public class PatientRequest {
    private String firstName;
    private String lastName;
    private int age;
    private String address;
    private String nationalID;

    public PatientRequest(String firstName, String lastName, int age, String address, String nationalID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.address = address;
        this.nationalID = nationalID;
    }
}
