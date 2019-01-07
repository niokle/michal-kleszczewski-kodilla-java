package com.kodilla.good.patterns.challenges;

public class Game implements Product {
    private int productId;
    private String productType;
    private String productName;
    private double productPrice;

    public Game(int productId, String productType, String productName, double productPrice) {
        this.productId = productId;
        this.productType = productType;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    @Override
    public int getProductId() {
        return productId;
    }

    @Override
    public String getProductType() {
        return productType;
    }

    @Override
    public String getProductName() {
        return productName;
    }

    @Override
    public double getProductPrice() {
        return productPrice;
    }
}
