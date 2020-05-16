package com.example.demo.designPattern.singleton.impl;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 饿汉式
 * @author limh
 * @version 2020年05月14日 14:51 limh Exp $
 */
public class IdGenerator3 {
    private AtomicLong id = new AtomicLong(0);

    /**
     * 给instance成员变量加上volatile关键字，禁止指令重排序，确保instance在初始化完成后才能被读到
     * 利用volatile的先行发生原则的其中一条：对一个volatile变量的写操作先行发生于后面对这个变量的读操作
     *
     */
    private static volatile IdGenerator3 instance;

    private IdGenerator3(){}

    public static IdGenerator3 getInstance(){
        if (instance == null){
            synchronized (IdGenerator3.class){ // 此处为类级别的锁
                if (instance == null){
                    instance = new IdGenerator3();
                }
            }
        }
        return instance;
    }

    public long getId(){
        return id.incrementAndGet();
    }
}
