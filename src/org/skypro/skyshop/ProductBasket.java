package org.skypro.skyshop;

import java.util.ArrayList;
import java.util.List;

public class ProductBasket {
    private Product[] products;

    public ProductBasket() {
        this.products = new Product[5];
    }

    public void addProduct(Product product) {
        if (product == null) {
            System.out.println("Ошибка: нельзя добавить пустой товар.");
            return;
        }


        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
                products[i] = product;
                System.out.println(product.getName() + " добавлен в корзину.");
                return;


            }
        }


        System.out.println("Невозможно добавить продукт");
    }


    public boolean hasProductByName(String productName) {
        if (productName == null || products == null) {
            return false;
        }

        for (Product product : products) {
            if (product != null && productName.equalsIgnoreCase(product.getName())) {
                return true;
            }
        }

        return false;
    }

    public void wholeCart() {
        System.out.println("Содержимое корзины:");

        if (products == null) {
            System.out.println("Корзина не инициализирована.");
            System.out.println("Итого: 0 руб.");
            return;
        }
        double totalSum = 0;
        boolean hasItems = false;

        for (Product product : products) {
            if (product != null) {
                System.out.println("- " + product.getName() + ": " + product.getPrice() + " руб.");
                totalSum += product.getPrice();
                hasItems = true;
            } else {
                System.out.println("- [Пустая ячейка]");
            }
        }

        if (!hasItems) {
            System.out.println("Корзина пуста (все ячейки свободны).");
        }
        System.out.println("Итого: " + totalSum + " руб.");
    }

    public void clearCartCompletely() {
        if (products != null) {
            for (int i = 0; i < products.length; i++) {
                products[i] = null;
            }
            System.out.println("Корзина полностью очищена. Итого: 0");
        }
    }


}
