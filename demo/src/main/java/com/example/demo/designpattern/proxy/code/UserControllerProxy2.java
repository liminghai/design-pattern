package com.example.demo.designpattern.proxy.code;

/**
 * @author limh
 * @version 2020年05月25日 14:38 limh Exp $
 */
public class UserControllerProxy2 extends UserController {

    private MetricsCollector metricsCollector;

    public UserControllerProxy2() {
        this.metricsCollector = new MetricsCollector();
    }

    public UserVo login(String telephone, String password) {
        long startTimestamp = System.currentTimeMillis();

        // 通过super父类的方法
        UserVo userVo = super.login(telephone, password);

        // 织入
        long endTimeStamp = System.currentTimeMillis();
        long responseTime = endTimeStamp - startTimestamp;
        RequestInfo requestInfo = new RequestInfo("login", responseTime, startTimestamp);
        metricsCollector.recordRequest(requestInfo);
        return userVo;
    }
}
