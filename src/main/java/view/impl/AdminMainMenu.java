package view.impl;

import exception.MenuCorrectWater;
import model.User;
import service.OrderService;
import service.ProductService;
import service.Response;
import service.UserService;
import view.Menu;

import java.util.Scanner;

public class AdminMainMenu implements Menu {
    private final String[] items = {"1.Users menu", "2.Order menu", "3.Product menu", "0.Exit"};
    private final String[] itemsForUserMenu = {"1.Block user", "2.Unblock user", "0.Back"};
    private final String[] itemsForOrderMenu = {"1.Confirm", "2.Un confirm", "0.Back"};
    private final String[] itemsForProductMenu = {"1.Edit product", "2.Add product", "3.Delete product", "0.Back"};
    private final String[] itemsForEditProduct = {"1.Edit name", "2.Edit price", "3.Edit quantity", "0.Back"};
    private final LoginMenu loginMenu;
    private final UserService userService;
    private final OrderService orderService;
    private final ProductService productService;
    private Scanner scanner;

    public AdminMainMenu(LoginMenu loginMenu,
                         UserService userService,
                         OrderService orderService,
                         ProductService productService) {
        this.loginMenu = loginMenu;
        this.userService = userService;
        this.orderService = orderService;
        this.productService = productService;
    }

    @Override
    public void show() {
        System.out.println("\nYou are in Main admins menu");
        showItems(items);
        System.out.print("\nPlease enter the number of the action point you want to perform: ");
         scanner = new Scanner(System.in);

        while (true) {
   //         int choice = scanner.nextInt();
            int choice = MenuCorrectWater.menuCorrectWater(3); // перевірка ведення

            switch (choice) {
                case 0:
                    exit();
                    break;
                case 1:
                    usersMenu();
                    break;
                case 2:
                    ordersMenu();
                    break;
                case 3:
                    productMenu();
                    break;

            }
        }
    }

    private void usersMenu(){
        System.out.println("\nYou are in Admin menu: Users menu");
        showItems(itemsForUserMenu);
        System.out.print("\nPlease enter the number of the action point you want to perform: ");
        scanner = new Scanner(System.in);
        //int choice =scanner.nextInt();
        int choice = MenuCorrectWater.menuCorrectWater(2); // перевірка ведення
        //scanner.nextLine();
            switch (choice) {
                case 0:
                    show();
                    break;
                case 1: {
                    System.out.print("Enter username for blocking user: ");
                    Response<User> userResponse = userService.blockUser(scanner.nextLine());
                    System.out.println(userResponse.getMessage());
                    usersMenu();
                    break;
                }
                case 2: {
                    System.out.print("Enter username for un blocking user: ");
                    Response<User> userResponse = userService.unblockUser(scanner.nextLine());
                    System.out.println(userResponse.getMessage());
                    usersMenu();
                    break;

                }
                default:usersMenu();
            }

    }

    private void ordersMenu(){
        System.out.println("\nYou are in Admin menu: Orders menu");
        showItems(itemsForOrderMenu);
        System.out.print("\nPlease enter the number of the action point you want to perform: ");
        scanner = new Scanner(System.in);

        while (true) {
        //    int choice = scanner.nextInt();
            int choice = MenuCorrectWater.menuCorrectWater(2); // перевірка ведення
            switch (choice) {
                case 0:
                    show();
                    break;
                case 1:
                    System.out.println("тут має відбутись підтвердження замовлення(зміна статусу на 'підтверджений')");
                    show();
                    break;
                case 2:
                    System.out.println("тут має відбутись підтвердження замовлення(зміна статусу на 'не підтверджений')");
                    show();
                    break;
            }
        }
    }

    private void productMenu(){
        System.out.println("\nYou are in Admin menu: Products menu");
        showItems(itemsForProductMenu);
        System.out.print("\nPlease enter the number of the action point you want to perform: ");
        scanner = new Scanner(System.in);

        while (true) {
        //    int choice = scanner.nextInt();
            int choice = MenuCorrectWater.menuCorrectWater(3); // перевірка ведення
            switch (choice) {
                case 0:
                    show();
                    break;
                case 1:
                    editProducts();

                    break;
                case 2:
                    System.out.println("тут має відбутись зміна параметрів продукту (Add product) ");
                    break;
                case 3:
                    System.out.println("тут має відбутись зміна параметрів продукту (Delit product) ");
                    break;
            }
        }
    }



    private void editProducts(){
        System.out.println("\nYou are in Admin menu: Edit Product");
        showItems(itemsForEditProduct);
        System.out.print("\nPlease enter the number of the action point you want to perform: ");
        scanner = new Scanner(System.in);

        while (true) {
      //      int choice = scanner.nextInt();
            int choice = MenuCorrectWater.menuCorrectWater(3); // перевірка ведення
            switch (choice) {
                case 0:
                    productMenu();
                    break;
                case 1:
                    System.out.println("тут має відбутись зміна назви продукту");
                    break;
                case 2:
                    System.out.println("тут має відбутись зміна ціни продукту");
                    break;
                case 3:
                    System.out.println("тут має відбутись зміна кількості продукту");
                    break;
            }
        }
    }



    @Override
    public void exit() {
        System.exit(0);
    }
}
