package com.example.demo.designpattern.single.impl;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 饿汉式
 * @author limh
 * @version 2020年05月14日 14:51 limh Exp $
 */
public class IdGenerator2 {
    private AtomicLong id = new AtomicLong(0);

    private static IdGenerator2 instance;

    private IdGenerator2(){}

    // 我们给getInstance()这个方法加了一把大锁(synchronzed)，导致这个函数 的并发度很低
    public static synchronized IdGenerator2 getInstance(){
        if (instance == null){
            instance = new IdGenerator2();
        }
        return instance;
    }

    public long getId(){
        return id.incrementAndGet();
    }
}
