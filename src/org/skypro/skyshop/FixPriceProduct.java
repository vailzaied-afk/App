package org.skypro.skyshop;

public class FixPriceProduct extends Product{
    private final double FIX_PRICE;


    public FixPriceProduct(String name, String type, double FIX_PRICE) {
        super(name, type);
        this.FIX_PRICE = FIX_PRICE;
    }

    @Override
    public double getPrice() {
        return this.FIX_PRICE;
    }
    @Override
    public String toString() {
        return getName() + " (Фиксированная цена: " + FIX_PRICE + " руб.)";


    }
    @Override
    public boolean isSpecial() {
        return true;
    }


    @Override
    public String searchTerm() {

        return getName() + " PRODUCT " + this.toString() + " ARTICLE ";
    }

    @Override
    public String getContentType() {
        return null;
    }


}
