package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class TomatoesDecorator extends AbstractPizzaOrderDecorator {
    public TomatoesDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getPrice() {
        return super.getPrice().add(new BigDecimal(2));
    }

    @Override
    public String getIngredient() {
        return super.getIngredient() + ", tomatoes";
    }
}
