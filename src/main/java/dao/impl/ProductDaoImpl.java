package dao.impl;

import dao.ProductDao;
import model.Product;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class ProductDaoImpl implements ProductDao {
    private final Map<String, Product> productMap = new TreeMap<>();

    public ProductDaoImpl() {
        add(new Product("Aster", 1.13, 2500));
        add(new Product("Begonia", 3.30, 1250));
        add(new Product("Buttercup", 2.24, 3500));
        add(new Product("Carnation", 1.50, 2500));
        add(new Product("Chrysanthemum", 1.60, 1247));
        add(new Product("Crocus", 1.20, 2548));
        add(new Product("Daisy", 1.80, 5142));
        add(new Product("Daffodil", 1.10, 2548));
        add(new Product("Dahlia", 2.31, 480));
        add(new Product("Forget-me-not", 2.0, 1250));
        add(new Product("Lily", 5.0, 2555));
        add(new Product("Orchid", 1.0, 325));
        add(new Product("Peony", 1.23, 325));
        add(new Product("Poppy", 7.0, 125));
        add(new Product("Sunflower", 0.80, 125));
        add(new Product("Tulip", 1.50, 10025));
        add(new Product("Violet", 2.18, 682));
    }

    @Override
    public Optional<Product> add(Product product) {
        return Optional.ofNullable(productMap.put(product.getName(), product));
    }

    @Override
    public Optional<Product> getByName(String name) {
        return Optional.ofNullable(productMap.get(name));
    }

    @Override
    public Optional<Product> delete(String name) {
        return Optional.ofNullable(productMap.remove(name));
    }

    @Override
    public Map<String, Product> getAllProducts() {
        return new TreeMap<>(productMap);
    }

    @Override
    public Optional<Product> update(String name, Product newProduct) {
        Optional<Product> deleteProduct = delete(name);
        if (deleteProduct.isPresent()) {
            add(newProduct);
        }
        return deleteProduct;
    }
}