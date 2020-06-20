package com.example.demo.designpattern.strategy.demo2.verson1;

import java.io.File;

/**
 * @author limh
 * @version 2020年06月19日 15:25 limh Exp $
 */
public class Sorter {

    private static final long GB = 1000 * 1000 * 1000;

    public void sortFile(String filePath) {
        File file = new File(filePath);
        long fileSize = file.length();

        if (fileSize < 6 * GB) {
            quickSort(filePath);
        } else if (fileSize < 10 * GB) {
            externalSort(filePath);
        }else if (fileSize < 100 * GB) {
            // [10GB, 100GB)
            concurrentExternalSort(filePath);
        }else {
            // [100GB, ~)
            mapreduceSort(filePath);
        }
    }

    private void quickSort(String filePath) {
        // 快速排序
    }

    private void externalSort(String filePath) {
        // 外部排序
    }

    private void concurrentExternalSort(String filePath) {
        // 多线程外部排序
    }

    private void mapreduceSort(String filePath) {
        // 利用MapReduce多机排序
    }
}
