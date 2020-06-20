package com.example.demo.designpattern.strategy.demo2.verson3;

import java.io.File;

import com.example.demo.designpattern.strategy.demo2.verson2.ConcurrentExternalSort;
import com.example.demo.designpattern.strategy.demo2.verson2.ExternalSort;
import com.example.demo.designpattern.strategy.demo2.verson2.ISortAlg;
import com.example.demo.designpattern.strategy.demo2.verson2.MapReduceSort;
import com.example.demo.designpattern.strategy.demo2.verson2.QuickSort;

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
            //通过Factory获取策略
            sortAlg = SortAlgFactory.getISortAlg("QuickSort");
        } else if (fileSize < 10 * GB) {
            sortAlg = SortAlgFactory.getISortAlg("QuickSort");
        }else if (fileSize < 100 * GB) {
            // [10GB, 100GB)
            sortAlg = SortAlgFactory.getISortAlg("QuickSort");
        }else {
            // [100GB, ~)
            sortAlg = SortAlgFactory.getISortAlg("MapReduceSort");
        }
        sortAlg.sort(filePath);
    }
}
