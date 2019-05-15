package com.andreyuhai;

import java.util.ArrayList;
import java.util.List;

public abstract class PageReplacementAlgorithm {

    int numOfFrames;
    int pageFault;
    List<Integer> pageReferenceString;
    List<Object> memory;

    PageReplacementAlgorithm(int numOfFrames, int numOfPages) {
        this.numOfFrames = numOfFrames;
        this.memory = new ArrayList<>();
    }

    PageReplacementAlgorithm(int numOfFrames) {
        this.numOfFrames = numOfFrames;
        this.memory = new ArrayList<>();
    }

    abstract void getPage(Object o);

    abstract  boolean isInMemory(Object o);

    abstract int solve();

    public void setPageReferenceString(List<Integer> pageReferenceString) {
        this.pageReferenceString = pageReferenceString;
    }
}
