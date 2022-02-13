package dao.impl;

import dao.ProductDao;
import model.Product;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class ProductDaoImpl implements ProductDao {
    private final Map<String, Product> productMap=new TreeMap<>();

    public ProductDaoImpl() {

        add(new Product("Aster", 10.00, 2500));
        add(new Product("Begonia", 80.00, 1250));
        add(new Product("Buttercup", 90.0, 3500));
        add(new Product("Carnation", 15.0, 2500));
        add(new Product("Chrysanthemum", 16.0, 1247));
        add(new Product("Crocus", 11.0, 2548));
        add(new Product("Daisy", 8.0, 5142));
        add(new Product("Daffodil", 11.0, 2548));
        add(new Product("Dahlia", 12.0, 480));
        add(new Product("Forget-me-not", 2.0, 1250));
        add(new Product("Lily", 5.0, 2555));
        add(new Product("Orchid", 10.0, 325));
        add(new Product("Peony", 10.0, 325));
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
    public Map<String, Product> getAllProducts()  {
        return new TreeMap<>(productMap);
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
