package service;


import model.Product;

import java.awt.*;

public interface ProductService {

    Response<Product> getProduct(String name);

    Response<List> getListProducts();

    Response<Product> addProduct(Product product);

    Response<Product> deleteProduct(String name);

    Response<Product> changeProductName(String name, String newName);

    Response<Product> changeProductQuantity(String name, int count);

    Response<Product> changeProductPrice(String name, double price);
}
