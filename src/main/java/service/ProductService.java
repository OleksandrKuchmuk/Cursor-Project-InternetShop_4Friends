package service;

import model.Product;

import java.awt.*;
import java.io.IOException;
import java.util.Map;

public interface ProductService {

    Response<Product> getProduct(String name);






    Response<Map<String, Product>> getAllProducts() throws IOException, ClassNotFoundException;
    Response<Product> addProduct();
    Response<Product> deleteProduct();
    Response<Product> changeProductName();
    Response<Product> changeProductQuantity();
    Response<Product> changeProductPrice();


}
