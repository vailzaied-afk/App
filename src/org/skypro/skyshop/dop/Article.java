package org.skypro.skyshop.dop;

import org.skypro.skyshop.Product;

public class Article implements Searchable{

    private final String name;
    private final String text;

    public Article(String name, String text) {
        this.name = name;
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }
    @Override
    public String searchTerm() {

        return getName() + " PRODUCT " + this.toString() + " ARTICLE ";
    }

    @Override
    public void contentSearch() {

    }

    @Override
    public String toString() {
        return "Название статьи:\n" + getName() + "\nТекст статьи:\n" + getText();
    }
}
