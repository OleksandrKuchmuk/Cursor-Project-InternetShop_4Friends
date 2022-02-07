package model;



import java.util.Objects;

public class Product {
    private String productName;
    private Double price;
    private int quantity;

    public Product(String name, double price,int count) {
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName (String productName) {
        if (productName == null || productName.isBlank()){
            throw new IllegalArgumentException("Product name cann not be empty.");
        }
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        if (price.doubleValue() < 0) {
            throw new IllegalArgumentException("Product price cann not be less than zero");
        }
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Product quantity cann not be less than zero");
        }
        this.quantity = quantity;
    }





    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return productName.equals(product.productName);
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(productName, price, productName);



    }
}




