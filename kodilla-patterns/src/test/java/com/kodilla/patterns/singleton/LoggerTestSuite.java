package com.kodilla.patterns.singleton;

import org.junit.Assert;
import org.junit.Test;

public class LoggerTestSuite {
    @Test
    public void testGetLastLog() {
        //given
        Logger logger = Logger.getInstance();
        //when
        logger.log("Test 1");
        logger.log("Test 2");
        logger.log("Test 3");
        String lastLog = logger.getLastLog();
        //then
        Assert.assertEquals("Test 3", lastLog);
    }
}
