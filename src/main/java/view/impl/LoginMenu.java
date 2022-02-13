package view.impl;


import exception.MenuCorrectWater;
import model.User;
import model.UserRole;
import service.OrderService;
import service.ProductService;
import service.Response;
import service.UserService;
import view.Menu;

import java.io.IOException;
import java.util.Scanner;

public class LoginMenu implements Menu {

    private final String[] items = new String[]{"1.Login", "2.Register", "0.Exit"};
    private OrderService orderService;
    private UserService userService;
    private ProductService productService;
private boolean isRuning = true;
    public LoginMenu(OrderService orderService, UserService userService, ProductService productService) {
        this.orderService = orderService;
        this.userService = userService;
        this.productService = productService;
    }

    public void show()  {
        System.out.println("\nYou are in Main menu");

        Scanner scanner = new Scanner(System.in);

            while (isRuning) {
                showItems(items);
                System.out.print("\nPlease enter the number of the action point you want to perform: ");
  //            int choice = scanner.nextInt();

                int choice = MenuCorrectWater.menuCorrectWater(2); // перевырка ведення
                switch (choice) {
                    case 0:
                        exit();
                    case 1:
                        loginSubMenu();
                    case 2:
                        registerSubMenu();
                        break;
                    default:
                        System.out.println(choice + " does not exist");
                        showItems(items);
                }
            }

    }

    public void exit() {
        isRuning = false;
    }

    private void loginSubMenu()  {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Input login: ");
        String login = scanner.nextLine();
        System.out.print("Input password: ");
        String password = scanner.nextLine();
        Response<User> userResponse = userService.login(login, password);
        if (userResponse.isSuccessful()) {
            User user = userResponse.getValue();
            if (user.getUserRole() == UserRole.ADMIN) {
                new AdminMainMenu(this, userService, orderService, productService).show();
            } else {
                new UserMainMenu(this, orderService, productService, user).show();
            }
        } else {
            System.out.println(userResponse.getMessage());
            show();
        }

    }

    private void registerSubMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input login: ");
        String login = scanner.nextLine();
        System.out.print("Input password: ");
        String password = scanner.nextLine();
        System.out.print("Repeat password: ");
        String passwordRepeat = scanner.nextLine();
        if (!passwordRepeat.equals(password)) {
            System.out.println("Password mismatch! Try again");
            registerSubMenu();
        } else {
            Response<User> registerResponse = userService.register(login, password);
            if (registerResponse.isSuccessful()) {
                new UserMainMenu(this, orderService, productService, registerResponse.getValue()).show();
            } else {
                System.out.println(registerResponse.getMessage());
                registerSubMenu();
            }
        }

    }



    public ProductService getProductService() {
        return productService;
    }

    public OrderService getOrderService() {

        return orderService;
    }
}