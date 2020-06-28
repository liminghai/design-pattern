package com.example.demo.designpattern.iterator.demo1;

import java.util.ArrayList;

/**
 * @author limh
 * @version 2020年06月26日 11:49 limh Exp $
 */
public class Demo {

    public static void main(String[] args) {

        ArrayList<String> names = new ArrayList<>();
        names.add("test1");
        names.add("test2");
        names.add("test3");

        Iterator<String> iterator = new ArrayIterator<>(names);
        while (iterator.hasNext()) {
            System.out.println(iterator.currentItem());
            iterator.next();
        }
    }
}
