package com.example.service.customerOrder;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerOrder {



    @JsonProperty("customer")
    private Customer customer;

    @JsonProperty("products")
//    private Products products;
    List<Products> productsList;


    @JsonCreator
    public CustomerOrder(@JsonProperty("customer") Customer customer, @JsonProperty("products") List<Products> productsList) {
        this.customer = customer;
        this.productsList = productsList;
    }


    public Customer getCustomer() {
        return customer;
    }

    public List<Products> getProductsList() {
        return productsList;
    }
}
