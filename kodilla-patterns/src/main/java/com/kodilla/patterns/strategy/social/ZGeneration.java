package com.kodilla.patterns.strategy.social;

public class ZGeneration extends User {

    public ZGeneration(String userName) {
        super(userName);
        socialPublisher = new TwitterPublisher();
    }
}
