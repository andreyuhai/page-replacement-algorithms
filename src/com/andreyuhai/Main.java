package com.andreyuhai;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {
	// write your code here
        List<Integer> pageReferenceString = new ArrayList<>();

        pageReferenceString.add(7);
        pageReferenceString.add(0);
        pageReferenceString.add(1);
        pageReferenceString.add(2);
        pageReferenceString.add(0);
        pageReferenceString.add(3);
        pageReferenceString.add(0);
        pageReferenceString.add(4);
        pageReferenceString.add(2);
        pageReferenceString.add(3);
        pageReferenceString.add(0);
        pageReferenceString.add(3);
        pageReferenceString.add(2);
        pageReferenceString.add(1);
        pageReferenceString.add(2);
        pageReferenceString.add(0);
        pageReferenceString.add(1);
        pageReferenceString.add(7);


        FirstInFirstOut fifo = new FirstInFirstOut(3);
        fifo.setPageReferenceString(pageReferenceString);

        LeastRecentlyUsed lru = new LeastRecentlyUsed(3);
        lru.setPageReferenceString(pageReferenceString);

        Optimal optimal = new Optimal(3);
        optimal.setPageReferenceString(pageReferenceString);

        OperatingSystem os = new OperatingSystem();
        os.setPageReplacementAlgorithm(fifo);
        System.out.println(os.solve());

        os.setPageReplacementAlgorithm(lru);
        System.out.println(os.solve());

        os.setPageReplacementAlgorithm(optimal);
        System.out.println(os.solve());
    }
}
