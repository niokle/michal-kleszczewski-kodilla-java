package com.kodilla.exception.test;

public class ExceptionHandling {
    public static void main(String[] args) {
        SecondChallenge secondChallenge = new SecondChallenge();

        try {
            String string = secondChallenge.probablyIWillThrowException(3,5);
        } catch (Exception ex) {
            System.out.println("Wystąpił wyjątek: " + ex);
        } finally {
            System.out.println("Proces zakończony.");
        }
    }
}
