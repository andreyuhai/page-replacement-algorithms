package com.andreyuhai;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Optimal extends PageReplacementAlgorithm{

    private List<Integer> lastIndexList;
    private int currentIndex;

    Optimal(int numOfFrames, int numOfPages) {
        super(numOfFrames, numOfPages);
    }

    Optimal(int numOfFrames) {
        super(numOfFrames);
        lastIndexList = new ArrayList<>();
    }

    @Override
    void getPage(Object pageNum) {
        if(memory.size() < numOfFrames) {
            if(!isInMemory(pageNum)) {
                pageFault++;
                memory.add(pageNum);
                lastIndexList.add(pageReferenceString.lastIndexOf(pageNum) <= currentIndex ? -1 : pageReferenceString.lastIndexOf(pageNum));
            } else {
                lastIndexList.set(memory.indexOf(pageNum), pageReferenceString.lastIndexOf(pageNum) <= currentIndex ? -1 : pageReferenceString.lastIndexOf(pageNum));
            }
        } else {
            if(!isInMemory(pageNum)) {
                //System.out.println(pageNum);
                pageFault++;
                int indexToSet = (lastIndexList.indexOf(-1) == -1) ? lastIndexList.indexOf(Collections.max(lastIndexList)) : lastIndexList.indexOf(-1);
                //System.out.println("Index to set: " + indexToSet);
                memory.set(indexToSet, pageNum);
                lastIndexList.set(indexToSet, pageReferenceString.subList(currentIndex + 1, pageReferenceString.size()).lastIndexOf(pageNum));
            } else {
                lastIndexList.set(memory.indexOf(pageNum), pageReferenceString.lastIndexOf(pageNum) <= currentIndex ? -1 : pageReferenceString.lastIndexOf(pageNum));
            }
        }
    }

    @Override
    boolean isInMemory(Object o) {
        return memory.contains(o);
    }

    @Override
    int solve() {
        pageReferenceString.forEach(pageNum -> {
            getPage(pageNum);
            currentIndex++;
        });
        return pageFault;
    }
}
