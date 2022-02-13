package dao;

import model.Product;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;

public interface ProductDao {

    Optional<Product> getListName(String name);

    Optional<Product> getListProducts(String name,double price);

    Optional<Product> add(Product product) ;

    Optional<Product> getByName(String name);

    Optional<Product> update(String name, Product newProduct);

    Optional<Product> delete(String name);

    Map<String, Product> getAllProducts() ;

}
