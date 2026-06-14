package org.skypro.skyshop;

import org.skypro.skyshop.BestResultNotFound.BestResultNotFound;
import org.skypro.skyshop.dop.Article;
import org.skypro.skyshop.dop.SearchEngine;
import org.skypro.skyshop.dop.Searchable;

import java.util.ArrayList;
import java.util.List;

import static org.skypro.skyshop.DiscountedProduct.checkPriceDiscounted;


public class App {
    private static void printSearchResults(Searchable[] results){
        if (results.length == 0) {
            System.out.println("Ничего не найдено.");
            return;
        }
        for (Searchable item : results) {
            System.out.println("- " + item.searchTerm());
        }
    }

    public static void main(String[] args) throws BestResultNotFound{
        ProductBasket productBasket = new ProductBasket();
        /*
        try {
            DiscountedProduct product = new DiscountedProduct(null, "Фрукт", 0, 1000);
            productBasket.addProduct(product);
        }catch (IllegalArgumentException e) {
            System.out.println("Нет названия или неверные параметры");

        } catch (Exception e){
            throw new BestResultNotFound("Не удалось добавить лучший результат в корзину", e);

        }

         */





        FixPriceProduct apple = new FixPriceProduct("Яблоко", "Фрукт", 50);
        DiscountedProduct banana = new DiscountedProduct("Банан", "Фрукт", 30, 20);
        DiscountedProduct lemon = new DiscountedProduct("Лимон", "Фрукт", 30, 20);
        FixPriceProduct kiwi = new FixPriceProduct("Киви", "Фрукт", 10);
        Product orange = new SimpleProduct("Апельсин", "Фрукт", 30);

        productBasket.addProduct(apple);
        productBasket.addProduct(banana);
        productBasket.addProduct(lemon);
        productBasket.addProduct(kiwi);
        productBasket.addProduct(orange);
        System.out.println(productBasket);

        productBasket.clearProduct(lemon);








        SearchEngine searchEngine = new SearchEngine(4);
        Searchable book = new SimpleProduct("Книга", "Печатное издание", 505);
        Searchable book1 = new SimpleProduct("Книга1", "Печатное издание", 500);

        Searchable artBook = new Article("Тест", "История");
        Searchable artBook1 = new Article("Краткий текст 2", "История о второй книге");

        searchEngine.add(book);
        searchEngine.add(book1);
        searchEngine.add(artBook);
        searchEngine.add(artBook1);

        System.out.println("--- Результаты поиска по запросу 'Книга' ---");
        printSearchResults(searchEngine.search("Книга"));

        System.out.println("\n--- Результаты поиска по запросу 'Тест' ---");
        printSearchResults(searchEngine.search("Тест"));

        System.out.println("\n--- Результаты поиска по отсутствующему запросу 'Пицца' ---");
        printSearchResults(searchEngine.search("Пицца"));

        System.out.println("\n" + productBasket);

        System.out.println("\nТовар ЕСТЬ в корзине");
        String existingProduct = "Лимон";
        if (productBasket.hasProductByName(existingProduct)) {
            System.out.println("Успех: Товар \"" + existingProduct + "\" найден.");
        } else {
            System.out.println("Ошибка: Товар не найден.");
        }

        System.out.println("\nТовара НЕТ в корзине");
        String missingProduct = "Печенье";
        if (productBasket.hasProductByName(missingProduct)) {
            System.out.println("Ошибка: Товар \"" + missingProduct + "\" найден.");
        } else {
            System.out.println("Успех: Товар \"" + missingProduct + "\" отсутствует в корзине.");
        }

        /*
        productBasket.clearCartCompletely();
        String searchProduct = "Яблоко";

        if (productBasket.hasProductByName(searchProduct)) {
            System.out.println("Ошибка: Товар \"" + searchProduct + "\" найден в пустой корзине!");
        } else {
            System.out.println("Успех: Метод вернул false. В пустой корзине товар \"" + searchProduct + "\" не найден.");
        }

         */
    }
}
