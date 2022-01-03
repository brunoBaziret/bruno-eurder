package com.switchfully.brunoeurder.domain.user;

import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name = "USERS")
public class User {

    @Id
    @SequenceGenerator(name = "USERS_SEQ", sequenceName = "users_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USERS_SEQ")
    private String id;

    @Column(name = "FIRST_NAME", nullable = false)
    private final String firstName;

    @Column(name = "LAST_NAME",nullable = false)
    private final String lastName;

    @Column(name = "EMAIL",nullable = false)
    private final String email;

    @Embedded
    private final Address address;

    @Column(name = "PHONE_NUMBER",nullable = false)
    private final String phoneNumber;

    public User(String firstName, String lastName, String email, Address address, String phoneNumber) {
        this.firstName = Objects.requireNonNull(firstName, "Missing value");
        this.lastName = Objects.requireNonNull(lastName, "Missing value");
        this.email = Objects.requireNonNull(email, "Missing value");
        this.address = Objects.requireNonNull(address, "Missing value");
        this.phoneNumber = Objects.requireNonNull(phoneNumber, "Missing value");
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "Record for customer " + getId() +
                ":\n" + "Name: " + getFirstName() + " " + getLastName() +
                ":\n" + "email: " + getEmail() +
                ":\n" + "Address: " + getAddress() +
                ":\n" + "Phone Number: " + getPhoneNumber();
    }

}