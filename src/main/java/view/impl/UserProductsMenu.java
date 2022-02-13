package view.impl;


import model.Order;
import model.OrderStatus;
import model.Product;
import service.OrderService;
import service.ProductService;
import service.Response;
import view.Menu;


import java.util.*;

public class UserProductsMenu implements Menu {


    private final String[] items = {"1. Show product list", "2. Search product", "3. Add products to order ",
            "4. Confirm order", "0. Back previous menu"};
    private final String[] checkoutItems = {"1.Remove product", "2.Change product count", "3.Confirm order", "0.Back"};

    private final UserMainMenu userMainMenu;
    private final OrderService orderService;
    private final ProductService productService;
    Scanner scanner = new Scanner(System.in);
    public UserProductsMenu(UserMainMenu userMainMenu,
                            OrderService orderService,
                            ProductService productService) {
        this.userMainMenu = userMainMenu;
        this.orderService = orderService;
        this.productService = productService;
    }


    @Override
    public void show()  {
        System.out.println("\nYou are in Product menu");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            showItems(items);
            System.out.print("\nPlease enter the number of the action point you want to perform: ");


//            int choice = MenuCorrectWater.menuCorrectWater(4);
            int choice = scanner.nextInt();

            switch (choice) {
                case 0: exit();
                case 1: showProductList();
                case 2: searchProduct(scanner);
                case 3: addProductToOrder(scanner);
                case 4: orderCheckout(scanner);
            }
        }
    }

    private void showProductList() {
            Response<Map<String, Product>> allProductsMapResponse = productService.getAllProducts();
            if (!allProductsMapResponse.isSuccessful()) {
                System.out.println(allProductsMapResponse.getMessage());
                return;
            }
            Map<String, Product> allProductsMap = allProductsMapResponse.getValue();
            System.out.println("Product list:");
            System.out.println("-".repeat(50));
            allProductsMap.values().forEach(System.out::println);
            System.out.println("-".repeat(50));
        }


    private void searchProduct(Scanner scanner) {
        List<Product> findProductList = new ArrayList<>();

        System.out.println("Exit - 0");
        System.out.println("Enter product name for search:");
        String productName = scanner.nextLine();

        try {
            int exit = Integer.parseInt(productName);
            if (exit == 0) {
                show();
            }
        }catch (NumberFormatException e){};

        Response<Map<String, Product>> allProductsResponse = productService.getAllProducts();;
//        try {
//            allProductsResponse = productService.getAllProducts();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }

        if (allProductsResponse.isSuccessful()) {
            Collection<Product> productCollection = allProductsResponse.getValue().values();
            for (Product product : productCollection) {
                if (product.getName().toLowerCase(Locale.ROOT).contains(productName.toLowerCase(Locale.ROOT))) {
                    findProductList.add(product);
                }
            }
        }
        if (findProductList.isEmpty()) {
            System.out.println("Product does not exist");
        } else {
            findProductList.forEach(System.out::println);
        }
    }

    private void addProductToOrder(Scanner scanner) {
        Response<Map<Integer, Order>> ordersByUserResponse = orderService.getOrdersByUser(userMainMenu.getCurrentUser());
        Collection<Order> orderCollection = ordersByUserResponse.getValue().values();
        int orderId = orderCollection.stream()
                .filter(order -> order.getOrderStatus() == OrderStatus.IN_PROGRESS)
                .findFirst()
                .orElseGet(() -> orderService.addOrder(new Order(userMainMenu.getCurrentUser())).getValue())
                .getId();
        while (true) {
            showProductList();

            System.out.println("Exit - 0");
            System.out.println("Enter product name: ");

            String productName = scanner.nextLine();
            try {
                int exit = Integer.parseInt(productName);
                if (exit == 0) {
                    show();
                }
            }catch (NumberFormatException e){};

            Response<Product> productResponse = productService.getProduct(productName);
            if (!productResponse.isSuccessful()) {
                System.out.println(productResponse.getMessage());
                continue;
            }
            Product product = productResponse.getValue();
            System.out.print("Enter quantity for '" + product.getName() + "': ");
            int quantity = scanner.nextInt();
            scanner.nextLine();
            Response<Order> addProductResponse = orderService
                    .addProductToOrder(orderId, productResponse.getValue(), quantity);
            System.out.println(addProductResponse.getMessage());
            if (addProductResponse.isSuccessful()) {
                break;
            }
        }
    }

    private void orderCheckout(Scanner scanner) {
        Response<Map<Integer, Order>> ordersByUserResponse = orderService.getOrdersByUser(userMainMenu.getCurrentUser());
        Collection<Order> orderCollection = ordersByUserResponse.getValue().values();
        Optional<Order> inProgressOptional = orderCollection.stream()
                .filter(order -> order.getOrderStatus() == OrderStatus.IN_PROGRESS)
                .findFirst();
        if (inProgressOptional.isEmpty()) {
            System.out.println("You have no active orders. New order creates in 'Add product to order'");
            return;
        }
        Order order = inProgressOptional.get();
        if (order.getProductMap().isEmpty()) {
            System.out.println("Your order is empty");
            return;
        }

        while (true) {
            System.out.println(order);
            showItems(checkoutItems);

//            int choise = MenuCorrectWater.menuCorrectWater(3);
            int choise = scanner.nextInt();
            scanner.nextLine();
            switch (choise){
                case 0:show();

                case 1: {
                    while (true) {
                        List<Product> productList = new ArrayList<>(order.getProductMap().keySet());
                        for (int i = 0; i < productList.size(); i++) {
                            System.out.println((i + 1) + "." + productList.get(i));
                        }
                        System.out.print("Choose product number for remove: ");
                        int productNumber = scanner.nextInt();
                        scanner.nextLine();
                        Product productToRemove;
                        try {
                            productToRemove = productList.get(productNumber - 1);
                        } catch (IndexOutOfBoundsException exception) {
                            System.out.println("Incorrect product number");
                            continue;
                        }
                        Response<Order> orderResponse = orderService.removeProductFormOrder(order.getId(), productToRemove);
                        System.out.println(orderResponse.getMessage());
                        if (orderResponse.isSuccessful()) {
                            order = orderResponse.getValue();
                        }
                        break;
                    }
                }
                case 2: {
                    while (true) {
                        Map<Product, Integer> productMap = order.getProductMap();
                        List<Product> productList = new ArrayList<>(productMap.keySet());
                        int counter = 0;
                        for (Map.Entry<Product, Integer> productCountEntry : productMap.entrySet()) {
                            System.out.println(++counter + "." + productCountEntry.getKey() +
                                    " - " + productCountEntry.getValue());
                        }
                        System.out.print("Choose product number for change count: ");
                        int productNumber = scanner.nextInt();
                        scanner.nextLine();
                        Product productToChangeCount;
                        try {
                            productToChangeCount = productList.get(productNumber - 1);
                        } catch (IndexOutOfBoundsException exception) {
                            System.out.println("Incorrect product number");
                            continue;
                        }
                        System.out.print("Enter new quantity: ");
                        int quantity = scanner.nextInt();
                        scanner.nextLine();
                        Response<Order> orderResponse =
                                orderService.addProductToOrder(order.getId(), productToChangeCount, quantity);
                        System.out.println(orderResponse.getMessage());
                        if (orderResponse.isSuccessful()) {
                            order = orderResponse.getValue();
                        }
                        break;
                    }
                }
                case 3: {
                    Response<Order> changeOrderStatusResponse =
                            orderService.changeOrderStatus(order.getId(), OrderStatus.AWAITING_CONFIRMATION);
                    System.out.println(changeOrderStatusResponse.getMessage());
                    if (changeOrderStatusResponse.isSuccessful()) {
                        order = changeOrderStatusResponse.getValue();
                        show();
                    }
                }

            }
        }
    }

    @Override
    public void exit() {

        userMainMenu.show();
    }
}
