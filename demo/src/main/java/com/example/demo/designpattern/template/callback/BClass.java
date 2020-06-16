package com.example.demo.designpattern.template.callback;

/**
 * @author limh
 * @version 2020年06月16日 10:39 limh Exp $
 */
public class BClass {

    public void process(ICallback callback){
        // ....
        callback.methodToCallback();
        // ....
    }
}
