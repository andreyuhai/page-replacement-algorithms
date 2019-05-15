package com.andreyuhai;

import java.util.List;

public class ApproximatedLRU extends PageReplacementAlgorithm{

    ApproximatedLRU(int numOfFrames, int numOfPages) {
        super(numOfFrames, numOfPages);
    }

    ApproximatedLRU(int numOfFrames) {
        super(numOfFrames);
    }

    @Override
    void getPage(Object o) {

    }

    @Override
    boolean isInMemory(Object o) {
        return false;
    }

    @Override
    int solve() {
        return 0;
    }
}
