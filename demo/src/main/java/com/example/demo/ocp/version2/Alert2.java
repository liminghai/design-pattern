package com.example.demo.ocp.version2;

import com.example.demo.ocp.AlertRule;
import com.example.demo.ocp.Notification;
import com.example.demo.ocp.Notification.NotificationEmergencyLevel;

/**
 * 告警：第一版
 * 如果我们需要添加一个功能，当每秒钟接口超时请求个数，超过某个预先设置的最大阈值时，我们也要触发告警发送通知。
 * 此时主要改动点有两处：
 * 第一处是check()函数的入参，添加一个新的统计数据timeoutCount，表示超时接口请求数
 * 第二处是在check()函数里面增加新的告警逻辑
 * 第三处在相应的单元测试也得修改
 *
 * @author limh
 * @version 2020年04月15日 20:52 limh Exp $
 */
public class Alert2 {

    private AlertRule alertRule;
    private Notification notification;

    public Alert2(AlertRule alertRule, Notification notification) {
        this.alertRule = alertRule;
        this.notification = notification;
    }

    /**
     * @param api
     * @param requestCount
     * @param errorCount
     * @param durationOfSeconds
     */
    /**
     * 改动点1：添加参数timeoutCount
     */
    public void check(String api, long requestCount, long errorCount, long durationOfSeconds, long timeoutCount) {
        long tps = requestCount / durationOfSeconds;

        /**
         * tps超过某个阈值
         */
        if (tps > alertRule.getMatchRule(api).getMaxTps()) {
            notification.notifyEmergency(NotificationEmergencyLevel.URGENCY, "URGENCY");
        }
        /**
         * 接口请求出错数超过阈值
         */
        if (errorCount > alertRule.getMatchRule(api).getMaxErrorCount()) {
            notification.notifyEmergency(NotificationEmergencyLevel.SEVERE, "SEVERE");
        }

        /**
         * 改动点2：添加超时处理逻辑
         */
        long timeoutTps = timeoutCount / durationOfSeconds;
        if (timeoutTps > alertRule.getMatchRule(api).getMaxTimeoutTps()) {
            notification.notifyEmergency(NotificationEmergencyLevel.URGENCY, "URGENCY");
        }
    }
}
