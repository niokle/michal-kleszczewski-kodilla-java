package com.kodilla.patterns.prototype.library;

public class Prototype<Type> implements Cloneable {

    @Override
    public Type clone() throws CloneNotSupportedException {
        return (Type) super.clone();
    }
}
