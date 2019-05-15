package com.andreyuhai;

import java.util.ArrayList;
import java.util.List;

public class ApproximatedLRU extends PageReplacementAlgorithm{

    private List<Integer> referenceBits;
    private int indexToReplace;

    ApproximatedLRU(int numOfFrames, int numOfPages) {
        super(numOfFrames, numOfPages);
        referenceBits = new ArrayList<>();
    }

    ApproximatedLRU(int numOfFrames) {
        super(numOfFrames);
        referenceBits = new ArrayList<>();
    }

    @Override
    void getPage(Object pageNum) {
        if(memory.size() < numOfFrames) {
            if(!isInMemory(pageNum)) {
                pageFault++;
                memory.add(pageNum);
                referenceBits.add(0);
            } else {
                referenceBits.set(memory.indexOf(pageNum), 1);
            }
        } else {
            if(isInMemory(pageNum)){
                referenceBits.set(memory.indexOf(pageNum), 1);
            } else {
                pageFault++;
                while(referenceBits.get(indexToReplace) == 1) {
                    referenceBits.set(indexToReplace, 0);
                    indexToReplace = ++indexToReplace % numOfFrames;
                }
                memory.set(indexToReplace, pageNum);
                //System.out.println("index : " + indexToReplace);
                indexToReplace = ++indexToReplace % numOfFrames;
            }
        }
    }

    @Override
    boolean isInMemory(Object o) {
        return memory.contains(o);
    }

    @Override
    int solve() {
        pageReferenceString.forEach(this::getPage);
        return pageFault;
    }
}
