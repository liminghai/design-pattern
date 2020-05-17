package com.example.demo.designpattern.single.impl;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 饿汉式
 * @author limh
 * @version 2020年05月14日 14:51 limh Exp $
 */
public class IdGenerator1 {
    private AtomicLong id = new AtomicLong(0);

    private static final IdGenerator1
        instance = new IdGenerator1();

    private IdGenerator1(){}

    public static IdGenerator1 getInstance(){
        return instance;
    }

    public long getId(){
        return id.incrementAndGet();
    }
}
