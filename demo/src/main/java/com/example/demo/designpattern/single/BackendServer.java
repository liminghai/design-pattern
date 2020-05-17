package com.example.demo.designpattern.single;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author limh
 * @version 2020年05月15日 21:49 limh Exp $
 */
public class BackendServer {

    private long serverNo;
    private String serverAddress;
    private static final int SERVER_COUNT = 3;

    private static final Map<Long, BackendServer> serverInstances = new HashMap<>();

    /**
     * 静态代码块，类初始化时即创建并设置完成
     */
    static {
        serverInstances.put(1L, new BackendServer(1L, "192.134.22.138:8080"));
        serverInstances.put(2L, new BackendServer(2L, "192.134.22.139:8080"));
        serverInstances.put(3L, new BackendServer(3L, "192.134.22.140:8080"));
    }

    private BackendServer(long serverNo, String serverAddress) {
        this.serverNo = serverNo;
        this.serverAddress = serverAddress;
    }

    /**
     * 从map中获取
     * @param serverNo
     * @return
     */
    public static BackendServer getInstance(long serverNo) {
        return serverInstances.get(serverNo);
    }

    public BackendServer getRandomInstance() {
        Random r = new Random();
        int no = r.nextInt(SERVER_COUNT) + 1;
        return serverInstances.get(no);
    }

}
