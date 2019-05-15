package com.andreyuhai;

public class Random extends PageReplacementAlgorithm {

    Random(int numOfFrames, int numOfPages) {
        super(numOfFrames, numOfPages);
    }

    Random(int numOfFrames) {
        super(numOfFrames);
    }

    @Override
    void getPage(Object pageNum) {
        if(memory.size() < numOfFrames) {
            if(!isInMemory(pageNum)) {
                pageFault++;
                memory.add(pageNum);
            }
        } else {
            if(isInMemory(pageNum)){
                return;
            } else {
                pageFault++;
                int indexToReplace = (int) (Math.random() * numOfFrames);
                memory.set(indexToReplace, pageNum);
                //System.out.println("index : " + indexToReplace);
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
