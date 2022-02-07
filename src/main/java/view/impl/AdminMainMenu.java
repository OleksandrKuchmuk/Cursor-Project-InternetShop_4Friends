package view.impl;

import view.Menu;

import java.util.Scanner;

public class AdminMainMenu implements Menu {
    private final String[] items = {"1.Users menu", "2.Order menu", "3.Product menu", "0.Exit"};
    private final String[] itemsForUserMenu = {"1.Block user", "2.Unblock user", "0.Back"};
    private final String[] itemsForOrderMenu = {"1.Confirm", "2.Un confirm", "0.Back"};
    private final String[] itemsForProductMenu = {"1.Edit product", "2.Add product", "3.Delete product", "0.Back"};
    private final String[] itemsOrderStatus = {};
    private final String[] itemsForEditProduct = {"1.Edit name", "2.Edit price", "3.Edit quantity", "0.Back"};
    private Scanner scanner;
    LoginMenu loginMenu = new LoginMenu();

    @Override
    public void show() {
        showItems(items);
        System.out.print("\nPlease enter the number of the action point you want to perform: ");
         scanner = new Scanner(System.in);

        while (true) {
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    usersMenu();
                    break;
                case 2:
                    ordersMenu();
                    break;
                case 3:
                    productMenu();
                    break;
                case 0:
                    exit();
                    break;
            }
        }
    }

    private void usersMenu(){
        showItems(itemsForUserMenu);
        System.out.print("\nPlease enter the number of the action point you want to perform: ");
        scanner = new Scanner(System.in);

        while (true) {
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter username for blocking user: ");
                    // тут має бути код для блокування юзера
                    break;
                case 2:
                    System.out.print("Enter username for un blocking user: ");
                    // тут має бути код для розблокування юзера
                    break;
                case 0:
                    show();
                    break;
            }
        }
    }

    private void ordersMenu(){
        showItems(itemsForOrderMenu);
        System.out.print("\nPlease enter the number of the action point you want to perform: ");
        scanner = new Scanner(System.in);

        while (true) {
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("тут має відбутись підтвердження замовлення(зміна статусу на 'підтверджений')");
                    show();
                    break;
                case 2:
                    System.out.println("тут має відбутись підтвердження замовлення(зміна статусу на 'не підтверджений')");
                    show();
                    break;
                case 0:
                    show();
                    break;
            }
        }
    }

    private void productMenu(){
        showItems(itemsForProductMenu);
        System.out.print("\nPlease enter the number of the action point you want to perform: ");
        scanner = new Scanner(System.in);

        while (true) {
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("тут має відбутись зміна параметрів продукту (edit product) ");

                    break;
                case 2:
                    System.out.println("тут має відбутись зміна параметрів продукту (Add product) ");
                    break;
                case 3:
                    System.out.println("тут має відбутись зміна параметрів продукту (Delit product) ");
                    break;
                case 0:
                    show();
                    break;
            }
        }
    }

    private void changeOrderStatus(){
        showItems(itemsOrderStatus);
        System.out.print("\nPlease enter the number of the action point you want to perform: ");
        scanner = new Scanner(System.in);

        while (true) {
            int choice = scanner.nextInt();

            switch (choice) {

            }
        }
    }

    private void editProducts(){
        showItems(itemsForEditProduct);
        System.out.print("\nPlease enter the number of the action point you want to perform: ");
        scanner = new Scanner(System.in);

        while (true) {
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("тут має відбутись зміна назви продукту");
                    break;
                case 2:
                    System.out.println("тут має відбутись зміна ціни продукту");
                    break;
                case 3:
                    System.out.println("тут має відбутись зміна кількості продукту");
                    break;
                case 0:
                    productMenu();
                    break;
            }
        }
    }



    @Override
    public void exit() {
        loginMenu.show();

    }


}
