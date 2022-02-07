package view.impl;


import view.Menu;

import java.util.Scanner;

public class UserMainMenu implements Menu {
    private String[] items = {"1. Products menu", "2. My orders", "0. Logout"};
    private Scanner scanner;
    private UserProductsMenu productMenu = new UserProductsMenu();
    private UserOrdersMenu userOrdersMenu = new UserOrdersMenu();

    @Override
    public void show() {
        showItems(items);

        System.out.print("\nPlease enter the number of the action point you want to perform: ");
        scanner = new Scanner(System.in);

        while (true) {
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    productMenu.show();
                    break;
                case 2:
                    userOrdersMenu.show();
                    break;
                case 0:
                    exit();
                    break;
            }
        }
//        System.out.println("AHhaaa!!");
    }

    @Override
    public void exit() {
        new LoginMenu().show();
    }
}
