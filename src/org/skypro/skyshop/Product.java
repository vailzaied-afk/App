package org.skypro.skyshop;

public abstract class Product {
    private final String name;

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract double getPrice();

    public boolean isSpecial() {
        return false;
    }


}
