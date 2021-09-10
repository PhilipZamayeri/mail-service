package com.example.service.customerOrder;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerOrderResponeDto {
    private final CustomerDto customerDto;

    public CustomerOrderResponeDto(@JsonProperty CustomerDto customerDto) {
        this.customerDto = customerDto;
    }
}
