package com.kodilla.good.patterns.challenges;

import java.util.ArrayList;
import java.util.List;

public class Warehouse implements ProductsStorage {
    private List<ProductInStorage> productInStorageList = new ArrayList<>();

    @Override
    public boolean isProductAvailable(Product product) {
        if (getListId(product) != null) {
            return true;
        }
        return false;
    }

    @Override
    public int getQuantityAvailable(Product product) {
        if (getListId(product) != null) {
            return productInStorageList.get(getListId(product)).getQuantity();
        }
        return 0;
    }

    @Override
    public boolean takeProductFromStorage(Product product, int quantity) {
        int finalQuantity;
        Integer listId = getListId(product);
        if (listId != null) {
            finalQuantity = productInStorageList.get(listId).getQuantity() - quantity;
            ProductInStorage newProductInStorage = new ProductInStorage(product, finalQuantity);
            productInStorageList.set(listId, newProductInStorage);
            return true;
        }
        return false;
    }

    @Override
    public void addProductToStorage(Product product, int quantity) {
        int finalQuantity;
        Integer listId = getListId(product);
        if (listId != null) {
            finalQuantity = productInStorageList.get(listId).getQuantity() + quantity;
            ProductInStorage newProductInStorage = new ProductInStorage(product, finalQuantity);
            productInStorageList.set(listId, newProductInStorage);
        } else {
            productInStorageList.add(new ProductInStorage(product, quantity));
        }
    }

    public Integer getListId(Product product) {
        for (int i = 0; i < productInStorageList.size(); i++) {
            if (productInStorageList.get(i).getProduct().getProductId() == product.getProductId()) {
                return i;
            }
        }
        return null;
    }

    public List<ProductInStorage> getProductInStorageList() {
        return productInStorageList;
    }
}
