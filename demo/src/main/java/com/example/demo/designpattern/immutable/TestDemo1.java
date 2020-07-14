package com.example.demo.designpattern.immutable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.common.collect.ImmutableList;

/**
 * @author limh
 * @version 2020年06月30日 10:23 limh Exp $
 */
public class TestDemo1 {

    public static void main(String[] args){

        /**
         * Guava
         */
        List<String> list=new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println("list："+list);

        ImmutableList<String> immutableListGuava = ImmutableList.copyOf(list);

        //往list增加元素
        list.add("d");
        //输出结果 immutableListGuava：[a, b, c]
        System.out.println("immutableListGuava："+immutableListGuava);

        /**
         * JDK list
         */
        List<String> immutableListJdk = Collections.unmodifiableList(list);
        list.add("e");
        //输出结果 immutableListJdk：[a, b, c, d, e]
        System.out.println("immutableListJdk："+immutableListJdk);
    }
}
