package view.impl;

import exception.MenuNumberCorrectInputException;
import model.Order;
import service.OrderService;
import service.Response;
import view.Menu;

import java.util.Map;

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
        while (true) {
            showItems(items);
            System.out.print("\nPlease enter the number of the action point you want to perform: ");
            int choice = MenuNumberCorrectInputException.menuNumberCorrectInputException(1); // checking to correct input
            switch (choice) {
                case 0:
                    userMainMenu.show();
                    break;
                case 1:
                    showOrderList();
                    break;
            }
        }
    }

    private void showOrderList() {
        Response<Map<Integer, Order>> ordersByUserResponse = orderService.getOrdersByUser(userMainMenu.getCurrentUser());
        if (!ordersByUserResponse.isSuccessful()) {
            System.out.println(ordersByUserResponse.getMessage());
            return;
        }
        System.out.println("Order list:");
        ordersByUserResponse.getValue().values().forEach(System.out::println);
    }
}