package com.practice.spring.domain;

import org.springframework.data.annotation.Id;

/**
 * Created by lbibera on 27/02/2017.
 */
public class Customer {

    @Id
    public String id;

    public String firstName;
    public String lastName;

    public Customer(){}

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
