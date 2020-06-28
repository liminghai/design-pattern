package com.example.demo.designpattern.iterator.demo1;

/**
 * @author limh
 * @version 2020年06月26日 11:32 limh Exp $
 */
public interface Iterator<E> {

    boolean hasNext();

    void next();

    E currentItem();
}
