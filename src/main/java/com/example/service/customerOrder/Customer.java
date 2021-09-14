package com.example.service.customerOrder;

public class Customer {
    private final String firstName;
    private final String lastName;
    private final String email;
    private final City city;
    private final String adress;
    private final String zipCode;
    private final String phoneNumber;

    public Customer(String firstName, String lastName, String email, City city, String adress, String zipCode, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.city = city;
        this.adress = adress;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
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

    public City getCity() {
        return city;
    }

    public String getAdress() {
        return adress;
    }

    public String getZipcode() {
        return zipCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
