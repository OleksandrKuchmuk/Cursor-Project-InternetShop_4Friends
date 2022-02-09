package view.impl;

import service.OrderService;
import view.Menu;

import java.util.Scanner;

public class UserOrdersMenu implements Menu {
    private final String[] items = {"1. Orders list", "0. Back to previous menu"};

    private final UserMainMenu userMainMenu;
    private final OrderService orderService;

    public UserOrdersMenu(UserMainMenu userMainMenu, OrderService orderService) {
        this.userMainMenu = userMainMenu;
        this.orderService = orderService;
    }

    @Override
    public void show() {
        System.out.println("\nYou are in user orders menu");
        showItems(items);

        System.out.print("\nPlease enter the number of the action point you want to perform: ");


        Scanner scanner = new Scanner(System.in);

        while (true) {
            //UserMainMenu userMainMenu = new UserMainMenu();
            int choice = scanner.nextInt();

            switch (choice) {
                case 0 -> exit();
                case 1 -> System.out.println("тут має бути перевірка чи є список замовлень або повідомлення," +
                        " що замовлень ще нема, перехід на логіку, яка поверне список або повідомлення");
            }
        }
    }

    @Override
    public void exit() {
        userMainMenu.show();
    }
}
