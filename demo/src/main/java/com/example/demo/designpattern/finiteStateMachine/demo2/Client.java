package com.example.demo.designpattern.finiteStateMachine.demo2;

/**
 * 场景类
 * @author limh
 * @version 2020年06月25日 15:46 limh Exp $
 */
public class Client {

    public static void main(String[] args){
        Context context = new Context();
        context.setLiftState(new ClosingState());

        context.open();
        context.close();
        context.run();
        context.stop();
    }
}
