package view.impl;


import model.User;
import model.UserRole;
import service.ProductService;
import service.Response;
import service.UserService;
import service.impl.UserServiceImpl;
import view.Menu;

import java.util.Scanner;

public class LoginMenu implements Menu {

    private UserService userService;
    private String[] items = new String[]{"1.Login", "2.Register", "0.Exit"};
    private Scanner scanner;
    public LoginMenu( UserService userService) {
        this.userService = userService;
    }

    @Override
    public void show() {
        showItems(items);
        scanner = new Scanner(System.in);
        while (true) {
            point:

            while (true) {
                int choice = scanner.nextInt();

                switch (choice) {
                    case 0:
                        exit();
                    case 1:
                        loginSubMenu();
                        break;
                    case 2:
                        break point;
                }
            }
            registerSubMenu();
        }
    }

    @Override
    public void exit() {
        System.exit(0);
    }

    private void loginSubMenu() {
        Response<User> userResponse;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input login: ");
        String login = scanner.nextLine();
        System.out.print("Input password: ");
        String password = scanner.nextLine();
        userResponse = userService.login(login, password);
        if (userResponse.isSuccessful()) {
            User user = userResponse.getValue();
            if (user.getUserRole() == UserRole.ADMIN) {
                System.out.println("Admin");
            } else {
                new UserMainMenu().show();
            }
        } else {
            System.out.println(userResponse.getMessage());
            show();
        }
    }

    private void registerSubMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input login: ");
        String login = scanner.nextLine();
        System.out.print("Input password: ");
        String password = scanner.nextLine();
        System.out.print("Repeat password: ");
        String passwordRepeat = scanner.nextLine();
        if (!passwordRepeat.equals(password)) {
            System.out.println("Password mismatch! Try again");
            this.registerSubMenu();
        } else {
            Response<User> registerResponse = this.userService.register(login, password);
            if (registerResponse.isSuccessful()) {
                (new UserMainMenu()).show();
            } else {
                System.out.println(registerResponse.getMessage());
                this.registerSubMenu();
            }
        }

    }
}
