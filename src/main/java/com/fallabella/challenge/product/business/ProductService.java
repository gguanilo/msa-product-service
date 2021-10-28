package com.fallabella.challenge.product.business;

import com.fallabella.challenge.product.bean.Product;

import java.util.List;

public interface ProductService {
    public Product getProduct(String sku);
    public List<Product> getProducts();
    public Product createProduct(Product product);
    public Product updateProduct(Product product);
    public void deleteProduct(String sku);
}
