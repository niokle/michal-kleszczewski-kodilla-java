package com.kodilla.good.patterns.food2door;

import java.util.List;

public class SendOrder {
    public boolean isResult(String name, Service service, List<Product> productsList) {
        boolean result = false;
        for (Order order : service.getOrders()) {
            for (Product product : productsList) {
                if (order.getProduct().equals(product)) {
                    System.out.println(name + " wysłał produkt " + product.getType() + " w ilości " + product.getQuantity() + " do " + order.getPurchaser().getName());
                    order.setCompleted(true);
                    result = true;
                }
            }
        }
        return result;
    }
}
