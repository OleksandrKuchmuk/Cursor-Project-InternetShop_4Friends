package view.impl;

import view.Menu;

import java.util.Scanner;

public class ProductMenu implements Menu {
    private String[] items = {"1.View list of products", "2.Add products to order ", "3. Make order", "0. Exit"};
    private Scanner scanner = new Scanner(System.in);


    @Override
    public void show() {
        showItems(items);

        System.out.print("\nPlease enter the number of the action point you want to perform: ");


        Scanner scanner = new Scanner(System.in);

        while (true) {
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("тут має сформуватись список продуктів");
                    break;
                case 2:
                    System.out.println("тут має бути функція додавання продуктів в замовлення");
                    break;
                case 3:
                    System.out.println("тут має бути функція 'зробити замовлення'");
                    break;
                case 0:
                    exit();
                    break;
            }
        }

    }

    @Override
    public void exit() {
        new LoginMenu().show();
    }
}
