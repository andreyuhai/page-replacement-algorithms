package com.andreyuhai;

class OperatingSystem {

    private PageReplacementAlgorithm pageReplacementAlgorithm;

    OperatingSystem() {

    }

    void setPageReplacementAlgorithm(PageReplacementAlgorithm pageReplacementAlgorithm) {
        this.pageReplacementAlgorithm = pageReplacementAlgorithm;
    }

    int solve(){
        return pageReplacementAlgorithm.solve();
    }
}
