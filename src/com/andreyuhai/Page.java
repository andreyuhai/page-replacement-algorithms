package com.andreyuhai;

import java.util.ArrayList;
import java.util.List;

public class Page {
    int number;
    int timesUsed;

    Page(int number){
        this.number = number;
    }

    public static List<Page> createRandomReferenceString(int numOfPages) {

        List<Page> pageReferenceString = new ArrayList<>();

        for(int i = 0; i < numOfPages; i++) {
            pageReferenceString.add(new Page((int) (Math.random() * numOfPages)));
        }

        return pageReferenceString;
    }
}
