package com.switchfully.brunoeurder.domain.user;

import java.util.Objects;
import java.util.UUID;

public class User {

    private final String userUniqueID;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final Address address;
    private final String phoneNumber;

    public User(String firstName, String lastName, String email, Address address, String phoneNumber) {
        this.userUniqueID = UUID.randomUUID().toString();
        this.firstName = Objects.requireNonNull(firstName,"Missing value");
        this.lastName = Objects.requireNonNull(lastName,"Missing value");
        this.email = Objects.requireNonNull(email,"Missing value");
        this.address = Objects.requireNonNull(address,"Missing value");
        this.phoneNumber = Objects.requireNonNull(phoneNumber,"Missing value");
    }

    public String getUserUniqueID() {
        return userUniqueID;
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
        return "Record for customer " + getUserUniqueID() +
                ":\n" + "Name: " + getFirstName()+ " " + getLastName() +
                ":\n" + "email: " + getEmail() +
                ":\n" + "Address: " + getAddress() +
                ":\n" + "Phone Number: " + getPhoneNumber();
    }

}
