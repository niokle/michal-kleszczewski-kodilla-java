package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class ChangeCheeseToCheddarDecorator extends AbstractPizzaOrderDecorator {
    public ChangeCheeseToCheddarDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getPrice() {
        return super.getPrice().add(new BigDecimal(2));
    }

    @Override
    public String getIngredient() {
        return super.getIngredient() + ", change standard cheese to cheddar";
    }
}
