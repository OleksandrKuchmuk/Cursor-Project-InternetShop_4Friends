package view.impl;


import service.UserService;
import view.Menu;

import java.util.Scanner;

public class LoginMenu implements Menu {

    private UserService userService;
    UserMainMenu userMainMenu = new UserMainMenu();
    private String[] items = {"1.Login", "2.Register", "0. Exit"};
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
                    loginSubMenu();
                    break;
                case 2:
                    registerSubMenu();
                    break;
                case 0:
                    exit();
                    break;
            }
        }
    }

    @Override
    public void exit() {
        System.exit(0);
    }

    private void loginSubMenu() {
        System.out.println("\nYou are in the login menu");
        System.out.println("Please, input your login:");
        String login = scanner.nextLine();

        System.out.println("\nPlease, input your password:");
        String password = scanner.nextLine();



        System.out.println("You ere just login tu our Shop");
        //тут мало би перходити на UserService  і перевіряти чи відповідають параметри login&password
        //так думаю що на юзер сервіс має бути валідатор, який перевіряє login&password на валідність і наявність в базі

        userMainMenu.show();    //тимчасово, щоб перейти в наступне меню


//        if (userService.login(login, password)) {
//            new ProductMenu().show();
//        } else {
//            System.out.println("Wrong username/pasword");
//            show();
//        }

    }

    private void registerSubMenu() {
        System.out.println("\nYou are in the register menu");
        System.out.println("Please, input login:");
        String login = scanner.nextLine();

        System.out.println("Please,input password:");
        String password = scanner.nextLine();

        System.out.println("Please,confirm password(must be the same, as password):");
        String confirmPassword = scanner.nextLine();

        System.out.println("You are just registered in our Shop");
        //тут мало би перходити на UserService  і перевіряти чи відповідають параметри login&password
        //так думаю що на юзер сервіс має бути валідатор, який перевіряє login&password на валідність і вносити в базу

        userMainMenu.show(); //тимчасово, щоб перейти в наступне меню


//        if (userService.login(login, password)) {
//            new ProductMenu().show();
//        } else {
//            System.out.println("Wrong username/pasword");
//            show();
//        }
    }


//    private void registerSubMenu(Scanner scanner) {
//        show(); //todo add impl
//    }
}
