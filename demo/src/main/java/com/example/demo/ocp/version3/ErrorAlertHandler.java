package com.example.demo.ocp.version3;

import com.example.demo.ocp.AlertRule;
import com.example.demo.ocp.Notification;
import com.example.demo.ocp.Notification.NotificationEmergencyLevel;

/**
 * 错误数告警
 *
 * @author limh
 * @version 2020年04月16日 20:40 limh Exp $
 */
public class ErrorAlertHandler extends AlertHandler {

    public ErrorAlertHandler(AlertRule alertRule, Notification notification) {
        super(alertRule, notification);
    }

    /**
     * 当错误数超过阈值告警
     * @param apiStatInfo
     */
    @Override
    public void check(ApiStatInfo apiStatInfo) {
        long errorCount = apiStatInfo.getErrorCount();
        if (errorCount > getAlertRule().getMatchRule(apiStatInfo.getApi()).getMaxErrorCount()) {
            getNotification().notifyEmergency(NotificationEmergencyLevel.URGENCY, "URGENCY");
        }
    }
}
