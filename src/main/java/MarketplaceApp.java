package main.java;

import java.util.*;

public class MarketplaceApp {
    public static void main(String[] args) {
        displayMenu();
        boolean exit = false;

        Scanner input = new Scanner(System.in);
        while(!exit) {
            String menu = input.nextLine();
            if (menu.isBlank())
                continue;
            try {
                switch (Integer.parseInt(menu)) {
                    case 1:
                        displayListOfUsers();
                        break;
                    case 2:
                        displayListOfProducts();
                        break;
                    case 3:
                        addProducts(input);
                        break;
                    case 4:
                        addUsers(input);
                        break;
                    case 5:
                        buyProduct(input);
                        break;
                    case 6:
                        displayListOfUserProductsByUserId(input);
                        break;
                    case 7:
                        displayListOfUsersThatBoughtProductByProductId(input);
                        break;
                    case 8:
                        deleteUser(input);
                        break;
                    case 9:
                        deleteProduct(input);
                        break;
                    case 0:
                        exit = true;
                        input.close();
                        break;
                    default:
                        System.out.println("Number menu is incorrect");
                        displayMenu();
                }
            } catch (NotEnoughMoneyException | RequiredFieldInvalidException e) {
                System.out.println(e.getMessage());
                displayMenu();
            } catch (Exception e) {
                System.out.println("Number menu is incorrect");
                displayMenu();
            }
        }
    }

    private static void displayMenu() {
        System.out.println("Enter menu number:");
        System.out.println("1. Display list of users\n" +
                "2. Display list of products\n" +
                "3. Add new products\n" +
                "4. Add new user\n" +
                "5. Buy product\n" +
                "6. Display list of user products by user id\n" +
                "7. Display list of users that bought product by product id\n" +
                "8. Delete user by user id\n" +
                "9. Delete product by product id\n" +
                "0. Exit\n");
    }

    private static void displayListOfUsers() {
        UsersStorage.printAllUsers();
    }

    private static void displayListOfProducts() {
        ProductsStorage.printAllProducts();
    }

    private static void addProducts(Scanner input) {
        System.out.println("Enter product name:");
        String productName = input.nextLine();
        if (productName.isEmpty()) {
            throw new RequiredFieldInvalidException("productName");
        }
        System.out.println("Enter product price:");
        String price = input.nextLine();
        try {
            float productPrice = Float.parseFloat(price);
            ProductsStorage.addProduct(new Product(ProductsStorage.getProducts().size() + 1, productName, productPrice));
        } catch (NumberFormatException e) {
            throw new RequiredFieldInvalidException("productPrice");
        }
    }

    private static void addUsers(Scanner input) {
        System.out.println("Enter first name:");
        String userFirstName = input.nextLine();
        if (userFirstName.isEmpty()) {
            throw new RequiredFieldInvalidException("userFirstName");
        }
        System.out.println("Enter last name:");
        String userLastName = input.nextLine();
        if (userLastName.isEmpty()) {
            throw new RequiredFieldInvalidException("userLastName");
        }
        System.out.println("Enter amount of money:");
        String amountOfMoney = input.nextLine();
        try {
            float userAmountOfMoney = Float.parseFloat(amountOfMoney);
            UsersStorage.addUser(new User(userFirstName, userLastName, userAmountOfMoney));
        } catch (NumberFormatException e) {
            throw new RequiredFieldInvalidException("userAmountOfMoney");
        }
    }

    private static void buyProduct(Scanner input) {
        System.out.println("Enter user Id:");
        int userId = input.nextInt();
        System.out.println("Enter product Id:");
        int productId = input.nextInt();
        PurchaseService.buyProduct(UsersStorage.getUserById(userId), ProductsStorage.getProductById(productId));
    }

    private static void displayListOfUserProductsByUserId(Scanner input) {
        System.out.println("Enter user Id:");
        int userId = input.nextInt();
        PurchaseStorage.printAllUserPurchases(UsersStorage.getUserById(userId));
    }

    private static void displayListOfUsersThatBoughtProductByProductId(Scanner input) {
        System.out.println("Enter product Id:");
        int productId = input.nextInt();
        PurchaseStorage.printUsersThatBoughtProduct(ProductsStorage.getProductById(productId));
    }

    private static void deleteUser(Scanner input) {
        System.out.println("Enter user Id:");
        int userId = input.nextInt();
        User user = UsersStorage.getUserById(userId);
        PurchaseStorage.deleteByUser(user);
        UsersStorage.deleteUser(user);
        System.out.printf("%s is deleted\n", user.getFullName());
    }

    private static void deleteProduct(Scanner input) {
        System.out.println("Enter product Id:");
        int productId = input.nextInt();
        Product product = ProductsStorage.getProductById(productId);
        PurchaseStorage.deleteByProduct(product);
        ProductsStorage.deleteProduct(product);
        System.out.printf("%s is deleted\n", product.getName());
    }
}
