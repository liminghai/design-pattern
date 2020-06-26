package com.example.demo.designpattern.finiteStateMachine.demo3;

/**
 * 订单处理器
 * @author limh
 * @version 2020年06月25日 20:08 limh Exp $
 */
public abstract class AbstractOrderProcessor {

    int status;

    public abstract boolean process(String orderId, Object... params);

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
