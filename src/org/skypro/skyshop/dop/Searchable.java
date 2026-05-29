package org.skypro.skyshop.dop;

public interface Searchable{

    String searchTerm();
    void contentSearch();
    default String getStringRepresentation(String objectName, String objectType){
        return "Имя: " + objectName + "- Тип: " + objectType;
    }

}
