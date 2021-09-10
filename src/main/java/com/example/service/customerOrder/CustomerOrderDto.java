package com.example.service.customerOrder;

import com.fasterxml.jackson.annotation.JsonCreator;

public class CustomerOrderDto {

    private final String firstName;

    @JsonCreator
    public CustomerOrderDto(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }
}
