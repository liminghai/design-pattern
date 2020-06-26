package com.example.demo.designpattern.finiteStateMachine.demo3;

/**
 * 创建订单操作状态流转
 *
 * @author limh
 * @version 2020年06月25日 19:58 limh Exp $
 */
public class CreateOrderOperator extends AbstractOrderOperator {

    public CreateOrderOperator(){
        super.setStatus(OrderStatusEnum.CREATE_EVENT.status);
    }

    @Override
    public int handleEvent(int orderStatus, OrderStatusEnum orderStatusEnum) {

        //只处理订单创建和订单取消
        if (OrderStatusEnum.CREATE_EVENT.status != orderStatus
            && OrderStatusEnum.ORDER_CANCEL.status != orderStatus){
            throw new IllegalArgumentException("create operation can't handle the status:"+orderStatus);
        }

        System.out.println("进入创建订单状态扭转处理器...");
        switch (orderStatusEnum){
            case CREATE_EVENT:
                return OrderStatusEnum.FORMAL_EVENT.status;
            case ORDER_CANCEL:
                return OrderStatusEnum.CREATE_EVENT.status;
            default:
                return getStatus();
        }
    }
}
