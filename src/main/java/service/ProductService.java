package service;

import model.Product;

import java.util.Map;

/**
 * Created by Igor on 10/8/2019.
 */
public interface ProductService {
    Response<Product> getProduct(String name);
    Response<Map<String, Product>> getAllProducts();
    Response<Product> addProduct();
    Response<Product> deleteProduct();
    Response<Product> changeProductName();
    Response<Product> changeProductQuantity();
    Response<Product> changeProductPrice();


}
