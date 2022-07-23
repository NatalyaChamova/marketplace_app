package main.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProductsStorage {

    private static final HashMap<Integer, Product> products = new HashMap<>();

    public static List<Product> getProducts() {
        return new ArrayList<>(products.values());
    }

    public static void addProduct(Product product) {
        products.put(product.getId(), product);
        System.out.println("Product is successful added");
    }

    public static Product getProductById(int id) {
        return products.get(id);
    }

    public static void printAllProducts() {
        //System.out.println("List of all products:");
        for (Integer productId : products.keySet()) {
            System.out.println(productId + " " + products.get(productId));
        }
    }

    public static void deleteProduct(Product findProduct) {
        products.remove(findProduct.getId());
    }
}
