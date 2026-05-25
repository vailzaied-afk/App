package org.skypro.skyshop;

public class FixPriceProduct extends Product{
    private final double FIX_PRICE;

    public FixPriceProduct(String name, double FIX_PRICE) {
        super(name);
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


}
