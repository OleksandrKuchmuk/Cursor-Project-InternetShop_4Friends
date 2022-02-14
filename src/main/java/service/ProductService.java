package service;

import model.Product;

import java.util.Map;

public interface ProductService {
    Response<Product> getProduct(String name);

    Response<Map<String, Product>> getAllProducts();

    Response<Product> addProduct(Product product);

    Response<Product> deleteProduct(String name);

    Response<Product> changeProductQuantity(String name, int quantity);

    Response<Product> changeProductPrice(String name, double price);
}
