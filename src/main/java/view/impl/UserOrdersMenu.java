package view.impl;

import view.Menu;

import java.util.Scanner;

public class UserOrdersMenu implements Menu {
    private String[] items = {"1. Orders list", "0. Back to previous menu"};
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void show() {
        showItems(items);

        System.out.print("\nPlease enter the number of the action point you want to perform: ");


        Scanner scanner = new Scanner(System.in);

        while (true) {
            UserMainMenu userMainMenu = new UserMainMenu();
            int choice = scanner.nextInt();

            switch (choice) {
                case 0:
                    userMainMenu.show();
                    break;
                case 1:
                    System.out.println("тут має бути перевірка чи є список замовлень або повідомлення," +
                            " що замовлень ще нема, перехід на логіку, яка поверне список або повідомлення");
                    break;
            }
        }
        }


    @Override
    public void exit() {

    }
}
