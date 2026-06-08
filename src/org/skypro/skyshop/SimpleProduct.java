package org.skypro.skyshop;

public class SimpleProduct extends Product {
    private double price;

    public SimpleProduct(String name, String type, double price) {
        super(name, type);
        SimpleProduct.checkPrice(price);

        this.price = price;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public String toString() {
        return super.getName() + ": " + this.getPrice() + " руб.";
    }

    @Override
    public String searchTerm() {
        return this.toString();
    }

    @Override
    public String getContentType() {
        return null;
    }

    public static void checkPrice(double price) throws IllegalArgumentException{
        if (price<0){
            throw new IllegalArgumentException("Не правильная цена");
        }


    }

}
