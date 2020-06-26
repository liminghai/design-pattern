package com.example.demo.designpattern.finiteStateMachine.demo3;

/**
 * @author limh
 * @version 2020年06月25日 19:57 limh Exp $
 */
public abstract class AbstractOrderOperator {

    int status;

    public abstract int handleEvent(int orderStatus, OrderStatusEnum orderStatusEnum);

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
