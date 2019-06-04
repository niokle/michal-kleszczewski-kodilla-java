package com.kodilla.hibernate.manytomany.facade.exception;

public class FindCompanyException extends Exception {
    public static String ERROR = "Błąd przy wyszukiwaniu firmy.";

    public FindCompanyException(String message) {
        super(message);
    }
}
