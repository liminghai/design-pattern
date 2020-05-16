package com.example.demo.ocp.version3;

import com.example.demo.ocp.AlertRule;
import com.example.demo.ocp.Notification;
import com.example.demo.ocp.Notification.NotificationEmergencyLevel;

/**
 * tps监控
 *
 * @author limh
 * @version 2020年04月16日 20:35 limh Exp $
 */
public class TpsAlertHandler extends AlertHandler {

    public TpsAlertHandler(AlertRule alertRule, Notification notification) {
        super(alertRule, notification);
    }

    /**
     * 当tps大于阈值时告警
     * @param apiStatInfo
     */
    @Override
    public void check(ApiStatInfo apiStatInfo) {
        long tps = apiStatInfo.getRequestCount() / apiStatInfo.getDurationOfSeconds();
        if (tps > this.getAlertRule().getMatchRule(apiStatInfo.getApi()).getMaxTimeoutTps()) {
            this.getNotification().notifyEmergency(NotificationEmergencyLevel.SEVERE, "SEVERE");
        }
    }
}
