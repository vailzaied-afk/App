package org.skypro.skyshop.dop;

public interface Searchable{

    String searchTerm();
    void contentSearch();
    default void getStringRepresentation(String objectName, String objecType){
        System.out.println("Имя: " + objectName + "- Тип: " + objecType);
    }
}
