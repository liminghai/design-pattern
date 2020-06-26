package com.example.demo.designpattern.finiteStateMachine.demo3;

/**
 * @author limh
 * @version 2020年06月25日 19:47 limh Exp $
 */
public enum OrderStatusEnum {

    CREATE_EVENT(1, "创建订单"),
    FORMAL_EVENT(2, "正式订单"),
    NEED_PAY(3, "待支付"),
    PAY_DONE(4, "支付完成"),
    ORDER_FINISHED(5, "订单已完成"),

    ORDER_CANCEL(6, "订单取消"),

    ;
    OrderStatusEnum(int status, String desc){
        this.status = status;
        this.desc = desc;
    }

    public int status;
    public String desc;
}
