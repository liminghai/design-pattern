package com.example.demo.designpattern.finiteStateMachine.demo3;

/**
 * 创建订单处理器
 *
 * @author limh
 * @version 2020年06月25日 20:10 limh Exp $
 */
public class CreateOrderProcessor extends AbstractOrderProcessor {

    public CreateOrderProcessor() {
        super.setStatus(OrderStatusEnum.CREATE_EVENT.status);
    }

    @Override
    public boolean process(String orderId, Object... params) {
        // TODO 创建/取消订单对应的数据库修改，mq发送等操作，可以在此处process方法中完成
        System.out.println("进入创建订单后处理器...");
        return true;
    }
}
