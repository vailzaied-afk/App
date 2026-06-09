package org.skypro.skyshop;

public class DiscountedProduct extends Product{
    private double basePrice;
    private int discountInWholePercentages;

    public DiscountedProduct(String name, String type, double basePrice, int discountInWholePercentages) {
        super(name, type);
        DiscountedProduct.checkPriceDiscounted(basePrice, discountInWholePercentages);
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
    public String getContentType() {
        return null;
    }

    public static void checkPriceDiscounted(double basePrice, int discountInWholePercentages) throws IllegalArgumentException {
        if (basePrice <= 0 || discountInWholePercentages < 0 || discountInWholePercentages > 100) {
            throw new IllegalArgumentException("Цена ниже нуля или скидка должна быть в диапазоне от 0 до 100%. Передано: " + discountInWholePercentages);
        }
    }


}
