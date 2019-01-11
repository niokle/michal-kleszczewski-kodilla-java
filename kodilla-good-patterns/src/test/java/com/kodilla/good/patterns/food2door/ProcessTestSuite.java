package com.kodilla.good.patterns.food2door;

import org.junit.Assert;
import org.junit.Test;

public class ProcessTestSuite {
    @Test
    public void testExtraFoodShop() {
        //given
        Purchaser purchaser1 = new Purchaser("name 1", "street 1", "02-123", "Warszawa");
        Purchaser purchaser2 = new Purchaser("name 2", "street 2", "32-123", "Krakow");
        Product product1 = new Product("jablko", 3);
        Product product2 = new Product("gruszka", 1);
        Product product3 = new Product("ser", 2);
        Product product4 = new Product("szynka", 4);
        Product product5 = new Product("mięta", 5);
        Product product6 = new Product("kukurydza", 6);
        DistributionService distributionService = new DistributionService();
        ExtraFoodShop extraFoodShop = new ExtraFoodShop();
        HealthyShop healthyShop = new HealthyShop();
        GlutenFreeShop glutenFreeShop = new GlutenFreeShop();
        extraFoodShop.addProduct(product1);
        extraFoodShop.addProduct(product2);
        extraFoodShop.addProduct(product3);
        healthyShop.addProduct(product4);
        healthyShop.addProduct(product5);
        glutenFreeShop.addProduct(product6);
        distributionService.addNewOrder(purchaser1, product1);
        distributionService.addNewOrder(purchaser1, product2);
        distributionService.addNewOrder(purchaser1, product5);
        distributionService.addNewOrder(purchaser1, product6);
        distributionService.addNewOrder(purchaser2, product3);
        distributionService.addNewOrder(purchaser2, product6);
        //when
        extraFoodShop.process(distributionService);
        //then
        Assert.assertEquals(3, distributionService.getActiveOrders().size());
    }

    @Test
    public void testGlutenFreeShop() {
        //given
        Purchaser purchaser1 = new Purchaser("name 1", "street 1", "02-123", "Warszawa");
        Purchaser purchaser2 = new Purchaser("name 2", "street 2", "32-123", "Krakow");
        Product product1 = new Product("jablko", 3);
        Product product2 = new Product("gruszka", 1);
        Product product3 = new Product("ser", 2);
        Product product4 = new Product("szynka", 4);
        Product product5 = new Product("mięta", 5);
        Product product6 = new Product("kukurydza", 6);
        DistributionService distributionService = new DistributionService();
        ExtraFoodShop extraFoodShop = new ExtraFoodShop();
        HealthyShop healthyShop = new HealthyShop();
        GlutenFreeShop glutenFreeShop = new GlutenFreeShop();
        extraFoodShop.addProduct(product1);
        extraFoodShop.addProduct(product2);
        extraFoodShop.addProduct(product3);
        healthyShop.addProduct(product4);
        healthyShop.addProduct(product5);
        glutenFreeShop.addProduct(product6);
        distributionService.addNewOrder(purchaser1, product1);
        distributionService.addNewOrder(purchaser1, product2);
        distributionService.addNewOrder(purchaser1, product5);
        distributionService.addNewOrder(purchaser1, product6);
        distributionService.addNewOrder(purchaser2, product3);
        distributionService.addNewOrder(purchaser2, product6);
        //when
        glutenFreeShop.process(distributionService);
        //then
        Assert.assertEquals(4, distributionService.getActiveOrders().size());
    }

    @Test
    public void testHealthyShop() {
        //given
        Purchaser purchaser1 = new Purchaser("name 1", "street 1", "02-123", "Warszawa");
        Purchaser purchaser2 = new Purchaser("name 2", "street 2", "32-123", "Krakow");
        Product product1 = new Product("jablko", 3);
        Product product2 = new Product("gruszka", 1);
        Product product3 = new Product("ser", 2);
        Product product4 = new Product("szynka", 4);
        Product product5 = new Product("mięta", 5);
        Product product6 = new Product("kukurydza", 6);
        DistributionService distributionService = new DistributionService();
        ExtraFoodShop extraFoodShop = new ExtraFoodShop();
        HealthyShop healthyShop = new HealthyShop();
        GlutenFreeShop glutenFreeShop = new GlutenFreeShop();
        extraFoodShop.addProduct(product1);
        extraFoodShop.addProduct(product2);
        extraFoodShop.addProduct(product3);
        healthyShop.addProduct(product4);
        healthyShop.addProduct(product5);
        glutenFreeShop.addProduct(product6);
        distributionService.addNewOrder(purchaser1, product1);
        distributionService.addNewOrder(purchaser1, product2);
        distributionService.addNewOrder(purchaser1, product5);
        distributionService.addNewOrder(purchaser1, product6);
        distributionService.addNewOrder(purchaser2, product3);
        distributionService.addNewOrder(purchaser2, product6);
        //when
        healthyShop.process(distributionService);
        //then
        Assert.assertEquals(5, distributionService.getActiveOrders().size());
    }
}
