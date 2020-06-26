package com.example.demo.designpattern.finiteStateMachine.demo2;

/**
 * @author limh
 * @version 2020年06月25日 15:17 limh Exp $
 */
public class StoppingState extends LiftState{

    /**
     * 停止状态开门，那是必须的
     */
    @Override
    public void open() {
        super.context.setLiftState(Context.openningState);
        super.context.getLiftState().open();
    }

    /**
     * 停止状态关门？电梯门本来就是关着的
     */
    @Override
    public void close() {
        //do nothing
    }

    /**
     * 停止状态在运行起来，正常得很
     */
    @Override
    public void run() {
        super.context.setLiftState(Context.runningState);
        super.context.getLiftState().run();
    }

    /**
     * 停止状态要实现的动作
     */
    @Override
    public void stop() {
        System.out.println("电梯停止了...");
    }
}
