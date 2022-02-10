package view.impl;

import view.Menu;

import java.util.Scanner;

public class AdminMainMenu implements Menu {
    private final String[] items = {"1.Users menu", "2.Order menu", "3.Product menu", "0.Exit"};
    private final String[] itemsForUserMenu = {"1.Block user", "2.Unblock user", "0.Back"};
    private final String[] itemsForOrderMenu = {"1.Confirm", "2.Un confirm", "0.Back"};
    private final String[] itemsForProductMenu = {"1.Edit product", "2.Add product", "3.Delete product", "0.Back"};
    private final String[] itemsForEditProduct = {"1.Edit name", "2.Edit price", "3.Edit quantity", "0.Back"};
    private Scanner scanner;
    LoginMenu loginMenu ;

    public AdminMainMenu() {
    }

    @Override
    public void show() {
        System.out.println("\nYou are in Main admins menu");
        showItems(items);
        System.out.print("\nPlease enter the number of the action point you want to perform: ");
         scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        while (true) {

            switch (choice) {
                case 0 -> exit();
                case 1 -> usersMenu();
                case 2 -> ordersMenu();
                case 3 -> productMenu();
            }
        }
    }

    private void usersMenu(){
        System.out.println("\nYou are in Admin menu: Users menu");
        showItems(itemsForUserMenu);
        System.out.print("\nPlease enter the number of the action point you want to perform: ");
        scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        while (true) {

            switch (choice) {
                case 0 -> show();
                case 1 -> System.out.print("Enter username for blocking user: ");

                // тут має бути код для блокування юзера
                case 2 -> System.out.print("Enter username for un blocking user: ");

                // тут має бути код для розблокування юзера
            }
        }
    }

    private void ordersMenu(){
        System.out.println("\nYou are in Admin menu: Orders menu");
        showItems(itemsForOrderMenu);
        System.out.print("\nPlease enter the number of the action point you want to perform: ");
        scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        while (true) {

            switch (choice) {
                case 0 -> show();
                case 1 -> {
                    System.out.println("тут має відбутись підтвердження замовлення(зміна статусу на 'підтверджений')");
                    show();
                }
                case 2 -> {
                    System.out.println("тут має відбутись підтвердження замовлення(зміна статусу на 'не підтверджений')");
                    show();
                }
            }
        }
    }

    private void productMenu(){
        System.out.println("\nYou are in Admin menu: Products menu");
        showItems(itemsForProductMenu);
        System.out.print("\nPlease enter the number of the action point you want to perform: ");
        scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        while (true) {

            switch (choice) {
                case 0 -> show();
                case 1 -> editProducts();
                case 2 -> System.out.println("тут має відбутись зміна параметрів продукту (Add product) ");
                case 3 -> System.out.println("тут має відбутись зміна параметрів продукту (Delit product) ");
            }
        }
    }



    private void editProducts(){
        System.out.println("\nYou are in Admin menu: Edit Product");
        showItems(itemsForEditProduct);
        System.out.print("\nPlease enter the number of the action point you want to perform: ");
        scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        while (true) {

            switch (choice) {
                case 0 -> productMenu();
                case 1 -> System.out.println("тут має відбутись зміна назви продукту");
                case 2 -> System.out.println("тут має відбутись зміна ціни продукту");
                case 3 -> System.out.println("тут має відбутись зміна кількості продукту");
            }
        }
    }



    @Override
    public void exit() {
        System.exit(0);
    }
}
