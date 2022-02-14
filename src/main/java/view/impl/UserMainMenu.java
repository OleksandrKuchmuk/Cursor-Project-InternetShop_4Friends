package view.impl;


import exception.MenuNumberCorrectInputException;
import model.User;
import service.OrderService;
import service.ProductService;
import view.Menu;

public class UserMainMenu implements Menu {
    private final String[] items = {"1. Products menu", "2. My orders", "0. Logout"};
    private final LoginMenu loginMenu;
    private final OrderService orderService;
    private final ProductService productService;
    private final User currentUser;

    public UserMainMenu(LoginMenu loginMenu, OrderService orderService, ProductService productService, User currentUser) {
        this.loginMenu = loginMenu;
        this.orderService = orderService;
        this.productService = productService;
        this.currentUser = currentUser;
    }

    @Override
    public void show() {
        System.out.println("\nYou are in User menu");
        showItems(items);
        System.out.print("\nPlease enter the number of the action point you want to perform: ");
        while (true) {
            int choice = MenuNumberCorrectInputException.menuNumberCorrectInputException(2); // checking to correct input
            switch (choice) {
                case 0 -> loginMenu.show();
                case 1 -> new UserProductsMenu(this, orderService, productService).show();
                case 2 -> new UserOrdersMenu(this, orderService).show();
            }
        }
    }

    User getCurrentUser() {
        return currentUser;
    }
}
