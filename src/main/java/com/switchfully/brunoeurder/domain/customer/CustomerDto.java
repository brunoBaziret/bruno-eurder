package com.switchfully.brunoeurder.domain.customer;


public class CustomerDto {

    private String customerUniqueID;
    private String firstName;
    private String lastName;
    private String email;
    private Address address;
    private String phoneNumber;

    public String getCustomerUniqueID() {
        return customerUniqueID;
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

    public CustomerDto setCustomerUniqueID(String customerUniqueID) {
        this.customerUniqueID = customerUniqueID;
        return this;
    }

    public CustomerDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public CustomerDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public CustomerDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public CustomerDto setAddress(Address address) {
        this.address = address;
        return this;
    }

    public CustomerDto setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    @Override
    public String toString() {
        return "Record for customer " + getCustomerUniqueID() +
                ":\n" + "Name: " + getFirstName()+ " " + getLastName() +
                ":\n" + "email: " + getEmail() +
                ":\n" + "Address: " + getAddress() +
                ":\n" + "Phone Number: " + getPhoneNumber();
    }
}
