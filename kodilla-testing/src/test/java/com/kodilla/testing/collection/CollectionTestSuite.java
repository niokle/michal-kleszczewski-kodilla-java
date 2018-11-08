package com.kodilla.testing.collection;

import com.kodilla.testing.collection.CollectionTestSuite;
import org.junit.*;
import java.util.ArrayList;
import java.util.Arrays;

public class CollectionTestSuite {
    @Before
    public void before() {
        System.out.println("Start Case.");
    }

    @After
    public void after() {
        System.out.println("End Case.");
    }

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Start Suite");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("End Suite");
    }

    @Test
    public void testOddNumbersExterminatorEmptyList() {
        ArrayList<Integer> inputList = new ArrayList<>();
        inputList = null;
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        ArrayList<Integer> result = oddNumbersExterminator.exterminate(inputList);
        Assert.assertEquals(0, result.size());
    }

    @Test
    public void testOddNumbersExterminatorNormalList() {
        ArrayList<Integer> inputList = new ArrayList<>();
        ArrayList<Integer> expectedOutputList = new ArrayList<>();
        inputList.addAll(Arrays.asList(1, 2, 4, 7, 8, 11, 23, 54, 61, 31, 24));
        expectedOutputList.addAll(Arrays.asList(2, 4, 8, 54, 24));
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        ArrayList<Integer> result = oddNumbersExterminator.exterminate(inputList);
        Assert.assertArrayEquals(expectedOutputList.toArray(),result.toArray());
    }
}
