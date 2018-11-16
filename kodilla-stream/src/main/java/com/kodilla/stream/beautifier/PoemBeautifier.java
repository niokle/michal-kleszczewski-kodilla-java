package com.kodilla.stream.beautifier;

public class PoemBeautifier {
    public String beautify(String textToBeautify, PoemDecorator poemDecorator) {
        String resultString = poemDecorator.decorate(textToBeautify);
        return resultString;
    }
}
