package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class BasicPizzaOrder implements PizzaOrder {

    @Override
    public BigDecimal getPrice() {
        return new BigDecimal(10.5);
    }

    @Override
    public String getIngredient() {
        return "Pizza: cake, tomato sauce, cheese";
    }
}
