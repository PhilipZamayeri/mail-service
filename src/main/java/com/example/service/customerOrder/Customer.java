package com.example.service.customerOrder;

public class Customer {
    private final String firstName;
    private final String lastName;
    private final String email;

    private final City city;

    private String zipcode;
    private String phoneNumber;

    public Customer(String firstName, String lastName, String email, City city, String zipcode, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.city = city;
        this.zipcode = zipcode;
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

    public String getZipcode() {
        return zipcode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
