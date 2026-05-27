package org.skypro.skyshop;

public class DiscountedProduct extends Product{
    private double basePrice;
    private int discountInWholePercentages;

    public DiscountedProduct(String name, double basePrice, int discountInWholePercentages) {
        super(name);
        this.basePrice = basePrice;
        this.discountInWholePercentages = discountInWholePercentages;
    }
    @Override
    public double getPrice(){

        return this.basePrice * (1 - (this.discountInWholePercentages / 100.0));


    }
    @Override
    public String toString() {
        return getName() + " (Цена со скидкой: " + getPrice() + " руб.)";


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
    public void contentSearch() {

    }
}
