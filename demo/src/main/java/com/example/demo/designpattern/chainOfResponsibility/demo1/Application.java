package com.example.demo.designpattern.chainOfResponsibility.demo1;

/**
 * @author limh
 * @version 2020年06月20日 16:45 limh Exp $
 */
public class Application {

    public static void main(String[] args) {
        HandlerChain handlerChain = new HandlerChain();
        handlerChain.addHandler(new HandlerA());
        handlerChain.addHandler(new HandlerB());

        handlerChain.handle();
    }
}
