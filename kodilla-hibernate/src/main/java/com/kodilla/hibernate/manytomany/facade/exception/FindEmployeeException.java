package com.kodilla.hibernate.manytomany.facade.exception;

public class FindEmployeeException extends Exception {
    public static String ERROR = "Błąd przy wyszukiwaniu pracownika.";

    public FindEmployeeException(String message) {
        super(message);
    }
}
