package com.kodilla.testing.collection;

import java.util.ArrayList;

public class OddNumbersExterminator {

    public ArrayList<Integer> exterminate(ArrayList<Integer> numbers) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if ( numbers != null) {
            for ( Integer integer : numbers) {
                if ( integer % 2 == 0 ) {
                    arrayList.add(integer);
                }
            }
        }
        return arrayList;
    }
}
