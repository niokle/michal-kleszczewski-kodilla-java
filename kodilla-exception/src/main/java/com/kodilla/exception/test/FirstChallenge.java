package com.kodilla.exception.test;

public class FirstChallenge {

    public double divide(double a, double b) throws ArithmeticException {
        if(b == 0){
            throw new ArithmeticException();
        }
        return a / b;
    }

    /**
     * This main can throw an ArithmeticException!!!
     * @param args
     */
    public static void main(String[] args) {

        FirstChallenge firstChallenge = new FirstChallenge();

        Double result = null;
        try {
            result = firstChallenge.divide(3, 0);
        } catch (ArithmeticException ex) {
            System.out.println("Wystąpił błąd: " + ex);
        } finally {
            System.out.println(result);
        }
    }
}
