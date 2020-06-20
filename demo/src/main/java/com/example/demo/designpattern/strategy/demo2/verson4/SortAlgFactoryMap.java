package com.example.demo.designpattern.strategy.demo2.verson4;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.designpattern.strategy.demo2.verson2.ISortAlg;
import com.example.demo.designpattern.strategy.demo2.verson3.SortAlgFactory;

/**
 * @author limh
 * @version 2020年06月20日 09:01 limh Exp $
 */
public class SortAlgFactoryMap {

    private static final long GB = 1000 * 1000 * 1000;
    private static final List<AlgRange> algs = new ArrayList<>();

    static {
        algs.add(new AlgRange(0, 6 * GB, SortAlgFactory.getISortAlg("QuickSort")));
        algs.add(new AlgRange(6 * GB, 10 * GB, SortAlgFactory.getISortAlg("ExternalSort")));
        algs.add(new AlgRange(10 * GB, 100 * GB, SortAlgFactory.getISortAlg("ConcurrentExternalSort")));
        algs.add(new AlgRange(100 * GB, Long.MAX_VALUE, SortAlgFactory.getISortAlg("MapReduceSort")));
    }

    public static ISortAlg getSortAlg(long size) {
        ISortAlg sortAlg = null;
        for (AlgRange algRange : algs) {
            if (algRange.inRange(size)) {
                sortAlg = algRange.getAlg();
                break;
            }
        }
        return sortAlg;
    }

}
