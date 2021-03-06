package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class AvocadoDecorator extends AbstractPizzaOrderDecorator {
    public AvocadoDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getPrice() {
        return super.getPrice().add(new BigDecimal(5));
    }

    @Override
    public String getIngredient() {
        return super.getIngredient() + ", avocado";
    }
}
