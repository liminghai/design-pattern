package com.example.demo.designpattern.strategy.demo2.verson3;

import java.util.HashMap;
import java.util.Map;

import com.example.demo.designpattern.strategy.demo2.verson2.ConcurrentExternalSort;
import com.example.demo.designpattern.strategy.demo2.verson2.ExternalSort;
import com.example.demo.designpattern.strategy.demo2.verson2.ISortAlg;
import com.example.demo.designpattern.strategy.demo2.verson2.MapReduceSort;
import com.example.demo.designpattern.strategy.demo2.verson2.QuickSort;

/**
 * @author limh
 * @version 2020年06月20日 08:41 limh Exp $
 */
public class SortAlgFactory {

    private static final Map<String, ISortAlg> algs = new HashMap<>();

    static {
        algs.put("QuickSort", new QuickSort());
        algs.put("ExternalSort", new ExternalSort());
        algs.put("ConcurrentExternalSort", new ConcurrentExternalSort());
        algs.put("MapReduceSort", new MapReduceSort());
    }

    public static ISortAlg getISortAlg(String type){
        if (type == null || type.isEmpty()){
            throw new IllegalArgumentException("type can not be null");
        }
        return algs.get(type);
    }
}
