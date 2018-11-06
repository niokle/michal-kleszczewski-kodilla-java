package com.kodilla.testing;

import com.kodilla.testing.user.SimpleUser;
import com.kodilla.testing.calculator.Calculator;

public class TestingMain {
    public static void main(String[] args){
        SimpleUser simpleUser = new SimpleUser("theForumUser");

        String result = simpleUser.getUsername();

        if (result.equals("theForumUser")){
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }

        Calculator calculator = new Calculator();

        if ( calculator.add(5,7) == 5 + 7 ) {
            System.out.println("test dodawania prawidłowy");
        } else {
            System.out.println("blad testu dodawania");
        }
        if ( calculator.subtract(11,6) == 11 - 6 ) {
            System.out.println("test odejnowania prawidłowy");
        } else {
            System.out.println("blad testu odejmowania");
        }
    }
}
