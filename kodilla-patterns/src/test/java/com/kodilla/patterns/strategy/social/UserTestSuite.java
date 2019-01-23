package com.kodilla.patterns.strategy.social;

import org.junit.Assert;
import org.junit.Test;

public class UserTestSuite {
    @Test
    public void testDefaultSharingStrategies() {
        //given
        Millenials millenials = new Millenials("user 1");
        YGeneration yGeneration = new YGeneration("user 2");
        ZGeneration zGeneration = new ZGeneration("user 3");
        //when
        String millenialsPortal = millenials.getSocialPublisher().share();
        String yGenerationPortal = yGeneration.getSocialPublisher().share();
        String zGenerationPortal = zGeneration.getSocialPublisher().share();
        //then
        Assert.assertEquals("Facebook", millenialsPortal);
        Assert.assertEquals("Snapchat", yGenerationPortal);
        Assert.assertEquals("Twitter", zGenerationPortal);
    }

    @Test
    public void testIndividualSharingStrategy() {
        //given
        Millenials millenials = new Millenials("user 1");
        //when
        millenials.setSocialPublisher(new TwitterPublisher());
        String millenialsPortal = millenials.getSocialPublisher().share();
        //then
        Assert.assertEquals("Twitter", millenialsPortal);
    }
}
