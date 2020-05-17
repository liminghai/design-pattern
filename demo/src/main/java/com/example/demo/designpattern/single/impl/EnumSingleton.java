package com.example.demo.designpattern.single.impl;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author limh
 * @version 2020年05月14日 20:04 limh Exp $
 */
public enum EnumSingleton {

    INSTANCE;

    private AtomicLong id = new AtomicLong(0);

    public long getId(){
        return id.incrementAndGet();
    }
}
