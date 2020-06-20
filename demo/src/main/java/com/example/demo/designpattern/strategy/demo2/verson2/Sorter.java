package com.example.demo.designpattern.strategy.demo2.verson2;

import java.io.File;

/**
 * @author limh
 * @version 2020年06月19日 20:31 limh Exp $
 */
public class Sorter {

    private static final long GB = 1000 * 1000 * 1000;

    public void sortFile(String filePath) {
        File file = new File(filePath);
        long fileSize = file.length();

        ISortAlg sortAlg;
        if (fileSize < 6 * GB) {
            sortAlg = new QuickSort();
        } else if (fileSize < 10 * GB) {
            sortAlg = new ExternalSort();
        }else if (fileSize < 100 * GB) {
            // [10GB, 100GB)
            sortAlg = new ConcurrentExternalSort();
        }else {
            // [100GB, ~)
            sortAlg = new MapReduceSort();
        }
        sortAlg.sort(filePath);
    }
}
