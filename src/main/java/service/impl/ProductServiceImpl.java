package service.impl;

import model.Product;
import service.ProductService;
import service.Response;

import java.util.Map;

public class ProductServiceImpl implements ProductService {
    private Product product;

    @Override
    public Response<Product> getProduct(String name) {

        return null;
    }

    @Override
    public Response<Map<String, Product>> getAllProducts() {

        return null;
    }

    @Override
    public Response<Product> addProduct() {
//        product = new Product(product.setProductName(); product.setPrice();product.setQuantity();)
        return null;
    }

    @Override
    public Response<Product> deleteProduct() {
        return null;
    }

    @Override
    public Response<Product> changeProductName() {
        return null;
    }

    @Override
    public Response<Product> changeProductQuantity() {
        return null;
    }

    @Override
    public Response<Product> changeProductPrice() {
        return null;
    }
}
