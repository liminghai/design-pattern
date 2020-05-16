package com.example.demo.ocp;

import java.util.List;

/**
 * 告警规则
 *
 * @author limh
 * @version 2020年04月14日 21:00 limh Exp $
 */
public class AlertRule {

    public AlertRule(List<AlertRuleData> alertRuleDataList) {
        this.alertRuleDataList = alertRuleDataList;
    }

    private List<AlertRuleData> alertRuleDataList;

    /**
     * 根据api找出匹配的规则
     * @param api
     * @return
     */
    public AlertRuleData getMatchRule(String api) {
        for (AlertRuleData alertRuleData : alertRuleDataList) {
            if (alertRuleData.getApi().equals(api)) {
                return alertRuleData;
            }
        }
        return null;
    }

    public class AlertRuleData {
        /**
         * api接口
         */
        private String api;
        /**
         * 最大tps
         */
        private int maxTps;
        /**
         * 最大errorCount
         */
        private int maxErrorCount;
        /**
         * 接口超时
         */
        private int maxTimeoutTps;

        public String getApi() {
            return api;
        }

        public void setApi(String api) {
            this.api = api;
        }

        public int getMaxTps() {
            return maxTps;
        }

        public void setMaxTps(int maxTps) {
            this.maxTps = maxTps;
        }

        public int getMaxErrorCount() {
            return maxErrorCount;
        }

        public void setMaxErrorCount(int maxErrorCount) {
            this.maxErrorCount = maxErrorCount;
        }

        public int getMaxTimeoutTps() {
            return maxTimeoutTps;
        }

        public void setMaxTimeoutTps(int maxTimeoutTps) {
            this.maxTimeoutTps = maxTimeoutTps;
        }
    }

    public List<AlertRuleData> getAlertRuleDataList() {
        return alertRuleDataList;
    }

    public void setAlertRuleDataList(List<AlertRuleData> alertRuleDataList) {
        this.alertRuleDataList = alertRuleDataList;
    }
}
