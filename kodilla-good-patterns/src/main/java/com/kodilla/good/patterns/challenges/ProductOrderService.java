package com.kodilla.good.patterns.challenges;

public class ProductOrderService {
    private User user;
    private ProductsStorage productsStorage;

    public ProductOrderService(User user, ProductsStorage productsStorage) {
        this.user = user;
        this.productsStorage = productsStorage;
    }

    public boolean orderProduct(Product product, int quantity) {
        if (productAvailability(product) && productQuantityAvailability(product, quantity)) {
            productsStorage.takeProductFromStorage(product, quantity);
            System.out.println("Kupiłeś " + quantity + " szt. " + product.getProductType() + " " + product.getProductName() + " za sumę " + product.getProductPrice() * quantity + ".");
        }
        return false;
    }

    public boolean productAvailability(Product product) {
        boolean result;
        if (productsStorage.isProductAvailable(product)) {
            result = true;
        } else {
            System.out.println("Produkt " + product.getProductType() + " " + product.getProductName() + " nie jest obecnie dostępny.");
            result = false;
        }
        return result;
    }

    public boolean productQuantityAvailability(Product product, int quantity) {
        boolean result;
        if (productsStorage.getQuantityAvailable(product) >= quantity) {
            result = true;
        } else {
            System.out.println("Nie ma takiej ilości produktu " + product.getProductType() + " " + product.getProductName() + ", wybierz mniejszą ilość.");
            result = false;
        }
        return result;
    }

    public static void main(String[] args) {
        User user = new User(234, "User 1");
        Warehouse warehouse = new Warehouse();
        Game game1 = new Game(1, "Gra", "Doom", 25);
        Game game2 = new Game(2, "Gra", "Star Wars Battlefront", 125);
        Game game3 = new Game(3, "Gra", "Sky City", 200);
        warehouse.addProductToStorage(game1, 2);
        warehouse.addProductToStorage(game2, 100);

        ProductOrderService productOrderService = new ProductOrderService(user, warehouse);
        productOrderService.orderProduct(game3, 2);
        productOrderService.orderProduct(game1, 1);
        productOrderService.orderProduct(game1, 2);
        productOrderService.orderProduct(game2, 100);
    }
}
