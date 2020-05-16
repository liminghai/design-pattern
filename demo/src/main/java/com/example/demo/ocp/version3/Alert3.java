package com.example.demo.ocp.version3;

import java.util.ArrayList;
import java.util.List;

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
public class Alert3 {

    private List<AlertHandler> alertHandlers = new ArrayList<>();

    public void addAlertHandler(AlertHandler alertHandler) {
        this.alertHandlers.add(alertHandler);
    }

    /**
     * @param apiStatInfo
     */
    public void check(ApiStatInfo apiStatInfo) {
        for (AlertHandler alertHandler : alertHandlers){
            alertHandler.check(apiStatInfo);
        }
    }
}
