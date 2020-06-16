package com.example.demo.designpattern.template.callback;

/**
 * @author limh
 * @version 2020年06月16日 10:52 limh Exp $
 */
public class AClass {

    public static void main(String[] args) {
        BClass bClass = new BClass();
        bClass.process(new ICallback() {
            @Override
            public void methodToCallback() {
                System.out.println("Call back me");
            }
        });
    }
}
