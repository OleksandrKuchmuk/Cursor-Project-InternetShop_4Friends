package model;



public class Product {
    private String productName;
    private Double price;
    private int quantity;

    public Product(String productName, Double price, int quantity) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        if (productName == null || productName.isBlank()){
            throw new IllegalArgumentException("Product name cann not be empty.");
        }
        this.productName = productName;
    }

    public Double getPrice() {
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
    public String toString() {
        return "Product{" +"productName='" + productName + '\'' + ", price=" + price +
                ", quantity=" + quantity + '}';
    }
}
