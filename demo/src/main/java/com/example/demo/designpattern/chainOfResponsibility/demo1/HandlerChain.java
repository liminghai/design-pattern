package com.example.demo.designpattern.chainOfResponsibility.demo1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author limh
 * @version 2020年06月20日 16:42 limh Exp $
 */
public class HandlerChain {

    private List<IHandler> handlers = new ArrayList<>();

    public void addHandler(IHandler handler) {
        this.handlers.add(handler);
    }

    public void handle() {
        for (IHandler handler : handlers) {
            boolean handled = handler.handle();
            if (handled) {
                break;
            }
        }
    }
}
