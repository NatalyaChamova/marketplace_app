package main.java;

public class Product {
    private final Integer id;
    private final String name;
    private final float price;

    public Product(Integer id, String name, float price) {
        this.name = name;
        this.price = price;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public Float getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " " + price;
    }
}
