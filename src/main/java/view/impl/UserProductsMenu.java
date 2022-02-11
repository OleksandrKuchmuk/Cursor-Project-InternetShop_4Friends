package view.impl;

import exception.MenuCorrectWater;
import model.Product;
import service.OrderService;
import service.ProductService;
import service.Response;
import view.Menu;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;


public class UserProductsMenu implements Menu {


    private final String[] items = {"1. Show product list", "2. Search product", "3. Add products to order ", "4. Confirm order", "0. Back previous menu"};
//    private Scanner scanner = new Scanner(System.in);
    private final String[] checkoutItems = {"1.Remove product", "2.Change product count", "3.Confirm order", "0.Back"};

    private final UserMainMenu userMainMenu;
    private final OrderService orderService;
    private final ProductService productService;

    public UserProductsMenu(UserMainMenu userMainMenu,
                            OrderService orderService,
                            ProductService productService) {
        this.userMainMenu = userMainMenu;
        this.orderService = orderService;
        this.productService = productService;
    }


    @Override
    public void show() {
        System.out.println("\nYou are in Product menu");



        Scanner scanner = new Scanner(System.in);

        while (true) {
            showItems(items);
            System.out.print("\nPlease enter the number of the action point you want to perform: ");
            //int choice = scanner.nextInt();
            int choice = MenuCorrectWater.menuCorrectWater(4); // перевірка ведення
            switch (choice) {
                case 0:
                    exit();
                    break;
                case 1:
                    listOfProduct();
                    break;
                case 2:
                    System.out.println("тут має включитись сканер і дати ввести назву продукту," +
                            "після скану перевірка в списку, якщо такого продукту нема - 'такого продукту нема в списку'");
                    break;
                case 3:
                    System.out.println("тут має перейти до списку продуктів, вибору кількості і" +
                            " додавання продуктів в замовлення");
                    break;
                case 4:
                    System.out.println("тут має бути функція 'зробити замовлення', можливо потім відредагується" +
                            "на зразок - 'закінчив робити замовлення'");
                    break;

            }
        }

    }
    public void listOfProduct() {
        Response<Map<String, Product>> allProductsMapResponse = null;
        try {
            allProductsMapResponse = productService.getAllProducts();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        assert allProductsMapResponse != null;
        if (!allProductsMapResponse.isSuccessful()) {
            System.out.println(allProductsMapResponse.getMessage());
        } else {
            Map allProductsMap = allProductsMapResponse.getValue();
            System.out.println("Product list:");
            System.out.println("-".repeat(20));
            Collection var10000 = allProductsMap.values();
            PrintStream var10001 = System.out;
            Objects.requireNonNull(var10001);
            var10000.forEach(var10001::println);
            System.out.println("-".repeat(50));
        }
    }

    @Override
    public void exit() {
        userMainMenu.show();
    }
}
