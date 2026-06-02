package org.skypro.skyshop.dop;

public interface Searchable{

    String searchTerm();
    String getContentType();

    String getStringRepresentation(String objectName, String objectType);


}
