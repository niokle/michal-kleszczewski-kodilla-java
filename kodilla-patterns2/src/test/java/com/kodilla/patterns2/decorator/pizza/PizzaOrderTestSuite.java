package com.kodilla.patterns2.decorator.pizza;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class PizzaOrderTestSuite {
    @Test
    public void testPizzaAvocadoHamOnionGetPrice() {
        //given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new AvocadoDecorator(pizzaOrder);
        pizzaOrder = new HamDecorator(pizzaOrder);
        pizzaOrder = new OnionDecorator(pizzaOrder);

        //when
        BigDecimal price = pizzaOrder.getPrice();

        //then
        Assert.assertEquals(new BigDecimal(19.0).setScale(2), price.setScale(2));
    }

    @Test
    public void testPizzaAvocadoHamOnionGetIngredients() {
        //given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new AvocadoDecorator(pizzaOrder);
        pizzaOrder = new HamDecorator(pizzaOrder);
        pizzaOrder = new OnionDecorator(pizzaOrder);

        //when
        String ingredients = pizzaOrder.getIngredient();

        //then
        Assert.assertEquals("Pizza: cake, tomato sauce, cheese, avocado, ham, onion", ingredients);
    }

    @Test
    public void testPizzaFullGetPrice() {
        //given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new AvocadoDecorator(pizzaOrder);
        pizzaOrder = new ChangeCheeseToCheddarDecorator(pizzaOrder);
        pizzaOrder = new GarlicDecorator(pizzaOrder);
        pizzaOrder = new HamDecorator(pizzaOrder);
        pizzaOrder = new OnionDecorator(pizzaOrder);
        pizzaOrder = new PineappleDecorator(pizzaOrder);
        pizzaOrder = new RucolaDecorator(pizzaOrder);
        pizzaOrder = new SalamiDecorator(pizzaOrder);
        pizzaOrder = new TomatoesDecorator(pizzaOrder);

        //when
        BigDecimal price = pizzaOrder.getPrice();

        //then
        Assert.assertEquals(new BigDecimal(30.6).setScale(2, 2), price.setScale(2, 2));
    }

    @Test
    public void testPizzaFullGetIngredients() {
        //given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new AvocadoDecorator(pizzaOrder);
        pizzaOrder = new ChangeCheeseToCheddarDecorator(pizzaOrder);
        pizzaOrder = new GarlicDecorator(pizzaOrder);
        pizzaOrder = new HamDecorator(pizzaOrder);
        pizzaOrder = new OnionDecorator(pizzaOrder);
        pizzaOrder = new PineappleDecorator(pizzaOrder);
        pizzaOrder = new RucolaDecorator(pizzaOrder);
        pizzaOrder = new SalamiDecorator(pizzaOrder);
        pizzaOrder = new TomatoesDecorator(pizzaOrder);

        //when
        String ingredients = pizzaOrder.getIngredient();

        //then
        Assert.assertEquals("Pizza: cake, tomato sauce, cheese, avocado, change standard cheese to cheddar, garlic, ham, onion, pineapple, rucola, salami, tomatoes", ingredients);
    }

    @Test
    public void testPizzaDoubleSalamiDoubleOnionTriplePineappleGetPrice() {
        //given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new SalamiDecorator(pizzaOrder);
        pizzaOrder = new SalamiDecorator(pizzaOrder);
        pizzaOrder = new OnionDecorator(pizzaOrder);
        pizzaOrder = new OnionDecorator(pizzaOrder);
        pizzaOrder = new PineappleDecorator(pizzaOrder);
        pizzaOrder = new PineappleDecorator(pizzaOrder);
        pizzaOrder = new PineappleDecorator(pizzaOrder);

        //when
        BigDecimal price = pizzaOrder.getPrice();

        //then
        Assert.assertEquals(new BigDecimal(29).setScale(2), price.setScale(2));
    }

    @Test
    public void testPizzaDoubleSalamiDoubleOnionTriplePineappleGetIngredients() {
        //given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new SalamiDecorator(pizzaOrder);
        pizzaOrder = new SalamiDecorator(pizzaOrder);
        pizzaOrder = new OnionDecorator(pizzaOrder);
        pizzaOrder = new OnionDecorator(pizzaOrder);
        pizzaOrder = new PineappleDecorator(pizzaOrder);
        pizzaOrder = new PineappleDecorator(pizzaOrder);
        pizzaOrder = new PineappleDecorator(pizzaOrder);

        //when
        String ingredients = pizzaOrder.getIngredient();

        //then
        Assert.assertEquals("Pizza: cake, tomato sauce, cheese, salami, salami, onion, onion, pineapple, pineapple, pineapple", ingredients);
    }
}
