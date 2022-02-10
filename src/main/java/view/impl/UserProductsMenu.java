package view.impl;

import model.Product;
import model.User;
import service.OrderService;
import service.ProductService;
import service.Response;
import view.Menu;

import java.util.Map;
import java.util.Scanner;


public class UserProductsMenu implements Menu {

    private final String[] items = {"1. Show product list",
                                    "2. Search product",
                                    "3. Add products to order ",
                                    "4. Confirm order",
                                    "0. Back previous menu"};

    private final UserMainMenu userMainMenu;
    private final ProductService productService;
    private final OrderService orderService;

    public UserProductsMenu(UserMainMenu userMainMenu, ProductService productService, OrderService orderService) {
        this.userMainMenu = userMainMenu;
        this.productService = productService;
        this.orderService = orderService;
    }


    @Override
    public void show() {
        System.out.println("\nYou are in Product menu");
        showItems(items);
        System.out.print("\nPlease enter the number of the action point you want to perform: ");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1 -> showProductList();            //System.out.println("тут має сформуватись список продуктів");

                case 2 -> searchProduct();              //System.out.println("тут має включитись сканер і дати ввести назву продукту," +
                                                        //"після скану перевірка в списку, якщо такого продукту нема - 'такого продукту нема в списку'");
                case 3 -> addProducts();                 //System.out.println("тут має перейти до списку продуктів, вибору кількості і" +
                                                          // " додавання продуктів в замовлення");
                case 4 -> confirmOrder();                //System.out.println("тут має бути функція 'зробити замовлення', можливо потім відредагується" +
                                                         // "на зразок - 'закінчив робити замовлення'");
                case 0 -> exit();
            }
        }
    }

    private void showProductList(){
        Response<Map<String, Product>> mapResponse = productService.getAllProducts();
        if (!mapResponse.isSuccessful()) {
            System.out.println(mapResponse.getMessage());
        }
        Map<String, Product> productMap = mapResponse.getValue();
        System.out.println("Product list: ");
        System.out.println("-------------------------------------");
        productMap.values().forEach(System.out::println);
        System.out.println("-------------------------------------");
    }

    private void searchProduct() {

    }

    private void addProducts(){

    }

    private void confirmOrder(){

    }

    @Override
    public void exit() {
        userMainMenu.show();
    }

}
