package com.example.demo.ocp;

/**
 * 告警类
 *
 * @author limh
 * @version 2020年04月15日 20:52 limh Exp $
 */
public class Notification {

    public void notifyEmergency(NotificationEmergencyLevel notificationEmergencyLevel, String msg) {
        System.out.println("notificationEmergencyLevel=" + notificationEmergencyLevel.name() + ",msg=" + msg);
    }

    public enum NotificationEmergencyLevel {
        URGENCY("URGENCY"),
        SEVERE("SEVERE");

        NotificationEmergencyLevel(String name) {
            this.name = name;
        }

        private String name;
    }
}
