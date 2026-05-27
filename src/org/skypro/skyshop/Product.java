package org.skypro.skyshop;

import org.skypro.skyshop.dop.Searchable;

public abstract class Product implements Searchable{
    private final String name;

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract double getPrice();

    public abstract boolean isSpecial();


}
