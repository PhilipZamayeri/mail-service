package com.example.service.customerOrder;

public class Products {

//    private List<Products> productsList;

    private final Product product;
    private int quantity;

    public Products(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return
                product.getName() + " antal: " + quantity + " pris: " + totalPrice();
    }

    private double totalPrice(){
        return product.getPrice() * quantity;
    }
}
