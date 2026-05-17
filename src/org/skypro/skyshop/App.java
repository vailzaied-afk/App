package org.skypro.skyshop;

public class App {
    public static void main(String[] args) {
        ProductBasket productBasket = new ProductBasket();
        Product apple = new Product("Яблоко", 50);
        Product banana = new Product("Банан", 30);
        Product lemon = new Product("Лимон", 30);
        Product kiwi = new Product("Киви", 100);
        Product orange = new Product("Апельсин", 30);
        Product pineapple = new Product("Ананас", 30);


        productBasket.addProduct(apple);
        productBasket.addProduct(banana);
        productBasket.addProduct(lemon);
        productBasket.addProduct(kiwi);
        productBasket.addProduct(orange);
        System.out.println("\n--- Попытка добавить шестой продукт ---");
        productBasket.addProduct(pineapple);


        productBasket.wholeCart();


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
        productBasket.clearCartCompletely();
        String searchProduct = "Яблоко";

        if (productBasket.hasProductByName(searchProduct)) {
            System.out.println("Ошибка: Товар \"" + searchProduct + "\" найден в пустой корзине!");
        } else {
            System.out.println("Успех: Метод вернул false. В пустой корзине товар \"" + searchProduct + "\" не найден.");
        }
    }
}
