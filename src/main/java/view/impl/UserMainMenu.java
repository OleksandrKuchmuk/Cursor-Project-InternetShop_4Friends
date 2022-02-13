package view.impl;


import exception.MenuCorrectWater;
import model.User;
import service.OrderService;
import service.ProductService;
import view.Menu;

import java.io.IOException;
import java.util.Scanner;

public class UserMainMenu implements Menu {
    private String[] items = {"1. Products menu", "2. My orders", "0. Logout"};

    private final LoginMenu loginMenu;
    private final OrderService orderService;
    private final ProductService productService;
    private final User currentuser;

    public UserMainMenu(LoginMenu loginMenu, OrderService orderService, ProductService productService, User currentUser) {
        this.loginMenu = loginMenu;
        this.orderService = orderService;
        this.productService = productService;
        this.currentuser = currentUser;
    }

    //    private UserProductsMenu productMenu = new UserProductsMenu();
//    private UserOrdersMenu userOrdersMenu = new UserOrdersMenu();
//    LoginMenu loginMenu ;



    @Override
    public void show() {
        System.out.println("\nYou are in User menu");
        showItems(items);
        System.out.print("\nPlease enter the number of the action point you want to perform: ");
        Scanner scanner = new Scanner(System.in);

        while (true) {
//            int choice = scanner.nextInt();
            int choice = MenuCorrectWater.menuCorrectWater(2); // перевірка ведення
            switch (choice) {
                case 0 -> exit();
                case 1 -> new UserProductsMenu(this, orderService, productService).show();
                case 2 -> new UserOrdersMenu(this, orderService).show();
            }
        }
    }

    @Override
    public void exit()  {

        loginMenu.show();
    }

    User getCurrentUser(){

        return currentuser;
    }
}
