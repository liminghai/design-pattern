package com.example.demo.designpattern.finiteStateMachine.demo3;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 订单状态流转管理器--状态机核心组件
 *
 * @author limh
 * @version 2020年06月25日 19:54 limh Exp $
 */
public class OrderStateManager {

    Map<Integer, AbstractOrderOperator> orderOperatorMap = new HashMap<>(64);
    Map<Integer, AbstractOrderProcessor> orderProcessorMap = new HashMap<>(64);

    public OrderStateManager() {}

    public int handleEvent(final String orderId, OrderStatusEnum event, final int status) {
        if (isFinalStatus(status)) {
            throw new IllegalArgumentException("handle event can't process final status order");
        }

        //获取对应处理器，根据入参状态和时间获取订单流程的结果状态
        AbstractOrderOperator orderOperator = this.getOrderOperator(event);
        int resState = orderOperator.handleEvent(status, event);
        //在对应的processor中处理订单数据及其相关信息
        AbstractOrderProcessor orderProcessor = this.getOrderProcessor(event);
        if (!orderProcessor.process(orderId, resState)){
            throw new IllegalArgumentException(String.format("订单状态流转失败，订单id:%s", orderId));
        }

        return resState;
    }

    /**
     * 根据入参状态枚举获取相应的状态处理器
     * @param event
     * @return
     */
    private AbstractOrderOperator getOrderOperator(OrderStatusEnum event) {
        AbstractOrderOperator operator = null;
        for (Map.Entry<Integer, AbstractOrderOperator> entry : orderOperatorMap.entrySet()) {
            if (event.status == entry.getKey()) {
                operator = entry.getValue();
            }
        }

        if (Objects.isNull(operator)) {
            throw new IllegalArgumentException(
                String.format("can't find proper operator. the parameter status : %s", event.toString()));
        }

        return operator;
    }

    /**
     * 根据入参状态枚举实例获取对应的状态后处理器
     * @param event
     * @return
     */
    private AbstractOrderProcessor getOrderProcessor(OrderStatusEnum event){
        AbstractOrderProcessor orderProcessor = null;
        for (Map.Entry<Integer, AbstractOrderProcessor> entry : orderProcessorMap.entrySet()) {
            if (event.status == entry.getKey()) {
                orderProcessor = entry.getValue();
            }
        }

        if (Objects.isNull(orderProcessor)) {
            throw new IllegalArgumentException(
                String.format("can't find proper operator. the parameter status : %s", event.toString()));
        }

        return orderProcessor;
    }

    /**
     * 判断是不是已完成的订单
     *
     * @param status
     * @return
     */
    private boolean isFinalStatus(int status) {
        return OrderStatusEnum.ORDER_FINISHED.status == status;
    }
}
