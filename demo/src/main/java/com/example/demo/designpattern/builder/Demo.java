package com.example.demo.designpattern.builder;

/**
 * @author limh
 * @version 2020年05月20日 16:45 limh Exp $
 */
public class Demo {

    public static void main(String[] args) {
        // 这段代码会抛出IllegalArgumentException，因为minIdle>maxIdle
        ResourcePoolConfig config = new ResourcePoolConfig.Builder()
            .setName("dbconnectionpool").setMaxTotal(16).setMaxIdle(10).setMinIdle(12)
            .build();
    }
}
