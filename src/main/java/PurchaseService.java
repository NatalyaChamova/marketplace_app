package main.java;

public class PurchaseService {

    public static void buyProduct(User user, Product product) {
        float userMoney = user.getAmountOfMoney();
        if (userMoney >= product.getPrice()) {
            PurchaseStorage.addUserPurchase(user, product);
            userMoney -= product.getPrice();
            user.setAmountOfMoney(userMoney);
            System.out.println("Purchase is successful");
            System.out.println(user + " " + product);
        } else {
            throw new NotEnoughMoneyException();
        }
    }
}
