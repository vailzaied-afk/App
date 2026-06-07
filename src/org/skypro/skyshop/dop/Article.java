package org.skypro.skyshop.dop;

public class Article implements Searchable {

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
        return this.toString();
    }

    @Override
    public String getContentType() {
        return "ARTICLE";
    }

    @Override
    public String getStringRepresentation(String objectName, String objectType) {
        return "Имя: " + objectName + " - Тип: " + objectType;
    }


    @Override
    public String toString() {
        return name + "\n" + text;
    }
}
