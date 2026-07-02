package org.skypro.skyshop;

import java.util.*;
import java.util.Collections;
import java.util.stream.Collectors;

public class ProductBasket {
    private Map<String, List<Product>> products = new TreeMap<>();

    public ProductBasket() {



    }



    public void clearProduct(Product product) {
        if (products.remove(product.getName()) != null) {
            System.out.println("Удален продукт: " + product.getName());
        } else {
            System.out.println("Продукт " + product.getName() + " не найден в корзине.");
        }
    }




    public void addProduct(Product product) {
        if (product == null || product.getName() == null || product.getName().isBlank()) {
            System.out.println("Ошибка: нельзя добавить пустой товар.");
            return;
        }

        products.computeIfAbsent(product.getName(), k -> new ArrayList<>()).add(product);
        System.out.println(product.getName() + " добавлен в корзину.");
    }

    public boolean hasProductByName(String productName) {
        if (productName == null) {
            return false;
        }
        return products.containsKey(productName);

    }

    @Override
    public String toString() {

        List<Product> allProducts = products.values().stream()
                .filter(Objects::nonNull)
                .flatMap(Collection::stream)
                .sorted(Comparator.comparing(Product::getName, String.CASE_INSENSITIVE_ORDER))
                .toList();
        if (allProducts.isEmpty()) {
            return "В корзине пусто\nИтого: 0 руб.";
        }


        StringBuilder sb = new StringBuilder();
        sb.append("Содержимое корзины:\n");
        allProducts.stream()
                .forEach(product -> sb.append(product).append("\n"));

                sb.append("Специальных товаров: ").append(getSpecialCount()).append("\n")
                .append("Итого: ").append(getTotalPrice()).append(" руб.");



        return sb.toString();
    }
    public  double getTotalPrice(){
        return products.values().stream()
                .filter(Objects::nonNull)
                .flatMap(Collection::stream)
                .filter(Objects::nonNull)
                .mapToDouble(Product::getPrice)
                .sum();

    }
    public long getSpecialCount(){
        return products.values().stream()
                .filter(Objects::nonNull)
                .flatMap(Collection::stream)
                .filter(Objects::nonNull)
                .filter(Product::isSpecial)
        .count();
    }

    public void clearCartCompletely() {
        products.clear();
        System.out.println("Корзина полностью очищена.");
    }


}
