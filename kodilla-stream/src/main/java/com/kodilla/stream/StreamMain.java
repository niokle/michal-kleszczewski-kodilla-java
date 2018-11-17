package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.iterate.NumbersGenerator;
import com.kodilla.stream.lambda.*;
import com.kodilla.stream.reference.FunctionalCalculator;

public class StreamMain {
    public static void main(String[] args) {
        ExpressionExecutor expressionExecutor = new ExpressionExecutor();

        System.out.println("Calculating expressions with lambdas");
        expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);

        System.out.println("Calculating expressions with method references");
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::multiplyAByB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::addAToB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::subBFromA);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::divideAByB);

        System.out.println("Poem Beautifier");
        PoemBeautifier poemBeautifier = new PoemBeautifier();
        System.out.println(poemBeautifier.beautify("to jest tekst do upiększenia ", (textToDecorate -> "ABC" + textToDecorate + "XYZ")));
        System.out.println(poemBeautifier.beautify("to jest tekst do upiększenia ", (textToDecorate -> textToDecorate.toUpperCase())));
        System.out.println(poemBeautifier.beautify("to jest tekst do upiększenia ", (textToDecorate -> textToDecorate.replaceAll("t","w"))));
        System.out.println(poemBeautifier.beautify("to jest tekst do upiększenia ", (textToDecorate -> textToDecorate.substring(textToDecorate.length()/2,textToDecorate.length()) + textToDecorate.substring(0,textToDecorate.length()/2))));

        System.out.println("Using Stream to generate even numbers from 1 to 20");
        NumbersGenerator.generateEven(20);
    }
}
