package org.example;

public class ProductService {
    private  ProductApiClient productApiClient;
    public ProductService(ProductApiClient productApiClient){

        this.productApiClient = productApiClient;
    }

    public Product getProduct(String productId){
        if(productApiClient.checkIdProduct(productId))
            return productApiClient.getProduct(productId);
        else
            throw new IllegalArgumentException("productId format is not correct");
    }
}
