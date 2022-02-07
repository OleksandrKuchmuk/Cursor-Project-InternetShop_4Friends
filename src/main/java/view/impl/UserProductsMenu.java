package view.impl;

import view.Menu;

import java.util.Scanner;


public class UserProductsMenu implements Menu {


    private String[] items = {"1. Show product list", "2. Search product", "3. Add products to order ", "4. Confirm order", "0. Back to main menu"};
    private Scanner scanner = new Scanner(System.in);


    @Override
    public void show() {
        showItems(items);

        System.out.print("\nPlease enter the number of the action point you want to perform: ");


        Scanner scanner = new Scanner(System.in);

        while (true) {
            int choice = scanner.nextInt();

            switch (choice) {
                case 0:
                    exit();
                    break;
                case 1:
                    System.out.println("тут має сформуватись список продуктів");
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

    @Override
    public void exit() {
        new LoginMenu().show();
    }
}
