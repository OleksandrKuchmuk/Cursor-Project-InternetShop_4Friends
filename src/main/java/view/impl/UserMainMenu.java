package view.impl;


import model.User;
import view.Menu;
import service.OrderService;
import service.ProductService;

import java.util.Scanner;

public class UserMainMenu implements Menu {

    private final String[] items = {"1. Products menu", "2. My orders", "0. Logout"};

    private final LoginMenu loginMenu ;
    private final OrderService orderService;// = new UserProductsMenu(productService, userMainMenu);
    private final ProductService productService;// = new UserOrdersMenu();
    private final User newUser;

    public UserMainMenu(LoginMenu loginMenu,User newUser, OrderService orderService, ProductService productService ) {
        this.loginMenu = loginMenu;
        this.newUser = newUser;
        this.orderService = orderService;
        this.productService = productService;
    }


    @Override
    public void show() {
        System.out.println("\nYou are in User menu");
        showItems(items);

        System.out.print("\nPlease enter the number of the action point you want to perform: ");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int choice = scanner.nextInt();

            switch (choice) {
                case 0 -> exit();
                case 1 -> new UserProductsMenu( this, productService,orderService).show();
                case 2 -> new UserOrdersMenu(this, orderService).show();
            }
        }
    }

    @Override
    public void exit() {
        new LoginMenu().show();
    }

    public User getNewUser() {
        return newUser;
    }
}
