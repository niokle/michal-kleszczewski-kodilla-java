package com.kodilla.stream.array;

import org.junit.Assert;
import org.junit.Test;

public class ArrayOperationsTestSuite {
    @Test
    public void testGetAverage() {
        //Given
        int numbers[] = {0,1,2,3,4,5,6};

        //When
        double result = ArrayOperations.getAverage(numbers);

        //Then
        Assert.assertEquals(3, result,0);
    }
}
