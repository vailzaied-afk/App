package org.skypro.skyshop;

import org.skypro.skyshop.dop.Searchable;

public abstract class Product implements Searchable {
    private final String name;
    private final String type;

    public Product(String name, String type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String searchTerm() {
        return this.toString();
    }

    @Override
    public String getStringRepresentation(String objectName, String objectType) {
        return this.toString();
    }

    @Override
    public String toString() {
        return "Имя: " + name + " - Тип: " + type;
    }

    public abstract double getPrice();

    public abstract boolean isSpecial();

    public String getName() {
        return this.name;
    }

    @Override
    public String getContentType() {
        return "PRODUCT";
    }
}
