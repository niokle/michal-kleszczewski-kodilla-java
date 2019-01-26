package com.kodilla.patterns.builder.bigmac;

import java.util.ArrayList;
import java.util.List;

public class Bigmac {
    private Buns bun;
    private int burgers;
    private List<Sauces> sauces = new ArrayList<>();
    private List<Ingredients> ingredients = new ArrayList<>();

    enum Buns {
        JASNA, CIEMNA
    }

    enum Sauces {
        STANDARD, _1000WYSP, BARBECUE
    }

    enum Ingredients {
        SAŁATA, CEBULA, BEKON, OGÓREK, PAPRYCZKI_CHILLI, PIECZARKI, KREWETKI, SER
    }

    private Bigmac(Buns bun, int burgers, List<Sauces> sauces, List<Ingredients> ingredients) {
        this.bun = bun;
        this.burgers = burgers;
        this.sauces = sauces;
        this.ingredients = ingredients;
    }

    public static class BigmacBuilder {
        private Buns buns;
        private int burgers;
        private List<Sauces> sauces = new ArrayList<>();
        private List<Ingredients> ingredients = new ArrayList<>();

        public BigmacBuilder setBuns(Buns buns) {
            this.buns = buns;
            return this;
        }

        public BigmacBuilder setBurgers(int burgers) {
            this.burgers = burgers;
            return this;
        }

        public BigmacBuilder setSauces(Sauces sauces) {
            this.sauces.add(sauces);
            return this;
        }

        public BigmacBuilder setIngredients(Ingredients ingredient) {
            this.ingredients.add(ingredient);
            return this;
        }

        public Bigmac buildBigmac() {
            return new Bigmac(buns, burgers, sauces, ingredients);
        }
    }

    public Buns getBun() {
        return bun;
    }

    public int getBurgers() {
        return burgers;
    }

    public List<Sauces> getSauces() {
        return sauces;
    }

    public List<Ingredients> getIngredients() {
        return ingredients;
    }
}
