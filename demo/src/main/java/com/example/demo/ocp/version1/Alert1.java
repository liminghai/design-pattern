package com.example.demo.ocp.version1;

import com.example.demo.ocp.AlertRule;
import com.example.demo.ocp.Notification;
import com.example.demo.ocp.Notification.NotificationEmergencyLevel;

/**
 * 告警：第一版
 * 如果我们需要添加一个功能，当每秒钟接口超时请求个数，超过某个预先设置的最大阈值时，我们也要触发告警发送通知。
 * 此时主要改动点有两处：
 *  第一处是check()函数的入参，添加一个新的统计数据timeoutCount，表示超时接口请求数
 *  第二处是在check()函数里面增加新的告警逻辑
 *
 * @author limh
 * @version 2020年04月15日 20:52 limh Exp $
 */
public class Alert1 {

    private AlertRule alertRule;
    private Notification notification;

    public Alert1(AlertRule alertRule, Notification notification) {
        this.alertRule = alertRule;
        this.notification = notification;
    }

    /**
     * @param api
     * @param requestCount
     * @param errorCount
     * @param durationOfSeconds
     */
    public void check(String api, long requestCount, long errorCount, long durationOfSeconds){
        long tps = requestCount/durationOfSeconds;

        /**
         * tps超过某个阈值
         */
        if (tps > alertRule.getMatchRule(api).getMaxTps()){
            notification.notifyEmergency(NotificationEmergencyLevel.URGENCY, "URGENCY");
        }
        /**
         * 接口请求出错数超过阈值
         */
        if (errorCount > alertRule.getMatchRule(api).getMaxErrorCount()){
            notification.notifyEmergency(NotificationEmergencyLevel.SEVERE, "SEVERE");
        }
    }
}
