package com.andreyuhai;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeastRecentlyUsed extends PageReplacementAlgorithm{

    private List<LocalDateTime> timeOfUse;

    LeastRecentlyUsed(int numOfFrames) {
        super(numOfFrames);
        timeOfUse = new ArrayList<>();
    }

    LeastRecentlyUsed(int numOfFrames, int numOfPages) {
        super(numOfFrames, numOfPages);
        timeOfUse = new ArrayList<>();

    }

    /*
     * Here we use another list as our auxiliary list
     * to decide which of the pages was used the least recently.
     *
     * First to populate our list we are adding elements as many
     * frames as the user mentioned and increasing the pageFault value
     * by 1 depending on whether the page was present in the memory.
     */
    @Override
    void getPage(Object pageNum) {
        if(memory.size() < numOfFrames) {
            if(!isInMemory(pageNum)) {
                pageFault++;
                memory.add(pageNum);
                timeOfUse.add(LocalDateTime.now());
            } else {
                timeOfUse.set(memory.indexOf(pageNum), LocalDateTime.now());
            }
        } else {
            if(isInMemory(pageNum)){
                timeOfUse.set(memory.indexOf(pageNum), LocalDateTime.now());
            } else {
                pageFault++;
                int lruIndex = timeOfUse.indexOf(Collections.min(timeOfUse));
                memory.set(lruIndex, pageNum);
                timeOfUse.set(lruIndex, LocalDateTime.now());
                //System.out.println("index : " + lruIndex);
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
