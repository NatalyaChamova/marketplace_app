package main.java;

public class User {
    private final Integer id;
    private final String firstName;
    private final String lastName;
    private float amountOfMoney;

    public User(String firstName, String lastName, float amountOfMoney) {
        this.id = UsersStorage.getUsers().size() + 1;
        this.firstName = firstName;
        this.lastName = lastName;
        this.amountOfMoney = amountOfMoney;
    }

    public Integer getId() {
        return id;
    }

    public void setAmountOfMoney(float amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }

    public float getAmountOfMoney() {
        return amountOfMoney;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " " + amountOfMoney;
    }
}
