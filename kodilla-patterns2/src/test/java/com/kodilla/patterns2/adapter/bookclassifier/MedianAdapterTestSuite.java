package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclasifier.MedianAdapter;
import com.kodilla.patterns2.adapter.bookclasifier.librarya.Book;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class MedianAdapterTestSuite {
    @Test
    public void PublicationYearMedianTest() {
        //given
        Set<Book> books = new HashSet<>();
        books.add(new Book("author 1", "title 1", 1100, "sign 1"));
        books.add(new Book("author 2", "title 2", 1200, "sign 2"));
        books.add(new Book("author 3", "title 3", 1300, "sign 3"));
        books.add(new Book("author 4", "title 4", 1400, "sign 4"));
        books.add(new Book("author 5", "title 5", 1500, "sign 5"));
        books.add(new Book("author 6", "title 6", 1600, "sign 6"));
        books.add(new Book("author 7", "title 7", 1700, "sign 7"));
        books.add(new Book("author 8", "title 8", 1800, "sign 8"));
        books.add(new Book("author 9", "title 9", 1900, "sign 9"));
        MedianAdapter medianAdapter = new MedianAdapter();

        //when
        int mediana = medianAdapter.publicationYearMedian(books);

        //then
        Assert.assertEquals(1500, mediana);
    }
}
