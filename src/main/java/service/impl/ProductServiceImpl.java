package service.impl;

import dao.ProductDao;
import model.Product;
import service.ProductService;
import service.Response;

import java.io.IOException;
import java.util.Map;

public class ProductServiceImpl implements ProductService {
    private ProductDao productDao;

    @Override
    public Response<Product> getProduct(String name) {

        return null;
    }

    @Override
    public Response<Map<String, Product>> getAllProducts() throws IOException, ClassNotFoundException{

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
