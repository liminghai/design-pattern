package com.example.demo.ocp.version3;

import com.example.demo.ocp.AlertRule;
import com.example.demo.ocp.Notification;

/**
 * 告警控制器
 *
 * @author limh
 * @version 2020年04月16日 20:30 limh Exp $
 */
public abstract class AlertHandler {

    private AlertRule alertRule;
    private Notification notification;

    public AlertHandler(AlertRule alertRule, Notification notification) {
        this.alertRule = alertRule;
        this.notification = notification;
    }

    public abstract void check(ApiStatInfo apiStatInfo);

    public AlertRule getAlertRule() {
        return alertRule;
    }

    public void setAlertRule(AlertRule alertRule) {
        this.alertRule = alertRule;
    }

    public Notification getNotification() {
        return notification;
    }

    public void setNotification(Notification notification) {
        this.notification = notification;
    }
}
