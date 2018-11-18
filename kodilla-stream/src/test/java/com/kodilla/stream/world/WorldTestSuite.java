package com.kodilla.stream.world;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class WorldTestSuite {
    @Test
    public void testGetPeopleQuantity() {
        //Given
        Country poland = new Country("Polska", new BigDecimal("1001"));
        Country germany = new Country("Niemcy", new BigDecimal("2002"));
        Country china = new Country("Chiny", new BigDecimal("3003"));
        Country japan = new Country("Japonia", new BigDecimal("4004"));
        Country canada = new Country("Kanada", new BigDecimal("5005"));
        Country usa = new Country("USA", new BigDecimal("6006"));
        Country chile = new Country("Czile", new BigDecimal("7007"));
        Country mexico = new Country("Meksyk", new BigDecimal("8008"));
        Country zimbabwe = new Country("Zimbabue", new BigDecimal("9009"));
        Country tanzania = new Country("Tanzania", new BigDecimal("100010"));

        Continent europe = new Continent("Europa");
        Continent asia = new Continent("Azja");
        Continent northAmerica = new Continent("Ameryka Północna");
        Continent southAmerica = new Continent("Ameryka Południowa");
        Continent africa = new Continent("Afryka");

        europe.addCountry(poland);
        europe.addCountry(germany);
        asia.addCountry(china);
        asia.addCountry(japan);
        northAmerica.addCountry(canada);
        northAmerica.addCountry(usa);
        southAmerica.addCountry(chile);
        southAmerica.addCountry(mexico);
        africa.addCountry(zimbabwe);
        africa.addCountry(tanzania);

        World world = new World();
        world.addContinent(europe);
        world.addContinent(asia);
        world.addContinent(northAmerica);
        world.addContinent(southAmerica);
        world.addContinent(africa);

        //When
        BigDecimal result = world.getPeopleQuantity();

        //Then
        Assert.assertEquals(new BigDecimal("145055"), result);
    }
}
