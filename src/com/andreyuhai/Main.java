package com.andreyuhai;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        List<Integer> pageReferenceString = new ArrayList<>();
        int numOfFrames;
        int numOfPages;

        while(true) {

            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the number of frames: ");
            numOfFrames= sc.nextInt();
            System.out.print("Enter the number of pages: ");
            numOfPages = sc.nextInt();

            for(int i = 0; i < numOfPages; i++) {
                pageReferenceString.add((int) (Math.random() * numOfPages));
            }

            System.out.println("Size: " + pageReferenceString.size());

            for (Integer integer : pageReferenceString) {
                System.out.println(integer);
            }



            PageReplacementAlgorithm fifo = new FirstInFirstOut(numOfFrames);
            fifo.setPageReferenceString(pageReferenceString);

            PageReplacementAlgorithm lru = new LeastRecentlyUsed(numOfFrames);
            lru.setPageReferenceString(pageReferenceString);

            PageReplacementAlgorithm optimal = new Optimal(numOfFrames);
            optimal.setPageReferenceString(pageReferenceString);

            PageReplacementAlgorithm alru = new ApproximatedLRU(numOfFrames);
            alru.setPageReferenceString(pageReferenceString);

            PageReplacementAlgorithm random = new Random(numOfFrames);
            random.setPageReferenceString(pageReferenceString);


            //

            OperatingSystem os = new OperatingSystem();
            os.setPageReplacementAlgorithm(fifo);
            System.out.println("[FIFO]\tPage fault: " + os.solve());

            os.setPageReplacementAlgorithm(lru);
            System.out.println("[LRU]\tPage fault: " + os.solve());

            os.setPageReplacementAlgorithm(optimal);
            System.out.println("[OPT]\tPage fault: " + os.solve());

            os.setPageReplacementAlgorithm(alru);
            System.out.println("[ALRU]\tPage fault: " + os.solve());

            os.setPageReplacementAlgorithm(random);
            System.out.println("[RAND]\tPage fault: " + os.solve());

            int answer;
            System.out.println("0. Exit");
            System.out.println("1. Try again");
            System.out.print("What do you want to do? ");
            answer = sc.nextInt();
            if(answer == 0)
                break;
        }




    }
}

//    List<Integer> pageReferenceString = new ArrayList<>();
//    List<Integer> pageReferenceString2 = new ArrayList<>();
//
//        pageReferenceString.add(7);
//                pageReferenceString.add(0);
//                pageReferenceString.add(1);
//                pageReferenceString.add(2);
//                pageReferenceString.add(0);
//                pageReferenceString.add(3);
//                pageReferenceString.add(0);
//                pageReferenceString.add(4);
//                pageReferenceString.add(2);
//                pageReferenceString.add(3);
//                pageReferenceString.add(0);
//                pageReferenceString.add(3);
//                pageReferenceString.add(2);
//                pageReferenceString.add(1);
//                pageReferenceString.add(2);
//                pageReferenceString.add(0);
//                pageReferenceString.add(1);
//                pageReferenceString.add(7);
//
//                //
//
//                pageReferenceString2.add(0);
//                pageReferenceString2.add(4);
//                pageReferenceString2.add(1);
//                pageReferenceString2.add(4);
//                pageReferenceString2.add(2);
//                pageReferenceString2.add(4);
//                pageReferenceString2.add(3);
//                pageReferenceString2.add(4);
//                pageReferenceString2.add(2);
//                pageReferenceString2.add(4);
//                pageReferenceString2.add(0);
//                pageReferenceString2.add(4);
//                pageReferenceString2.add(1);
//                pageReferenceString2.add(4);
//                pageReferenceString2.add(2);
//                pageReferenceString2.add(4);
//                pageReferenceString2.add(3);
//                pageReferenceString2.add(4);