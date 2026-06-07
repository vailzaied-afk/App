package org.skypro.skyshop;

public class ProductBasket {
    private final Product[] products;

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
        System.out.println("Невозможно добавить продукт: корзина заполнена.");
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
        for (int i = 0; i < products.length; i++) {
            products[i] = null;
        }
        System.out.println("Корзина полностью очищена.");
    }
}
