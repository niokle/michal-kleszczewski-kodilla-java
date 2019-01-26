package com.kodilla.patterns.builder.bigmac;

import org.junit.Assert;
import org.junit.Test;

public class BigmacTestSuite {
    @Test
    public void testBigmacBuilder() {
        //given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .setBuns(Bigmac.Buns.JASNA)
                .setBurgers(2)
                .setSauces(Bigmac.Sauces.BARBECUE)
                .setIngredients(Bigmac.Ingredients.BEKON)
                .setIngredients(Bigmac.Ingredients.PIECZARKI)
                .setIngredients(Bigmac.Ingredients.CEBULA)
                .setIngredients(Bigmac.Ingredients.PAPRYCZKI_CHILLI)
                .setSauces(Bigmac.Sauces._1000WYSP)
                .buildBigmac();
        //when
        int numberOfSauce = bigmac.getSauces().size();
        int numberOfIngredients = bigmac.getIngredients().size();
        //then
        Assert.assertEquals(2, numberOfSauce);
        Assert.assertEquals(4, numberOfIngredients);
    }
}