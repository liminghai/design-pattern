package com.example.demo.designpattern.single.impl;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 饿汉式
 * @author limh
 * @version 2020年05月14日 14:51 limh Exp $
 */
public class IdGenerator4 {
    private AtomicLong id = new AtomicLong(0);

    private IdGenerator4(){}

    public static IdGenerator4 getInstance(){
        return SingletonHolder.instance;
    }

    private static class SingletonHolder{
        private static final IdGenerator4
            instance = new IdGenerator4();
    }

    public long getId(){
        return id.incrementAndGet();
    }
}
