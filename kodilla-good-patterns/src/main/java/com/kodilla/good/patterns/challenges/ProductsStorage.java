package com.kodilla.good.patterns.challenges;

public interface ProductsStorage {
    boolean isProductAvailable(Product product);
    int getQuantityAvailable(Product product);
    boolean takeProductFromStorage(Product product, int quantity);
    void addProductToStorage(Product product, int quantity);
}
