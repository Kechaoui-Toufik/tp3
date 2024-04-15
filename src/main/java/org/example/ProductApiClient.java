package org.example;

public interface ProductApiClient {
    public Product getProduct(String productId);
    public boolean checkIdProduct(String productId);
}
