package dao.impl;

import dao.ProductDao;
import model.Product;

import java.io.*;
import java.util.*;

public class ProductDaoImpl implements ProductDao {
    private final Map<String, Product> productMap;

    public ProductDaoImpl(Map<String, Product> productMap) {
        this.productMap = new TreeMap<>();
        add(new Product("Smartphone", 4800.0, 25));
        add(new Product("Hairdryer", 2580.0, 38));
        add(new Product("Washing machine", 8590.0, 44));
        add(new Product("Microwave", 5200.0, 19));
        add(new Product("Iron", 3300.0, 35));
    }

    @Override
    public Optional<Product> add(Product product) {
        return Optional.ofNullable(productMap.put(product.getProductName(),product));
    }

    @Override
    public Optional<Product> getByName(String name) {
        return Optional.empty();
    }

    @Override
    public Optional<Product> delete(String name) {
        return Optional.ofNullable(productMap.remove(name));
    }

    @Override
    public Map<String, Product> getAllProducts()throws IOException, ClassNotFoundException {
        return null;
    }

    @Override
    public Optional<Product> getListName(String name) {
        return Optional.ofNullable(productMap.get(name));
    }

    @Override
    public Optional<Product> update(String name, Product newProduct) {
        Optional<Product> deleteProduct = delete(name);
        if (deleteProduct.isPresent()) {
            add(newProduct);
        }
        return deleteProduct;
    }

    @Override
    public Optional<Product> getListProducts(String name, double price) {
        return Optional.empty();
    }


}
