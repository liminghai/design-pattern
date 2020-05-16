package com.example.demo.ocp.version3;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.ocp.AlertRule;
import com.example.demo.ocp.AlertRule.AlertRuleData;
import com.example.demo.ocp.Notification;

/**
 * 单例，负责Alert的创建，组装（alertRule和notification的依赖注入），初始化（添加handler）工作
 *
 * @author limh
 * @version 2020年04月16日 20:45 limh Exp $
 */
public class ApplicationContext {

    private AlertRule alertRule;
    private Notification notification;
    private Alert3 alert3;

    /**
     * 初始化bean
     */
    public void initializeBeans(){

        // 初始化alertRule和notification
        List<AlertRuleData> alertRuleDataList = new ArrayList<>();
        alertRule = new AlertRule(alertRuleDataList);
        notification = new Notification();

        alert3 = new Alert3();

        // 加入处理器
        alert3.addAlertHandler(new TpsAlertHandler(alertRule, notification));
        alert3.addAlertHandler(new ErrorAlertHandler(alertRule, notification));
    }

    public Alert3 getAlert3() {
        return alert3;
    }

    public void setAlert3(Alert3 alert3) {
        this.alert3 = alert3;
    }

    /**
     * 饿汉单例，初始化链路如下：
     * getInstance() -> ApplicationContext.applicationContext -> applicationContext.initializeBeans()
     */
    private static final ApplicationContext applicationContext = new ApplicationContext();

    public ApplicationContext(){
        applicationContext.initializeBeans();
    }

    public static ApplicationContext getInstance(){
        return ApplicationContext.applicationContext;
    }
}
