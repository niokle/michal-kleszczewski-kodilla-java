package com.kodilla.good.patterns.challenges;

import org.junit.Assert;
import org.junit.Test;

public class ProductOrderServiceTestSuite {

    @Test
    public void testProductOrderService() {
        //given
        Game game1 = new Game(1, "Gra", "Name 1", 10);
        Game game2 = new Game(2, "Gra", "Name 2", 20);
        Game game3 = new Game(3, "Gra", "Name 3", 30);
        Game game4 = new Game(4, "Gra", "Name 4", 40);
        Warehouse warehouse = new Warehouse();
        warehouse.addProductToStorage(game1, 1);
        warehouse.addProductToStorage(game2, 2);
        warehouse.addProductToStorage(game3, 3);
        User user = new User(1, "user 1");
        ProductOrderService productOrderService = new ProductOrderService(user, warehouse);

        //when
        productOrderService.orderProduct(game1, 2);
        productOrderService.orderProduct(game2, 2);
        productOrderService.orderProduct(game3, 2);

        //then
        Assert.assertEquals(1, warehouse.getQuantityAvailable(game1));
        Assert.assertEquals(0, warehouse.getQuantityAvailable(game2));
        Assert.assertEquals(1, warehouse.getQuantityAvailable(game3));
        Assert.assertEquals(0, warehouse.getQuantityAvailable(game4));
        Assert.assertEquals(false, productOrderService.productQuantityAvailability(game1, 2));
        Assert.assertEquals(false, productOrderService.productQuantityAvailability(game2, 2));
        Assert.assertEquals(true, productOrderService.productQuantityAvailability(game3, 1));
        Assert.assertEquals(false, productOrderService.productQuantityAvailability(game4, 1));
    }
}
