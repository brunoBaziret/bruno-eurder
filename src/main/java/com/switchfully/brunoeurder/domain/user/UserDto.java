package com.switchfully.brunoeurder.domain.user;


public class UserDto {

    private String userUniqueID;
    private String firstName;
    private String lastName;
    private String email;
    private Address address;
    private String phoneNumber;

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

    public UserDto setUserUniqueID(String userUniqueID) {
        this.userUniqueID = userUniqueID;
        return this;
    }

    public UserDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public UserDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public UserDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public UserDto setAddress(Address address) {
        this.address = address;
        return this;
    }

    public UserDto setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    @Override
    public String toString() {
        return "Record for customer " +
                ":\n" + "Name: " + getFirstName()+ " " + getLastName() +
                ":\n" + "email: " + getEmail() +
                ":\n" + "Address: " + getAddress() +
                ":\n" + "Phone Number: " + getPhoneNumber();
    }
}
