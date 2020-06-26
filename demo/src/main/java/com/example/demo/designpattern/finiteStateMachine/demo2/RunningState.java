package com.example.demo.designpattern.finiteStateMachine.demo2;

/**
 * @author limh
 * @version 2020年06月25日 15:17 limh Exp $
 */
public class RunningState extends LiftState{

    /**
     * 运行的时候开电梯门？你疯了吧，电梯不会给你开的
     */
    @Override
    public void open() {
        //do nothing
    }

    /**
     * 运行状态下，电梯门肯定是关闭的
     */
    @Override
    public void close() {
        //do nothing
    }

    /**
     * 这是电梯运行下要实现的方法
     */
    @Override
    public void run() {
        System.out.println("电梯上下运行...");
    }

    /**
     * 这绝对是合理的，只运行不停止还有谁敢坐这个电梯？估计只有上帝了
     */
    @Override
    public void stop() {
        //环境变量设置为停止状态
        super.context.setLiftState(Context.closingState);
        super.context.getLiftState().stop();
    }
}
