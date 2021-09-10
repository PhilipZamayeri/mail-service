package com.example.service.customerOrder;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerDto {
    private final List<CustomerOrder> customer;

    @JsonCreator
    public Customer(JsonProperty "customer" List<CustomerOrder> customer) {
        this.customer = customer;
    }

    public String getCustomer() {
        return customer;
    }
}
