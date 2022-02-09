package view.impl;

import model.Order;
import service.OrderService;
import service.Response;
import view.Menu;

import java.util.Map;
import java.util.Scanner;

public class UserOrdersMenu implements Menu {
    private String[] items = {"1. Orders list", "0. Back to previous menu"};
//    private Scanner scanner = new Scanner(System.in);

    private final UserMainMenu userMainMenu;
    private final OrderService orderService;

    public UserOrdersMenu(UserMainMenu userMainMenu, OrderService orderService) {
        this.userMainMenu = userMainMenu;
        this.orderService = orderService;
    }

    @Override
    public void show() {
        System.out.println("\nYou are in user orders menu");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            showItems(items);
            System.out.print("\nPlease enter the number of the action point you want to perform: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 0:
                    exit();
                    break;
                case 1:
                   showOrderList();
                    break;
            }
        }
        }

        private void showOrderList(){
            Response<Map<Integer, Order>> ordersByUserResponse = orderService.getOrdersByUser(userMainMenu.getCurrentUser());
            if (!ordersByUserResponse.isSuccessful()) {
                System.out.println(ordersByUserResponse.getMessage());
                return;
            }
            System.out.println("Order list:");
            ordersByUserResponse.getValue().values().forEach(System.out::println);
        }

    @Override
    public void exit() {
        userMainMenu.show();
    }
}
