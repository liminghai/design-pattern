package com.example.demo.designpattern.finiteStateMachine.demo2;

/**
 * @author limh
 * @version 2020年06月25日 15:05 limh Exp $
 */
public abstract class LiftState {

    //定义一个环境角色，也就是封装状态的变化引起的功能变化
    protected Context context;

    public void setContext(Context context) {
        this.context = context;
    }

    //首先电梯门开启动作
    public abstract void open();
    //电梯门有开启，那当然也就有关闭了
    public abstract void close();
    //电梯要能上能下，运行起来
    public abstract void run();
    //电梯还能停止下来
    public abstract void stop();

}
