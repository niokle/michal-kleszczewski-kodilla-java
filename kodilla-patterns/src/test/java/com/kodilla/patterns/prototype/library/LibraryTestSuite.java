package com.kodilla.patterns.prototype.library;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class LibraryTestSuite {
    @Test
    public void testGetBooksShallowCopy() {
        //given
        Library library = new Library("Moja biblioteka");
        Book book1 = new Book("Tytuł 1", "Autor 1", LocalDate.of(2001, 01, 01));
        Book book2 = new Book("Tytuł 2", "Autor 2", LocalDate.of(2002, 02, 02));
        Book book3 = new Book("Tytuł 3", "Autor 3", LocalDate.of(2003, 03, 03));
        Book book4 = new Book("Tytuł 4", "Autor 4", LocalDate.of(2004, 04, 04));
        Book book5 = new Book("Tytuł 5", "Autor 5", LocalDate.of(2005, 05, 05));
        //when
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        library.addBook(book5);

        Library library1 = null;
        try {
            library1 = library.shallowCopy();
        } catch (CloneNotSupportedException exception) {
            System.out.println(exception);
        }
        //then
        Assert.assertEquals(5, library.getBooks().size());
        Assert.assertEquals(5, library1.getBooks().size());
    }

    @Test
    public void testGetBooksDeepCopy() {
        //given
        Library library = new Library("Moja biblioteka");
        Book book1 = new Book("Tytuł 1", "Autor 1", LocalDate.of(2001, 01, 01));
        Book book2 = new Book("Tytuł 2", "Autor 2", LocalDate.of(2002, 02, 02));
        Book book3 = new Book("Tytuł 3", "Autor 3", LocalDate.of(2003, 03, 03));
        Book book4 = new Book("Tytuł 4", "Autor 4", LocalDate.of(2004, 04, 04));
        Book book5 = new Book("Tytuł 5", "Autor 5", LocalDate.of(2005, 05, 05));
        //when
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        library.addBook(book5);

        Library library1 = null;
        try {
            library1 = library.deepCopy();
        } catch (CloneNotSupportedException exception) {
            System.out.println(exception);
        }
        //then
        Assert.assertEquals(5, library.getBooks().size());
        Assert.assertEquals(5, library1.getBooks().size());
    }
}
