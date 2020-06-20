package com.example.demo.designpattern.strategy.demo2.verson4;

import java.io.File;

import com.example.demo.designpattern.strategy.demo2.verson2.ISortAlg;
import com.example.demo.designpattern.strategy.demo2.verson3.SortAlgFactory;

/**
 * @author limh
 * @version 2020年06月19日 20:31 limh Exp $
 */
public class Sorter {

    private static final long GB = 1000 * 1000 * 1000;

    public void sortFile(String filePath) {
        File file = new File(filePath);
        long fileSize = file.length();

        // if-else的选择已移走
        ISortAlg sortAlg = SortAlgFactoryMap.getSortAlg(fileSize);
        sortAlg.sort(filePath);
    }
}
