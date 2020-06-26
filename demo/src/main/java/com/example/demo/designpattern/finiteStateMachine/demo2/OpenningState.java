package com.example.demo.designpattern.finiteStateMachine.demo2;

/**
 * @author limh
 * @version 2020年06月25日 15:13 limh Exp $
 */
public class OpenningState extends LiftState {

    /**
     * 电梯门开启，这是开启状态要实现的动作
     */
    @Override
    public void open() {
        System.out.println("电梯门开启...");
    }

    @Override
    public void close() {
        //开启状态下当然可以关闭了，我就想测试一下电梯门开关功能
        //状态修改
        super.context.setLiftState(Context.closingState);
        //动作委托给context来执行
        super.context.getLiftState().close();
    }

    @Override
    public void run() {
        //门开着时电梯就运行，这电梯，吓死你
        //do nothing
    }

    @Override
    public void stop() {
        //开门还不停止?
        //do nothing
    }
}
