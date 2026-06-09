package org.skypro.skyshop.BestResultNotFound;

public class BestResultNotFound extends Exception {
    public static String query;
    public BestResultNotFound(String message, String query) {
        super(message + ": " + query);
        this.query = query;
    }

    public BestResultNotFound(String message, Exception e) {
    }

    public String getQuery() {
        return query;
    }
}
