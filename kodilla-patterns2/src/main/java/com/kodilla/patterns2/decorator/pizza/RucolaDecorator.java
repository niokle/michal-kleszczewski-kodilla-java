package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class RucolaDecorator extends AbstractPizzaOrderDecorator {
    public RucolaDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getPrice() {
        return super.getPrice().add(new BigDecimal(1));
    }

    @Override
    public String getIngredient() {
        return super.getIngredient() + ", rucola";
    }
}
