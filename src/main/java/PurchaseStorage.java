package main.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class PurchaseStorage {
    private static final HashMap<User, List<Product>> purchasesByUsers = new HashMap<>();

    public static List<Product> getUserPurchases(User user) {
        return purchasesByUsers.get(user);
    }

    public static void addUserPurchase(User user, Product product) {
        if (purchasesByUsers.get(user) == null) {
            purchasesByUsers.put(user, new ArrayList<>());
        }

        List<Product> userPurchases = purchasesByUsers.get(user);
        if (!userPurchases.contains(product)) {
            userPurchases.add(product);
        }
    }

    public static void printAllUserPurchases(User user) {
        System.out.printf("List of all %s products:\n", user.getFullName());
        List<Product> products = purchasesByUsers.get(user);
        if (products != null) {
            for (Product product : products) {
                System.out.println(product.getName());
            }
        }
    }

    public static void printUsersThatBoughtProduct(Product findProduct) {
        System.out.printf("List of all users that bought %s:\n", findProduct.getName());
        for (User user : purchasesByUsers.keySet()) {
            if (PurchaseStorage.getUserPurchases(user).contains(findProduct)) {
                System.out.println(user.getFullName());
            }
        }
    }

    public static void printAllPurchase() {
        System.out.println("List of all purchases:");
        for (User user : purchasesByUsers.keySet()) {
            System.out.print(user.getFullName() + " ");
            for (Product product : PurchaseStorage.getUserPurchases(user)) {
                System.out.print(product.getName() + " ");
            }
            System.out.println();
        }
    }

    public static void deleteByProduct(Product product) {
        for (List<Product> products : purchasesByUsers.values()) {
            products.remove(product);
        }
    }

    public static void deleteByUser(User user) {
        purchasesByUsers.remove(user);
    }
}
