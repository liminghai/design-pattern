package com.example.demo.designpattern.finiteStateMachine.demo2;

/**
 * @author limh
 * @version 2020年06月25日 15:17 limh Exp $
 */
public class ClosingState extends LiftState {

    /**
     * 电梯门关了再打开
     */
    @Override
    public void open() {
        super.context.setLiftState(Context.openningState);
        //委托给context来执行
        super.context.getLiftState().open();
    }

    /**
     * 电梯门关闭，这是关闭状态要实现的动作
     */
    @Override
    public void close() {
        System.out.println("电梯门关闭....");
    }

    /**
     * 电梯门关了就运行，这是再正常不过了
     */
    @Override
    public void run() {
        super.context.setLiftState(Context.runningState);
        super.context.getLiftState().run();
    }

    /**
     * 电梯门关着，我就不按楼层
     */
    @Override
    public void stop() {
        super.context.setLiftState(Context.stoppingState);
        super.context.getLiftState().stop();
    }
}
