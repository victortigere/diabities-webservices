package com.zimttech.business.business.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Patient extends BaseEntity {
    private String firstName;
    private String lastName;
    private int age;
    private String address;
    private String nationalID;
}
