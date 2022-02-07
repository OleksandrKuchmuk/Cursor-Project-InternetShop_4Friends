package view.impl;


import model.User;
import model.UserRole;
import service.Response;
import service.UserService;
import view.Menu;

import java.util.Scanner;

public class LoginMenu implements Menu {

    private UserService userService;


    public LoginMenu() {
        this.userService = userService;
    }

    UserMainMenu userMainMenu = new UserMainMenu();
    private String[] items = {"1.Login as user", "2.Login as admin","3. Register", "0. Exit"};
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
                    userLoginSubMenu();
                    break;
                case 2:
                    // перевірка введених даних, вхід в меню адміна
                    AdminMainMenu adminMainMenu = new AdminMainMenu();
                    adminMainMenu.show();
                    break;
                case 3:
                    registerSubMenu();
                    break;

            }
            registerSubMenu();
        }
    }

    @Override
    public void exit() {
        System.exit(0);
    }


    private void userLoginSubMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nYou are in the login menu");
        System.out.println("Please, input your login:");
        String login = scanner.nextLine();

        System.out.println("\nPlease, input your password:");
        String password = scanner.nextLine();

        Response<User> userResponse;
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


        System.out.println("You ere just login tu our Shop");
        //тут мало би перходити на UserService  і перевіряти чи відповідають параметри login&password
        //так думаю що на юзер сервіс має бути валідатор, який перевіряє login&password на валідність і наявність в базі

        userMainMenu.show();    //тимчасово, щоб перейти в наступне меню
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
