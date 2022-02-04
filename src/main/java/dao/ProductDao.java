package dao;


import model.Product;

import java.util.Optional;

public interface ProductDao {

    Optional<Product> add(Product product);

    Optional<Product> delete(String name);

    Optional<Product> getListName(String name);

    Optional<Product> update(String name, Product newProduct);

    Optional<Product> getListProducts(String name,double price);
}
