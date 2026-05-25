package org.skypro.skyshop;

public class SimpleProduct extends Product{
    private double price;

    public SimpleProduct(String name, double price) {
        super(name);
        this.price = price;
    }
    @Override
    public double getPrice(){
        return this.price;


    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public String toString() {
        return getName() + ": " + getPrice() + " руб.";
    }



}
