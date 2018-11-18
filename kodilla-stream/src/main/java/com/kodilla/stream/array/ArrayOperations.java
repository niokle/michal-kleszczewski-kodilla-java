package com.kodilla.stream.array;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.stream.IntStream;

public interface ArrayOperations {
    static double getAverage(int[] numbers) {

        IntStream.range(0,numbers.length)
                .forEach(System.out::println);

        OptionalDouble average = IntStream.range(0, numbers.length)
                .average();

        return average.getAsDouble();
    }
}
