package com.andreyuhai;

public class FirstInFirstOut extends PageReplacementAlgorithm{

    private int indexToReplace;

    public FirstInFirstOut(int numOfFrames) {
        super(numOfFrames);
    }

    public FirstInFirstOut(int numOfFrames, int numOfPages) {
        super(numOfFrames, numOfPages);
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
                memory.set(indexToReplace, pageNum);
                //System.out.println("index : " + indexToReplace);
                indexToReplace = ++indexToReplace % numOfFrames;
            }
        }
    }

    @Override
    boolean isInMemory(Object o)  {
        return memory.contains(o);
    }

    @Override
    int solve() {
        pageReferenceString.forEach(this::getPage);
        return pageFault;
    }
}
