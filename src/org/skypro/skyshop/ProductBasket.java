package org.skypro.skyshop;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProductBasket {
    private ArrayList<Product> products;

    public ProductBasket() {
        this.products = new ArrayList<>();

    }



    public void clearProduct(Product product) {
        if (products.remove(product)) {
            System.out.println("Удален продукт: " + product.getName());
        } else {
            System.out.println("Продукт " + product.getName() + " не найден в корзине.");
        }
    }



    public void addProduct(Product product) {
        if (product == null) {
            System.out.println("Ошибка: нельзя добавить пустой товар.");
            return;
        }

        products.add(product);
        System.out.println(product.getName() + " добавлен в корзину.");
    }

    public boolean hasProductByName(String productName) {
        if (productName == null) {
            return false;
        }

        for (Product product : products) {
            if (product != null && productName.equalsIgnoreCase(product.getName())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Содержимое корзины:\n");

        double totalSum = 0;
        int specialItemsCount = 0;
        boolean isEmpty = true;

        for (Product product : products) {
            if (product != null) {
                sb.append(product).append("\n");
                totalSum += product.getPrice();
                if (product.isSpecial()) {
                    specialItemsCount++;
                }
                isEmpty = false;
            }
        }

        if (isEmpty) {
            return "В корзине пусто\nИтого: 0 руб.";
        }

        sb.append("Специальных товаров: ").append(specialItemsCount).append("\n");
        sb.append("Итого: ").append(totalSum).append(" руб.");

        return sb.toString();
    }

    public void clearCartCompletely() {
        products.clear();
        System.out.println("Корзина полностью очищена.");
    }
}
